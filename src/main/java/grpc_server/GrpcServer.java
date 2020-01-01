package grpc_server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.GrpcClientServices;
import service.GrpcSeederServices;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(8989)
                .addService(new GrpcSeederServices())
                .addService(new GrpcClientServices())
                .build()
                .start();
        System.out.println("Server running on port "+server.getPort());
        server.awaitTermination();
    }
}
