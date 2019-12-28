package service;

import grpc.Client;
import grpc.clientGrpc;
import io.grpc.stub.StreamObserver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class GrpcClientServices extends clientGrpc.clientImplBase {
    @Override
    public void seedersList(Client.SeedersListRequest request, StreamObserver<Client.SeedersListResponse> responseObserver) {
//        super.seedersList(request, responseObserver);

        Client.SeedersListResponse.Builder response = Client.SeedersListResponse.newBuilder();
        System.out.println("seedersList");
        //TODO send info to jraft

        //CODIGO
        response.setSeeders("seedersList");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void seederSearchKeyword(Client.SeederSearchKeywordRequest request, StreamObserver<Client.SeederSearchKeywordResponse> responseObserver) {
//        super.seederSearchKeyword(request, responseObserver);
        String keyword = request.getKeyword();

        Client.SeederSearchKeywordResponse.Builder response = Client.SeederSearchKeywordResponse.newBuilder();

        //TODO send info to jraft

        System.out.println("seederSearchKeyword");
        //CODIGO
        response.setSeeders("seederSearchKeyword");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void downloadFile(Client.DownloadFileRequest request, StreamObserver<Client.DownloadFileResponse> responseObserver) throws UnknownHostException {
//        super.downloadFile(request, responseObserver);
        String fileName = request.getFile();

        Client.DownloadFileResponse.Builder response = Client.DownloadFileResponse.newBuilder();

        //TODO send info to jraft

        System.out.println("downloadFile");
        InetAddress inetAddress = InetAddress.getLocalHost();

        //CODIGO
        Random rand = new Random();
        response.setIp(inetAddress.getHostAddress()).setPort(rand.nextInt());
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
