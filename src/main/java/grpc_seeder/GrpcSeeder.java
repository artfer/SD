package grpc_seeder;


import bt.Bt;
import bt.BtClientBuilder;
import bt.data.Storage;
import bt.data.file.FileSystemStorage;
import bt.dht.DHTConfig;
import bt.dht.DHTModule;
import bt.runtime.BtClient;
import bt.runtime.Config;
import com.google.inject.Module;
import com.turn.ttorrent.common.Peer;
import com.turn.ttorrent.common.Torrent;
import com.turn.ttorrent.tracker.TrackedPeer;
import com.turn.ttorrent.tracker.TrackedTorrent;
import com.turn.ttorrent.tracker.Tracker;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GrpcSeeder extends Thread {

    int port;
    String file;
    String path;

    public GrpcSeeder(int port, String file){
        super();
        this.port = port;
        this.file = file;
        this.path = "/Users/lucparada/Movies/";
    }

    public void run(){





        // enable multithreaded verification of torrent data
        Config config = new Config() {
            @Override
            public int getNumOfHashingThreads() {
                return Runtime.getRuntime().availableProcessors() * 2;
            }
        };

// enable bootstrapping from public routers
        Module dhtModule = new DHTModule(new DHTConfig() {
            @Override
            public boolean shouldUseRouterBootstrap() {
                return true;
            }
        });

// get download directory
        Path targetDirectory = Paths.get(System.getProperty("user.home"), "Downloads");

// create file system based backend for torrent data
        Storage storage = new FileSystemStorage(targetDirectory);
// create client with a private runtime
        BtClient client = Bt.client()
                .config(config)
                .storage(storage)
                .magnet("magnet:?xt=urn:btih:af0d9aa01a9ae123a73802cfa58ccaf355eb19f1")
                .autoLoadModules()
                .module(dhtModule)
                .stopWhenDownloaded()
                .build();

// launch
        client.startAsync();
        return;
//
//
//
//
//
//








//        try {
//
//            System.out.println(path + file);
//            Tracker tracker = new Tracker(InetAddress.getLocalHost());
//
//            tracker.start();
//            Torrent torrent = Torrent.create(new File(path+file), tracker.getAnnounceUrl().toURI(), "estuplexo");
//
//            System.out.println("1");
//
//            TrackedTorrent trackedTorrent = new TrackedTorrent(torrent);
//            //tracker.announce(trackedTorrent);
//            System.out.println("2");
//            Peer peer = new Peer(new InetSocketAddress(port));
//            peer.setPeerId(ByteBuffer.wrap(new byte[5]));
//            System.out.println("3");
//            TrackedPeer trackedPeer = new TrackedPeer(trackedTorrent,"127.0.0.1",port,peer.getPeerId());
//            System.out.println("4");
//            System.out.println(trackedTorrent.getPeers().toString());
//            System.out.println("5");
//            trackedTorrent.addPeer(trackedPeer);
//            System.out.println("6");
//            FileOutputStream fos = new FileOutputStream( path + file.split(  "\\.")[0] + ".torrent");
//            System.out.println("7");
//            //torrent.save(fos);
//            trackedTorrent.save(fos);
//            System.out.println("8");
//            fos.close();
//
//        } catch (Exception e){
//            System.out.println(e.toString());
//        }

//        String name = "localhost";
//
//        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
//
//        InetAddress inetAddress = null;
//        try {
//            inetAddress = InetAddress.getLocalHost();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }

//        seederGrpc.seederBlockingStub seederStub = seederGrpc.newBlockingStub(channel);
//        Seeder.RegisterRequest registerRequest = Seeder.RegisterRequest.newBuilder()
//                .setIp(inetAddress.getHostAddress())
//                .setPort("4575")
//                .build();
//
//        Seeder.RegisterResponse response = seederStub.register(registerRequest);
//        System.out.println(response.getResponse());
//
//        System.out.println(inetAddress.getHostAddress());

    }

}
