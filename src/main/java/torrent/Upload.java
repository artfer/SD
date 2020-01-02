package torrent;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Upload extends Thread {

    private Socket socket;
    private String file;
    private String path;
    private int port;

    public Upload(Socket socket, String file,int port) {
        this.socket = socket;
        this.file = file;
        this.path = getPath();
        this.port = port;
    }

    public void run(){

        try {
            System.out.println("Start upload");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            FileInputStream fis = new FileInputStream(path+file);
            byte[] buffer = new byte[4096];

            while (fis.read(buffer) > 0) {
                dos.write(buffer);
            }

            fis.close();
            dos.close();

            System.out.println("File transfer complete");

        } catch (IOException e){
            System.err.println(e);
        }
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

}
