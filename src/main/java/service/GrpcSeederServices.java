package service;

import grpc.Seeder;
import grpc.seederGrpc;
import io.grpc.stub.StreamObserver;

public class GrpcSeederServices extends seederGrpc.seederImplBase {
    @Override
    public void register(Seeder.RegisterRequest request, StreamObserver<Seeder.RegisterResponse> responseObserver) {
        //super.register(request, responseObserver);


        String ip = request.getIp();
        String port = request.getPort();

        Seeder.RegisterResponse.Builder response = Seeder.RegisterResponse.newBuilder();

        //TODO send info to jraft

        //CODIGO
        response.setResponseCode(0).setResponse("Registration success");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();



    }

    @Override
    public void closure(Seeder.ClosureRequest request, StreamObserver<Seeder.ClosureResponse> responseObserver) {
        //super.closure(request, responseObserver);

        String ip = request.getIp();
        String port = request.getPort();

        Seeder.ClosureResponse.Builder response = Seeder.ClosureResponse.newBuilder();

        //TODO send info to jraft

        //CODIGO
        response.setResponseCode(0).setResponse("Closure success");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
