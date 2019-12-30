package grpc_client;

import grpc.Client;
import grpc.clientGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.File;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GrpcClient {

        static String  name = "localhost";
        static int port = 8989;

    public static void showMenu(){
        System.out.println("0: Menu");
        System.out.println("1: Seeder list");
        System.out.println("2: Seeder search by Keyword [words]");
        System.out.println("3: Download [file name]");
        System.out.println("4: List files");
        System.out.println("5: Info [file name]");
        System.out.println("6: Play [file name]");
        System.out.println("7: Exit");
    }

    public static void seederList(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        clientGrpc.clientBlockingStub clientStub = clientGrpc.newBlockingStub(channel);

        Client.SeedersListRequest seedersListRequest = Client.SeedersListRequest.newBuilder()
                                                        .build();

        Client.SeedersListResponse response = clientStub.seedersList(seedersListRequest);
        System.out.println(response.getSeeders());

    }

    public static void searchByKeyword(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        clientGrpc.clientBlockingStub clientStub = clientGrpc.newBlockingStub(channel);

        System.out.println("Keyword/s:");
        Scanner sca = new Scanner(System.in);
        String keyword = sca.nextLine();

        Client.SeederSearchKeywordRequest seederSearchKeywordRequest = Client.SeederSearchKeywordRequest
                                                                        .newBuilder()
                                                                        .setKeyword(keyword)
                                                                        .build();
    }

    public static void downloadFile(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        clientGrpc.clientBlockingStub clientStub = clientGrpc.newBlockingStub(channel);

        System.out.println("File Name: ");
        Scanner sca = new Scanner(System.in);
        String fileName = sca.nextLine();

        Client.DownloadFileRequest downloadFileRequest = Client.DownloadFileRequest
                                                                .newBuilder()
                                                                .setFile(fileName)
                                                                .build();
    }


    public static void listFiles(){

        System.out.println("Files encountered:");
    }

    public static void infoFile(){

        System.out.println("File Name: ");

        Scanner sca = new Scanner(System.in);
        String fileName = sca.nextLine();

        String user = System.getProperty("user.name");
        String filePath = "/home/"+user+"/Downloads/";
        filePath += fileName;

        File file = new File(filePath);

        if (file.exists()) {

            System.out.println("File information of " + fileName + ":");


        } else {
            System.err.println("File does not exist");
        }

        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        clientGrpc.clientBlockingStub clientStub = clientGrpc.newBlockingStub(channel);

        Client.InfoFileRequest infoFileRequest = Client
                .InfoFileRequest
                .newBuilder()
                .setFile(fileName)
                .build();

        Client.InfoFileResponse response = clientStub.infoFile(infoFileRequest);
        String str = response.getInfo();
        System.out.println(str);






    }

    public static void play(){

        System.out.println("File Name: ");
        Scanner sca = new Scanner(System.in);
        String fileName = sca.nextLine();

        System.out.println("Playing file " + fileName + ":");
    }


    public static void main(String[] args) throws UnknownHostException {

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
                default:{ }
            }
            if(loop)
                command = sca.nextInt();
        }

        System.out.println("Exit client");
        System.exit(0);

    }

}
