package Torrent;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Seeder extends Thread {

    int port;
    String file;
    String path;

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
        while (true) {
            try {

                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client

            System.out.println("New Upload request");
            new Upload(socket,file,port).start();
        }
    }
}
