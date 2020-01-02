package server;

import io.grpc.ServerBuilder;
import raftus.RaftServer;
import service.GrpcClientServices;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws InterruptedException, IOException {
        io.grpc.Server server = ServerBuilder.forPort(8989)
                .addService(new GrpcClientServices())
                .build()
                .start();

        RaftServer raftServer = new RaftServer();
        raftServer.start();

        System.out.println("Server running on port "+server.getPort());

        raftServer.join();
        server.awaitTermination();
    }
}
