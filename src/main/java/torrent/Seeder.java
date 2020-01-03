package torrent;

import grpc.SeederServer;
import grpc.seeder_serverGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Seeder extends Thread {

    int port;
    String file;

    public Seeder(int port, String file){
        super();
        this.port = port;
        this.file = file;
    }

    public void run(){

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();

        }

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8989).usePlaintext().build();
        seeder_serverGrpc.seeder_serverBlockingStub seeder_serverStub = seeder_serverGrpc.newBlockingStub(channel);

        SeederServer.registerRequest registerRequest = SeederServer.registerRequest
                .newBuilder()
                .setFile(file)
                .setPort(port)
                .build();

        System.out.println("not a seeder");
        //seeder_serverStub.register(registerRequest);
        System.out.println("im a seeder");

        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }

            System.out.println("New Upload request");
            new Upload(socket,file,port).start();
        }
    }
}
