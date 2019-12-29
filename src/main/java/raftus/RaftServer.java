package raftus;


import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.netty.NettyTransport;
import io.atomix.copycat.server.CopycatServer;
import io.atomix.copycat.server.storage.Storage;
import io.atomix.copycat.server.storage.StorageLevel;

import java.io.File;


public class RaftServer{


    public static void main(String[] args) {


        Address addr = new Address("localhost",5000);
        CopycatServer.Builder builder = CopycatServer.builder(addr);

        builder.withStateMachine(KeyValueStore::new);

        builder.withTransport(NettyTransport.builder()
                .withThreads(4)
                .build());

        builder.withStorage(Storage.builder()
                .withDirectory(new File("logs"))
                .withStorageLevel(StorageLevel.DISK)
                .build());

        CopycatServer server = builder.build();

        server.bootstrap().thenAccept(srvr -> System.out.println(srvr + " has bootstrapped a cluster"));

        Address clusterAddress = new Address("123.456.789.0", 5000);
        server.join(clusterAddress).thenAccept(srvr -> System.out.println(srvr + " has joined the cluster"));

    }
}