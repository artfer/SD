package grpc_seeder;

import grpc.Seeder;
import grpc.seederGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GrpcSeeder {
    public static void main(String[] args) throws UnknownHostException {
        String name = "localhost";
        int port = 8989;

        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();

        InetAddress inetAddress = InetAddress.getLocalHost();

        seederGrpc.seederBlockingStub seederStub = seederGrpc.newBlockingStub(channel);
        Seeder.RegisterRequest registerRequest = Seeder.RegisterRequest.newBuilder()
                                                        .setIp(inetAddress.getHostAddress())
                                                        .setPort("4575")
                                                        .build();

        Seeder.RegisterResponse response = seederStub.register(registerRequest);
        System.out.println(response.getResponse());

        System.out.println(inetAddress.getHostAddress());
    }
}
