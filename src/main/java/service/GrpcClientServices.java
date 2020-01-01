package service;


import torrent.Seeder;
import grpc.TheClient;
import grpc.clientGrpc;
import io.grpc.stub.StreamObserver;
import me.alexpanov.net.FreePortFinder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class GrpcClientServices extends clientGrpc.clientImplBase {
    @Override
    public void seedersList(TheClient.SeedersListRequest request, StreamObserver<TheClient.SeedersListResponse> responseObserver) {

        System.out.println("SeedersList Request Start");

        TheClient.SeedersListResponse.Builder response = TheClient.SeedersListResponse.newBuilder();

        File folder = new File(getPath());
        File[] listOfFiles = folder.listFiles();

        String str = "";

        JSONParser jsonParser = new JSONParser();

        //Parsing the contents of the JSON file
        try {
            int count = 0;
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("src/main/resources/Dataset/data.json"));
            for( int i = 0 ; i < jsonArray.size(); i++) {
                JSONObject obj = (JSONObject) jsonArray.get(i);
                str += obj.get("title").toString() + "\n";
            }
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

        System.out.println("SeedersList Request End \n");
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

            //TODO send info to raft

            int resPort;
            resPort = FreePortFinder.findFreeLocalPort();
            Seeder seeder = new Seeder(resPort,getFileName(title));
            System.out.println("running seeder");
            seeder.start();

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

    private String getPath(){
        String path;
        switch (System.getProperty("os.name")){
            case "Linux":
                path = "/home/" + System.getProperty("user.name") + "/Videos/";
                break;
            case "Mac OS X":
                path = "/Users/" + System.getProperty("user.name") + "/Movies/";
                break;
            default:
                path = "C:\\Users\\" + System.getProperty("user.name") + "\\Videos\\";
                break;
        }
        return path;
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


}
