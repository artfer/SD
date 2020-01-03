package grpc_client;


import torrent.Download;
import grpc.TheClient;
import grpc.clientGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class GrpcClient {

    static String  name = "35.241.190.139";
    static int port = 80;

    public static void showMenu(){
        System.out.println("0: Menu");
        System.out.println("1: Video list");
        System.out.println("2: Search by [keyword]");
        System.out.println("3: Download [file]");
        System.out.println("4: List files");
        System.out.println("5: Info [file]");
        System.out.println("6: Play [file]");
        System.out.println("7: Exit");
    }

    public static void seederList(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        clientGrpc.clientBlockingStub clientStub = clientGrpc.newBlockingStub(channel);

        TheClient.SeedersListRequest seedersListRequest = TheClient.SeedersListRequest.newBuilder()
                .build();

        TheClient.SeedersListResponse response = clientStub.seedersList(seedersListRequest);
        System.out.println(response.getSeeders());

    }

    public static void searchByKeyword(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        clientGrpc.clientBlockingStub clientStub = clientGrpc.newBlockingStub(channel);

        System.out.println("Keyword/s:");
        Scanner sca = new Scanner(System.in);
        String keyword = sca.nextLine();

        TheClient.SeederSearchKeywordRequest seederSearchKeywordRequest = TheClient.SeederSearchKeywordRequest
                .newBuilder()
                .setKeyword(keyword)
                .build();

        TheClient.SeederSearchKeywordResponse response = clientStub.seederSearchKeyword(seederSearchKeywordRequest);
        System.out.println(response.getSeeders());
    }

    public static void downloadFile(){

        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        clientGrpc.clientBlockingStub clientStub = clientGrpc.newBlockingStub(channel);

        System.out.println("File Name: ");
        Scanner sca = new Scanner(System.in);
        String fileName = sca.nextLine();

        String trueFileName = fileName.replace(" ","_") + ".mp4";
        trueFileName = filePath + trueFileName;
        File file = new File(trueFileName);

        if(file.exists()){
            System.out.println("File already exists, no need to download.");
        } else {

            TheClient.DownloadFileRequest downloadFileRequest = TheClient.DownloadFileRequest
                    .newBuilder()
                    .setFile(fileName)
                    .build();

            TheClient.DownloadFileResponse response = clientStub.downloadFile(downloadFileRequest);
            int seederPort = response.getPort();
            if(seederPort != 0) {
                System.out.println(seederPort);
                Download download = new Download(name, seederPort, trueFileName, response.getFileSize());
                download.start();
            } else {
                System.out.println("File doesn't exist");
            }

        }


    }


    public static void listFiles(){

        System.out.println("Files encountered:");

        File dir = new File(filePath);
        for (File file : dir.listFiles()){
            System.out.println(file.getName());
        }

    }

    public static void infoFile(){

        System.out.println("File Name: ");

        Scanner sca = new Scanner(System.in);
        String fileName = sca.nextLine();

        String trueFileName = fileName.replace(" ","_") + ".mp4";
        trueFileName = filePath + trueFileName;
        File file = new File(trueFileName);

        if (file.exists()) {

            System.out.println("File information of " + fileName + ":");

            ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
            clientGrpc.clientBlockingStub clientStub = clientGrpc.newBlockingStub(channel);

            TheClient.InfoFileRequest infoFileRequest = TheClient
                    .InfoFileRequest
                    .newBuilder()
                    .setFile(fileName)
                    .build();

            TheClient.InfoFileResponse response = clientStub.infoFile(infoFileRequest);
            String str = response.getInfo();

            System.out.println(str);



        } else {
            System.err.println("File does not exist");
        }
    }

    public static void play() throws IOException {

        System.out.println("File Name: ");
        Scanner sca = new Scanner(System.in);
        String fileName = sca.nextLine().trim();
        System.out.println("Playing file " + fileName);

        fileName = fileName.replace(" ","_") + ".mp4";
        fileName = filePath + fileName;

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("ffplay",fileName);
        processBuilder.start();

    }


    private static String filePath;

    public static void main(String[] args) throws IOException {

        switch (System.getProperty("os.name")){
            case "Linux":
                filePath = "/home/" + System.getProperty("user.name") + "/Downloads/EdgeNetflix/";
                break;
            case "Mac OS X":
                filePath = "/Users/" + System.getProperty("user.name") + "/Downloads/EdgeNetflix/";
                break;
            default:
                filePath = "C:\\Users\\" + System.getProperty("user.name") + "\\Downloads\\EdgeNetflix\\";
                break;
        }

        File dir = new File(filePath);
        if (!dir.exists())
            dir.mkdir();


        int command = 0;
        boolean loop = true;
        System.out.println("Enter with your command");
        Scanner sca = new Scanner(System.in);
        while(loop){
            switch(command){
                case 0:{ showMenu(); } break;
                case 1:{ seederList(); } break;
                case 2:{ searchByKeyword(); } break;
                case 3:{ downloadFile(); } break;
                case 4:{ listFiles(); } break;
                case 5:{ infoFile(); } break;
                case 6:{ play(); } break;
                case 7:{ loop = false; } break;
                default:{
                    System.out.println("Not a valid option. Please select one of the following:");
                    showMenu();
                }
            }
            if(loop) {
                command = sca.nextInt();
            }
        }

        System.out.println("Exit client");
        System.exit(0);

    }

}
