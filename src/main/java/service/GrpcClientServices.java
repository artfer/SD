package service;


import grpc.Client;
import grpc.clientGrpc;
import io.grpc.stub.StreamObserver;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;


public class GrpcClientServices extends clientGrpc.clientImplBase {
    @Override
    public void seedersList(Client.SeedersListRequest request, StreamObserver<Client.SeedersListResponse> responseObserver) {
        //super.seedersList(request, responseObserver);

        Client.SeedersListResponse.Builder response = Client.SeedersListResponse.newBuilder();
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
    public void seederSearchKeyword(Client.SeederSearchKeywordRequest request, StreamObserver<Client.SeederSearchKeywordResponse> responseObserver) {
//        super.seederSearchKeyword(request, responseObserver);
        String keyword = request.getKeyword();

        Client.SeederSearchKeywordResponse.Builder response = Client.SeederSearchKeywordResponse.newBuilder();

        //TODO send info to raft

        System.out.println("seederSearchKeyword");
        //CODIGO
        response.setSeeders("seederSearchKeyword");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void downloadFile(Client.DownloadFileRequest request, StreamObserver<Client.DownloadFileResponse> responseObserver) {
        //super.downloadFile(request, responseObserver);
        String fileName = request.getFile();

        Client.DownloadFileResponse.Builder response = Client.DownloadFileResponse.newBuilder();

        //TODO send info to raft

        System.out.println("downloadFile");

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

    }

    @Override
    public void infoFile(Client.InfoFileRequest request, StreamObserver<Client.InfoFileResponse> responseObserver) {
        //super.infoFile(request, responseObserver);

        Client.InfoFileResponse.Builder response = Client.InfoFileResponse.newBuilder();

        String title = request.getFile();

        JSONParser jsonParser = new JSONParser();

        System.out.println(System.getProperty("user.dir"));

        //Parsing the contents of the JSON file
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("src/main/resources/Dataset/data.json"));
            for( int i = 0 ; i < jsonArray.size(); i++){
                JSONObject obj = (JSONObject) jsonArray.get(i);
                if(obj.get("file_name").toString().compareTo(title) == 0){
                    String str = "";
                    str += "Title : " + obj.get("title").toString() + "\n";
                    str += "Tags : " + obj.get("tags").toString() + "\n";
                    str += "Year : " + obj.get("year").toString() + "\n";
                    str += "Duration : "  + obj.get("duration").toString() + "\n";
                    str += "Size : " + obj.get("size").toString() + "\n";

                    response.setInfo(str);
                    responseObserver.onNext(response.build());
                    responseObserver.onCompleted();
                }
            }
        } catch (Exception e){
            System.err.println(e);
        }



    }
}
