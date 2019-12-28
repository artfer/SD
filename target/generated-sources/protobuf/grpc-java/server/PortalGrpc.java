package server;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class PortalGrpc {

  private PortalGrpc() {}

  public static final String SERVICE_NAME = "helloworld.Portal";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<server.ListSeedersRequest,
      server.ListSeedersResponse> METHOD_SEEDERS_LIST =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "helloworld.Portal", "SeedersList"),
          io.grpc.protobuf.ProtoUtils.marshaller(server.ListSeedersRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(server.ListSeedersResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<server.SeederSearchRequest,
      server.SeederSearchResponse> METHOD_SEEDER_SEARCH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "helloworld.Portal", "SeederSearch"),
          io.grpc.protobuf.ProtoUtils.marshaller(server.SeederSearchRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(server.SeederSearchResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<server.DownloadFileRequest,
      server.DownloadFileResponse> METHOD_DOWNLOAD_FILE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "helloworld.Portal", "DownloadFile"),
          io.grpc.protobuf.ProtoUtils.marshaller(server.DownloadFileRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(server.DownloadFileResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<server.ListFilesRequest,
      server.ListFilesResponse> METHOD_LIST_FILES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "helloworld.Portal", "ListFiles"),
          io.grpc.protobuf.ProtoUtils.marshaller(server.ListFilesRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(server.ListFilesResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<server.InfoFileRequest,
      server.InfoFileResponse> METHOD_INFO_FILE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "helloworld.Portal", "InfoFile"),
          io.grpc.protobuf.ProtoUtils.marshaller(server.InfoFileRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(server.InfoFileResponse.getDefaultInstance()));

  public static PortalStub newStub(io.grpc.Channel channel) {
    return new PortalStub(channel);
  }

  public static PortalBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PortalBlockingStub(channel);
  }

  public static PortalFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PortalFutureStub(channel);
  }

  public static interface Portal {

    public void seedersList(server.ListSeedersRequest request,
        io.grpc.stub.StreamObserver<server.ListSeedersResponse> responseObserver);

    public void seederSearch(server.SeederSearchRequest request,
        io.grpc.stub.StreamObserver<server.SeederSearchResponse> responseObserver);

    public void downloadFile(server.DownloadFileRequest request,
        io.grpc.stub.StreamObserver<server.DownloadFileResponse> responseObserver);

    public void listFiles(server.ListFilesRequest request,
        io.grpc.stub.StreamObserver<server.ListFilesResponse> responseObserver);

    public void infoFile(server.InfoFileRequest request,
        io.grpc.stub.StreamObserver<server.InfoFileResponse> responseObserver);
  }

  public static interface PortalBlockingClient {

    public server.ListSeedersResponse seedersList(server.ListSeedersRequest request);

    public server.SeederSearchResponse seederSearch(server.SeederSearchRequest request);

    public server.DownloadFileResponse downloadFile(server.DownloadFileRequest request);

    public server.ListFilesResponse listFiles(server.ListFilesRequest request);

    public server.InfoFileResponse infoFile(server.InfoFileRequest request);
  }

  public static interface PortalFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<server.ListSeedersResponse> seedersList(
        server.ListSeedersRequest request);

    public com.google.common.util.concurrent.ListenableFuture<server.SeederSearchResponse> seederSearch(
        server.SeederSearchRequest request);

    public com.google.common.util.concurrent.ListenableFuture<server.DownloadFileResponse> downloadFile(
        server.DownloadFileRequest request);

    public com.google.common.util.concurrent.ListenableFuture<server.ListFilesResponse> listFiles(
        server.ListFilesRequest request);

    public com.google.common.util.concurrent.ListenableFuture<server.InfoFileResponse> infoFile(
        server.InfoFileRequest request);
  }

  public static class PortalStub extends io.grpc.stub.AbstractStub<PortalStub>
      implements Portal {
    private PortalStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PortalStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PortalStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PortalStub(channel, callOptions);
    }

    @java.lang.Override
    public void seedersList(server.ListSeedersRequest request,
        io.grpc.stub.StreamObserver<server.ListSeedersResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEEDERS_LIST, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void seederSearch(server.SeederSearchRequest request,
        io.grpc.stub.StreamObserver<server.SeederSearchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEEDER_SEARCH, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void downloadFile(server.DownloadFileRequest request,
        io.grpc.stub.StreamObserver<server.DownloadFileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DOWNLOAD_FILE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void listFiles(server.ListFilesRequest request,
        io.grpc.stub.StreamObserver<server.ListFilesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_FILES, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void infoFile(server.InfoFileRequest request,
        io.grpc.stub.StreamObserver<server.InfoFileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INFO_FILE, getCallOptions()), request, responseObserver);
    }
  }

  public static class PortalBlockingStub extends io.grpc.stub.AbstractStub<PortalBlockingStub>
      implements PortalBlockingClient {
    private PortalBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PortalBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PortalBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PortalBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public server.ListSeedersResponse seedersList(server.ListSeedersRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_SEEDERS_LIST, getCallOptions()), request);
    }

    @java.lang.Override
    public server.SeederSearchResponse seederSearch(server.SeederSearchRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_SEEDER_SEARCH, getCallOptions()), request);
    }

    @java.lang.Override
    public server.DownloadFileResponse downloadFile(server.DownloadFileRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_DOWNLOAD_FILE, getCallOptions()), request);
    }

    @java.lang.Override
    public server.ListFilesResponse listFiles(server.ListFilesRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_LIST_FILES, getCallOptions()), request);
    }

    @java.lang.Override
    public server.InfoFileResponse infoFile(server.InfoFileRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_INFO_FILE, getCallOptions()), request);
    }
  }

  public static class PortalFutureStub extends io.grpc.stub.AbstractStub<PortalFutureStub>
      implements PortalFutureClient {
    private PortalFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PortalFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PortalFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PortalFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<server.ListSeedersResponse> seedersList(
        server.ListSeedersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEEDERS_LIST, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<server.SeederSearchResponse> seederSearch(
        server.SeederSearchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEEDER_SEARCH, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<server.DownloadFileResponse> downloadFile(
        server.DownloadFileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DOWNLOAD_FILE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<server.ListFilesResponse> listFiles(
        server.ListFilesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_FILES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<server.InfoFileResponse> infoFile(
        server.InfoFileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INFO_FILE, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final Portal serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_SEEDERS_LIST,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              server.ListSeedersRequest,
              server.ListSeedersResponse>() {
            @java.lang.Override
            public void invoke(
                server.ListSeedersRequest request,
                io.grpc.stub.StreamObserver<server.ListSeedersResponse> responseObserver) {
              serviceImpl.seedersList(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_SEEDER_SEARCH,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              server.SeederSearchRequest,
              server.SeederSearchResponse>() {
            @java.lang.Override
            public void invoke(
                server.SeederSearchRequest request,
                io.grpc.stub.StreamObserver<server.SeederSearchResponse> responseObserver) {
              serviceImpl.seederSearch(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_DOWNLOAD_FILE,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              server.DownloadFileRequest,
              server.DownloadFileResponse>() {
            @java.lang.Override
            public void invoke(
                server.DownloadFileRequest request,
                io.grpc.stub.StreamObserver<server.DownloadFileResponse> responseObserver) {
              serviceImpl.downloadFile(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_LIST_FILES,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              server.ListFilesRequest,
              server.ListFilesResponse>() {
            @java.lang.Override
            public void invoke(
                server.ListFilesRequest request,
                io.grpc.stub.StreamObserver<server.ListFilesResponse> responseObserver) {
              serviceImpl.listFiles(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_INFO_FILE,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              server.InfoFileRequest,
              server.InfoFileResponse>() {
            @java.lang.Override
            public void invoke(
                server.InfoFileRequest request,
                io.grpc.stub.StreamObserver<server.InfoFileResponse> responseObserver) {
              serviceImpl.infoFile(request, responseObserver);
            }
          })).build();
  }
}
