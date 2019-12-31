package service;


import grpc.TheClient;
import grpc.clientGrpc;
import grpc_seeder.GrpcSeeder;
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
import raftus.SeederStore;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class GrpcClientServices extends clientGrpc.clientImplBase {
    @Override
    public void seedersList(TheClient.SeedersListRequest request, StreamObserver<TheClient.SeedersListResponse> responseObserver) {
        //super.seedersList(request, responseObserver);

        TheClient.SeedersListResponse.Builder response = TheClient.SeedersListResponse.newBuilder();
        System.out.println("seedersList");

        //TODO read all files in movies folder

        File folder = new File("/home/artfer/");
        File[] listOfFiles = folder.listFiles();

        String str = "";

        for (File file : listOfFiles)
            if(file.isFile())
                str += file.getName() + "\n";

        response.setSeeders(str);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void seederSearchKeyword(TheClient.SeederSearchKeywordRequest request, StreamObserver<TheClient.SeederSearchKeywordResponse> responseObserver) {
//        super.seederSearchKeyword(request, responseObserver);
        String keyword = request.getKeyword();

        TheClient.SeederSearchKeywordResponse.Builder response = TheClient.SeederSearchKeywordResponse.newBuilder();

        //TODO send info to raft

        System.out.println("seederSearchKeyword");
        //CODIGO
        response.setSeeders("seederSearchKeyword");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    static int portTest;

    @Override
    public void downloadFile(TheClient.DownloadFileRequest request, StreamObserver<TheClient.DownloadFileResponse> responseObserver) {
        //super.downloadFile(request, responseObserver);

        System.out.println("downloadFile");

        String title = request.getFile();

        if (movieExists(title)) {

            TheClient.DownloadFileResponse.Builder response = TheClient.DownloadFileResponse.newBuilder();

            //TODO send info to raft

            CopycatClient client = CopycatClient.builder()
                    .withTransport(NettyTransport.builder()
                            .withThreads(2)
                            .build())
                    .build();

            Address clusterAddress = new Address("localhost", 5000);
            client.connect(clusterAddress).join();

            try {
                SeederStore seederStore = (SeederStore) client.submit(new Get(title)).get();
                int resPort;
                if(seederStore != null){
                    resPort = seederStore.getPort();
                }else{
                    System.out.println("creating new seeder");
//
                    resPort = FreePortFinder.findFreeLocalPort();
                    SeederStore tmp = new SeederStore();
                    tmp.setPort(resPort);

                    client.submit(new Put(title,tmp));
                    GrpcSeeder seeder = new GrpcSeeder(resPort, getFileName(title));
                    seeder.run();
                }

                System.out.println("Port: " + resPort);
                response.setPort(resPort);
                responseObserver.onNext(response.build());
                responseObserver.onCompleted();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

//            client.submit(new Get(title)).thenAccept(result -> {
//                System.out.println(result);
//
//                int resPort = 0;
//
//                if (result == null) {
//
//                    System.out.println("creating new seeder");
//
//                    resPort = FreePortFinder.findFreeLocalPort();
//                    SeederStore tmp = new SeederStore();
//                    tmp.setPort(resPort);
//
//                    client.submit(new Put(title,tmp));
//
//                    //TODO create seeder server
//
//                    GrpcSeeder seeder = new GrpcSeeder(resPort);
//                    seeder.run();
//
//                } else {
//
//                    System.out.println("reply to client");
//
//                    resPort = ((SeederStore) result).getPort();
//                }
//
//                System.out.println(resPort);
//
//                portTest = resPort;
//            });
//            System.out.println("Test port");
//            response.setPort(portTest);
//            responseObserver.onNext(response.build());
//            responseObserver.onCompleted();

        /*
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();

            //CODIGO
            Random rand = new Random();
            response.setIp(inetAddress.getHostAddress()).setPort(rand.nextInt());
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();

        } catch(UnknownHostException e){
            System.out.println("No host found");
            return;
        }
        */
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
                    str += "Size : " + obj.get("size").toString() + "\n";

                    response.setInfo(str);
                    responseObserver.onNext(response.build());
                    responseObserver.onCompleted();
                    break;
                }
            }
        } catch (Exception e){
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

}
