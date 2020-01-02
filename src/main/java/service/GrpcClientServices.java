package service;


import grpc.TheClient;
import grpc.clientGrpc;
import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.netty.NettyTransport;
import io.atomix.copycat.client.CopycatClient;
import io.grpc.stub.StreamObserver;
import me.alexpanov.net.FreePortFinder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import raftus.Get;
import raftus.Put;
import torrent.Seeder;

import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class GrpcClientServices extends clientGrpc.clientImplBase {
    @Override
    public void seedersList(TheClient.SeedersListRequest request, StreamObserver<TheClient.SeedersListResponse> responseObserver) {

        System.out.println("SeedersList Request Start");

        TheClient.SeedersListResponse.Builder response = TheClient.SeedersListResponse.newBuilder();

        String str = "";

        JSONParser jsonParser = new JSONParser();
        CopycatClient client = getCopycatClient();
        Object tmp;

        //Parsing the contents of the JSON file
        try {
            int count = 0;
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("src/main/resources/Dataset/data.json"));
            for( int i = 0 ; i < jsonArray.size(); i++) {
                JSONObject obj = (JSONObject) jsonArray.get(i);
                str += obj.get("title").toString();


                tmp = get(client, obj.get("title").toString());
                if(tmp != null){
                    str += " (seeding)\n";
                } else {
                    str += " (not seeding)\n";
                }
            }
            response.setSeeders(str);
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            System.out.println("SeedersList Request End \n");
            return;
        } catch (Exception e) {
            System.err.println(e);
        }

        response.setSeeders("Dataset not found");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void seederSearchKeyword(TheClient.SeederSearchKeywordRequest request, StreamObserver<TheClient.SeederSearchKeywordResponse> responseObserver) {
//        super.seederSearchKeyword(request, responseObserver);
        String keyword = request.getKeyword();

        TheClient.SeederSearchKeywordResponse.Builder response = TheClient.SeederSearchKeywordResponse.newBuilder();

        JSONParser jsonParser = new JSONParser();


        try {
            int count = 0;
            String str = "";
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("src/main/resources/Dataset/data.json"));
            for( int i = 0 ; i < jsonArray.size(); i++){
                JSONObject obj = (JSONObject) jsonArray.get(i);
                if(obj.get("tags").toString().contains(keyword)) {
                    str += "\t" + obj.get("title").toString() + "\n";
                    count++;
                }
            }
            str = "Found " + count + " results\n" + str;
            response.setSeeders(str);
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            return;
        } catch (Exception e) {
            System.err.println(e);
        }
        response.setSeeders("Dataset not found");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void downloadFile(TheClient.DownloadFileRequest request, StreamObserver<TheClient.DownloadFileResponse> responseObserver) {

        String title = request.getFile();

        if (movieExists(title)) {

            TheClient.DownloadFileResponse.Builder response = TheClient.DownloadFileResponse.newBuilder();


            int resPort;

            CopycatClient client = getCopycatClient();

            Object tmp = get(client,title);
            if(tmp == null){
                resPort = FreePortFinder.findFreeLocalPort();

                tmp = resPort;
                client.submit(new Put(title, tmp));

                Seeder seeder = new Seeder(resPort,getFileName(title));
                seeder.start();

                System.out.println("running new seeder");

            } else {
                resPort = (int) tmp;

                if(isPortAvailable(resPort)){
                    Seeder seeder = new Seeder(resPort,getFileName(title));
                    seeder.start();
                    System.out.println("running new seeder");
                } else {
                    System.out.println("returning existing seeder");
                }
            }

            closeCopycatClient(client);

            System.out.println("Port: " + resPort);
            response.setFileSize(getFileSize(title));
            response.setPort(resPort);
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();

        }
    }

    @Override
    public void infoFile(TheClient.InfoFileRequest request, StreamObserver<TheClient.InfoFileResponse> responseObserver) {
        //super.infoFile(request, responseObserver);

        TheClient.InfoFileResponse.Builder response = TheClient.InfoFileResponse.newBuilder();

        String title = request.getFile();

        JSONParser jsonParser = new JSONParser();

        System.out.println(System.getProperty("user.dir"));

        //Parsing the contents of the JSON file
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("src/main/resources/Dataset/data.json"));
            for( int i = 0 ; i < jsonArray.size(); i++){
                JSONObject obj = (JSONObject) jsonArray.get(i);
                if(obj.get("title").toString().compareTo(title) == 0){
                    String str = "";
                    str += "Title : " + obj.get("title").toString() + "\n";
                    str += "Tags : " + obj.get("tags").toString() + "\n";
                    str += "Year : " + obj.get("year").toString() + "\n";
                    str += "Duration : "  + obj.get("duration").toString() + "\n";
                    str += "Size : " + (Integer.parseInt(obj.get("size").toString()) / (1024 * 1024)) + "MB\n";

                    response.setInfo(str);
                    responseObserver.onNext(response.build());
                    responseObserver.onCompleted();
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }


    private boolean movieExists(String title)  {

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) jsonParser.parse(new FileReader("src/main/resources/Dataset/data.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for( int i = 0 ; i < jsonArray.size(); i++) {
            JSONObject obj = (JSONObject) jsonArray.get(i);
            if (obj.get("title").toString().compareTo(title) == 0)
                return true;
        }
        return false;
    }

    private String getFileName(String title)  {

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) jsonParser.parse(new FileReader("src/main/resources/Dataset/data.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for( int i = 0 ; i < jsonArray.size(); i++) {
            JSONObject obj = (JSONObject) jsonArray.get(i);
            if (obj.get("title").toString().compareTo(title) == 0)
                return obj.get("file_name").toString();
        }
        return "";
    }

    private int getFileSize(String title)  {

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) jsonParser.parse(new FileReader("src/main/resources/Dataset/data.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for( int i = 0 ; i < jsonArray.size(); i++) {
            JSONObject obj = (JSONObject) jsonArray.get(i);
            if (obj.get("title").toString().compareTo(title) == 0)
                return Integer.parseInt(obj.get("size").toString());
        }
        return 0;
    }

    private CopycatClient getCopycatClient(){
        CopycatClient client = CopycatClient.builder()
                .withTransport(NettyTransport.builder()
                        .withThreads(1)
                        .build())
                .build();

        Address clusterAddress = new Address("localhost", 5000);
        client.connect(clusterAddress).join();
        return client;
    }


    private void closeCopycatClient(CopycatClient client){
        client.close();
    }

    private void put(CopycatClient client,String key, int value){

        try {
            CompletableFuture<Object> future = client.submit(new Put(key, value));
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private Object get(CopycatClient client,String key){
        try {
            CompletableFuture<Object> future = client.submit(new Get(key));
            return future.get();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private boolean isPortAvailable(int port){
        try (Socket s = new Socket("localhost", port)) {
            return true;
        } catch (IOException ex) {
            /* ignore */
        }
        return false;
    }







}
