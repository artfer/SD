package service;

import grpc.SeederServer;
import grpc.seeder_serverGrpc;
import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.netty.NettyTransport;
import io.atomix.copycat.client.CopycatClient;
import io.grpc.stub.StreamObserver;
import raftus.Put;

public class GrpcSeederServices extends seeder_serverGrpc.seeder_serverImplBase {

    @Override
    public void register(SeederServer.registerRequest request, StreamObserver<SeederServer.registerResponse> responseObserver) {

        SeederServer.registerResponse.Builder response = SeederServer.registerResponse.newBuilder();

        String file = request.getFile();
        int port = request.getPort();

        CopycatClient client = getCopycatClient();
        client.submit(new Put(file,port));
        client.close();

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }


    private CopycatClient getCopycatClient(){
        CopycatClient client = CopycatClient.builder()
                .withTransport(NettyTransport.builder()
                        .withThreads(1)
                        .build())
                .build();

        Address clusterAddress = new Address("localhost", 5000);
        client.connect(clusterAddress).join();
        return client;
    }
}
