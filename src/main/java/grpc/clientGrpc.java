package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: the_client.proto")
public final class clientGrpc {

  private clientGrpc() {}

  public static final String SERVICE_NAME = "client";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.TheClient.SeedersListRequest,
      grpc.TheClient.SeedersListResponse> getSeedersListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SeedersList",
      requestType = grpc.TheClient.SeedersListRequest.class,
      responseType = grpc.TheClient.SeedersListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.TheClient.SeedersListRequest,
      grpc.TheClient.SeedersListResponse> getSeedersListMethod() {
    io.grpc.MethodDescriptor<grpc.TheClient.SeedersListRequest, grpc.TheClient.SeedersListResponse> getSeedersListMethod;
    if ((getSeedersListMethod = clientGrpc.getSeedersListMethod) == null) {
      synchronized (clientGrpc.class) {
        if ((getSeedersListMethod = clientGrpc.getSeedersListMethod) == null) {
          clientGrpc.getSeedersListMethod = getSeedersListMethod = 
              io.grpc.MethodDescriptor.<grpc.TheClient.SeedersListRequest, grpc.TheClient.SeedersListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "client", "SeedersList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TheClient.SeedersListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TheClient.SeedersListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new clientMethodDescriptorSupplier("SeedersList"))
                  .build();
          }
        }
     }
     return getSeedersListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.TheClient.SeederSearchKeywordRequest,
      grpc.TheClient.SeederSearchKeywordResponse> getSeederSearchKeywordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SeederSearchKeyword",
      requestType = grpc.TheClient.SeederSearchKeywordRequest.class,
      responseType = grpc.TheClient.SeederSearchKeywordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.TheClient.SeederSearchKeywordRequest,
      grpc.TheClient.SeederSearchKeywordResponse> getSeederSearchKeywordMethod() {
    io.grpc.MethodDescriptor<grpc.TheClient.SeederSearchKeywordRequest, grpc.TheClient.SeederSearchKeywordResponse> getSeederSearchKeywordMethod;
    if ((getSeederSearchKeywordMethod = clientGrpc.getSeederSearchKeywordMethod) == null) {
      synchronized (clientGrpc.class) {
        if ((getSeederSearchKeywordMethod = clientGrpc.getSeederSearchKeywordMethod) == null) {
          clientGrpc.getSeederSearchKeywordMethod = getSeederSearchKeywordMethod = 
              io.grpc.MethodDescriptor.<grpc.TheClient.SeederSearchKeywordRequest, grpc.TheClient.SeederSearchKeywordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "client", "SeederSearchKeyword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TheClient.SeederSearchKeywordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TheClient.SeederSearchKeywordResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new clientMethodDescriptorSupplier("SeederSearchKeyword"))
                  .build();
          }
        }
     }
     return getSeederSearchKeywordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.TheClient.DownloadFileRequest,
      grpc.TheClient.DownloadFileResponse> getDownloadFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DownloadFile",
      requestType = grpc.TheClient.DownloadFileRequest.class,
      responseType = grpc.TheClient.DownloadFileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.TheClient.DownloadFileRequest,
      grpc.TheClient.DownloadFileResponse> getDownloadFileMethod() {
    io.grpc.MethodDescriptor<grpc.TheClient.DownloadFileRequest, grpc.TheClient.DownloadFileResponse> getDownloadFileMethod;
    if ((getDownloadFileMethod = clientGrpc.getDownloadFileMethod) == null) {
      synchronized (clientGrpc.class) {
        if ((getDownloadFileMethod = clientGrpc.getDownloadFileMethod) == null) {
          clientGrpc.getDownloadFileMethod = getDownloadFileMethod = 
              io.grpc.MethodDescriptor.<grpc.TheClient.DownloadFileRequest, grpc.TheClient.DownloadFileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "client", "DownloadFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TheClient.DownloadFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TheClient.DownloadFileResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new clientMethodDescriptorSupplier("DownloadFile"))
                  .build();
          }
        }
     }
     return getDownloadFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.TheClient.InfoFileRequest,
      grpc.TheClient.InfoFileResponse> getInfoFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InfoFile",
      requestType = grpc.TheClient.InfoFileRequest.class,
      responseType = grpc.TheClient.InfoFileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.TheClient.InfoFileRequest,
      grpc.TheClient.InfoFileResponse> getInfoFileMethod() {
    io.grpc.MethodDescriptor<grpc.TheClient.InfoFileRequest, grpc.TheClient.InfoFileResponse> getInfoFileMethod;
    if ((getInfoFileMethod = clientGrpc.getInfoFileMethod) == null) {
      synchronized (clientGrpc.class) {
        if ((getInfoFileMethod = clientGrpc.getInfoFileMethod) == null) {
          clientGrpc.getInfoFileMethod = getInfoFileMethod = 
              io.grpc.MethodDescriptor.<grpc.TheClient.InfoFileRequest, grpc.TheClient.InfoFileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "client", "InfoFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TheClient.InfoFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TheClient.InfoFileResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new clientMethodDescriptorSupplier("InfoFile"))
                  .build();
          }
        }
     }
     return getInfoFileMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static clientStub newStub(io.grpc.Channel channel) {
    return new clientStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static clientBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new clientBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static clientFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new clientFutureStub(channel);
  }

  /**
   */
  public static abstract class clientImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * list all seeders
     * </pre>
     */
    public void seedersList(grpc.TheClient.SeedersListRequest request,
        io.grpc.stub.StreamObserver<grpc.TheClient.SeedersListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSeedersListMethod(), responseObserver);
    }

    /**
     * <pre>
     * list all seeders that match keywords
     * </pre>
     */
    public void seederSearchKeyword(grpc.TheClient.SeederSearchKeywordRequest request,
        io.grpc.stub.StreamObserver<grpc.TheClient.SeederSearchKeywordResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSeederSearchKeywordMethod(), responseObserver);
    }

    /**
     * <pre>
     * download file
     * </pre>
     */
    public void downloadFile(grpc.TheClient.DownloadFileRequest request,
        io.grpc.stub.StreamObserver<grpc.TheClient.DownloadFileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDownloadFileMethod(), responseObserver);
    }

    /**
     * <pre>
     * info file
     * </pre>
     */
    public void infoFile(grpc.TheClient.InfoFileRequest request,
        io.grpc.stub.StreamObserver<grpc.TheClient.InfoFileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInfoFileMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSeedersListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.TheClient.SeedersListRequest,
                grpc.TheClient.SeedersListResponse>(
                  this, METHODID_SEEDERS_LIST)))
          .addMethod(
            getSeederSearchKeywordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.TheClient.SeederSearchKeywordRequest,
                grpc.TheClient.SeederSearchKeywordResponse>(
                  this, METHODID_SEEDER_SEARCH_KEYWORD)))
          .addMethod(
            getDownloadFileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.TheClient.DownloadFileRequest,
                grpc.TheClient.DownloadFileResponse>(
                  this, METHODID_DOWNLOAD_FILE)))
          .addMethod(
            getInfoFileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.TheClient.InfoFileRequest,
                grpc.TheClient.InfoFileResponse>(
                  this, METHODID_INFO_FILE)))
          .build();
    }
  }

  /**
   */
  public static final class clientStub extends io.grpc.stub.AbstractStub<clientStub> {
    private clientStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clientStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clientStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clientStub(channel, callOptions);
    }

    /**
     * <pre>
     * list all seeders
     * </pre>
     */
    public void seedersList(grpc.TheClient.SeedersListRequest request,
        io.grpc.stub.StreamObserver<grpc.TheClient.SeedersListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSeedersListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * list all seeders that match keywords
     * </pre>
     */
    public void seederSearchKeyword(grpc.TheClient.SeederSearchKeywordRequest request,
        io.grpc.stub.StreamObserver<grpc.TheClient.SeederSearchKeywordResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSeederSearchKeywordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * download file
     * </pre>
     */
    public void downloadFile(grpc.TheClient.DownloadFileRequest request,
        io.grpc.stub.StreamObserver<grpc.TheClient.DownloadFileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDownloadFileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * info file
     * </pre>
     */
    public void infoFile(grpc.TheClient.InfoFileRequest request,
        io.grpc.stub.StreamObserver<grpc.TheClient.InfoFileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInfoFileMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class clientBlockingStub extends io.grpc.stub.AbstractStub<clientBlockingStub> {
    private clientBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clientBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clientBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clientBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * list all seeders
     * </pre>
     */
    public grpc.TheClient.SeedersListResponse seedersList(grpc.TheClient.SeedersListRequest request) {
      return blockingUnaryCall(
          getChannel(), getSeedersListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * list all seeders that match keywords
     * </pre>
     */
    public grpc.TheClient.SeederSearchKeywordResponse seederSearchKeyword(grpc.TheClient.SeederSearchKeywordRequest request) {
      return blockingUnaryCall(
          getChannel(), getSeederSearchKeywordMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * download file
     * </pre>
     */
    public grpc.TheClient.DownloadFileResponse downloadFile(grpc.TheClient.DownloadFileRequest request) {
      return blockingUnaryCall(
          getChannel(), getDownloadFileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * info file
     * </pre>
     */
    public grpc.TheClient.InfoFileResponse infoFile(grpc.TheClient.InfoFileRequest request) {
      return blockingUnaryCall(
          getChannel(), getInfoFileMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class clientFutureStub extends io.grpc.stub.AbstractStub<clientFutureStub> {
    private clientFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clientFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clientFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clientFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * list all seeders
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.TheClient.SeedersListResponse> seedersList(
        grpc.TheClient.SeedersListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSeedersListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * list all seeders that match keywords
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.TheClient.SeederSearchKeywordResponse> seederSearchKeyword(
        grpc.TheClient.SeederSearchKeywordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSeederSearchKeywordMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * download file
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.TheClient.DownloadFileResponse> downloadFile(
        grpc.TheClient.DownloadFileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDownloadFileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * info file
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.TheClient.InfoFileResponse> infoFile(
        grpc.TheClient.InfoFileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInfoFileMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEEDERS_LIST = 0;
  private static final int METHODID_SEEDER_SEARCH_KEYWORD = 1;
  private static final int METHODID_DOWNLOAD_FILE = 2;
  private static final int METHODID_INFO_FILE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final clientImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(clientImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEEDERS_LIST:
          serviceImpl.seedersList((grpc.TheClient.SeedersListRequest) request,
              (io.grpc.stub.StreamObserver<grpc.TheClient.SeedersListResponse>) responseObserver);
          break;
        case METHODID_SEEDER_SEARCH_KEYWORD:
          serviceImpl.seederSearchKeyword((grpc.TheClient.SeederSearchKeywordRequest) request,
              (io.grpc.stub.StreamObserver<grpc.TheClient.SeederSearchKeywordResponse>) responseObserver);
          break;
        case METHODID_DOWNLOAD_FILE:
          serviceImpl.downloadFile((grpc.TheClient.DownloadFileRequest) request,
              (io.grpc.stub.StreamObserver<grpc.TheClient.DownloadFileResponse>) responseObserver);
          break;
        case METHODID_INFO_FILE:
          serviceImpl.infoFile((grpc.TheClient.InfoFileRequest) request,
              (io.grpc.stub.StreamObserver<grpc.TheClient.InfoFileResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class clientBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    clientBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.TheClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("client");
    }
  }

  private static final class clientFileDescriptorSupplier
      extends clientBaseDescriptorSupplier {
    clientFileDescriptorSupplier() {}
  }

  private static final class clientMethodDescriptorSupplier
      extends clientBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    clientMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (clientGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new clientFileDescriptorSupplier())
              .addMethod(getSeedersListMethod())
              .addMethod(getSeederSearchKeywordMethod())
              .addMethod(getDownloadFileMethod())
              .addMethod(getInfoFileMethod())
              .build();
        }
      }
    }
    return result;
  }
}
