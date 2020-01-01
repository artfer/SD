package Torrent;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Download extends Thread {

    String ip;
    int port;
    String file;
    String path;


    public Download(String ip, int port, String file){
        super();
        this.ip = ip;
        this.port = port;
        this.file = file;
        this.path = "/home/artfer/Downloads/";
    }

    public void run(){


        try {

            System.out.println("Starting");
            Socket socket = new Socket(ip,port);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            FileOutputStream fos = new FileOutputStream(path+file+".mp4");
            byte[] buffer = new byte[4096];

            int filesize = 28211605; // Send file size in separate msg
            int read = 0;
            int totalRead = 0;
            int remaining = filesize;
            while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
                totalRead += read;
                remaining -= read;
                System.out.println("read " + totalRead + " bytes.");
                fos.write(buffer, 0, read);
            }

            fos.close();
            dis.close();

            System.out.println("Ending");

        } catch (IOException e){
            System.err.println(e);
        }
    }
}
