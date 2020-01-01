package torrent;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Download extends Thread {

    String ip;
    int port;
    String filePath;
    int fileSize;


    public Download(String ip, int port, String filePath, int fileSize){
        super();
        this.ip = ip;
        this.port = port;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    public void run(){

        try {

            System.out.println("Starting Download...");
            Socket socket = new Socket(ip,port);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            FileOutputStream fos = new FileOutputStream(filePath);
            byte[] buffer = new byte[4096];

            //TODO Encript packets
            int remaining = fileSize;
            int read = 0;

            while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
                remaining -= read;
                fos.write(buffer, 0, read);
            }

            fos.close();
            dis.close();

            System.out.println("Download ended.");

        } catch (IOException e){
            System.err.println(e);
        }
    }
}
