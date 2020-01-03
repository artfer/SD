package server;

import io.grpc.ServerBuilder;
import service.GrpcClientServices;
import service.GrpcSeederServices;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws InterruptedException, IOException {
        io.grpc.Server server = ServerBuilder.forPort(Integer.parseInt(args[0]))
                .addService(new GrpcClientServices(Integer.parseInt(args[0])))
                .addService(new GrpcSeederServices())
                .build()
                .start();

        System.out.println("Server running on port "+server.getPort());

        server.awaitTermination();
    }
}
