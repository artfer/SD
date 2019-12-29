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
    comments = "Source: client.proto")
public final class clientGrpc {

  private clientGrpc() {}

  public static final String SERVICE_NAME = "client";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Client.SeedersListRequest,
      grpc.Client.SeedersListResponse> getSeedersListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SeedersList",
      requestType = grpc.Client.SeedersListRequest.class,
      responseType = grpc.Client.SeedersListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Client.SeedersListRequest,
      grpc.Client.SeedersListResponse> getSeedersListMethod() {
    io.grpc.MethodDescriptor<grpc.Client.SeedersListRequest, grpc.Client.SeedersListResponse> getSeedersListMethod;
    if ((getSeedersListMethod = clientGrpc.getSeedersListMethod) == null) {
      synchronized (clientGrpc.class) {
        if ((getSeedersListMethod = clientGrpc.getSeedersListMethod) == null) {
          clientGrpc.getSeedersListMethod = getSeedersListMethod = 
              io.grpc.MethodDescriptor.<grpc.Client.SeedersListRequest, grpc.Client.SeedersListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "client", "SeedersList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Client.SeedersListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Client.SeedersListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new clientMethodDescriptorSupplier("SeedersList"))
                  .build();
          }
        }
     }
     return getSeedersListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Client.SeederSearchKeywordRequest,
      grpc.Client.SeederSearchKeywordResponse> getSeederSearchKeywordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SeederSearchKeyword",
      requestType = grpc.Client.SeederSearchKeywordRequest.class,
      responseType = grpc.Client.SeederSearchKeywordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Client.SeederSearchKeywordRequest,
      grpc.Client.SeederSearchKeywordResponse> getSeederSearchKeywordMethod() {
    io.grpc.MethodDescriptor<grpc.Client.SeederSearchKeywordRequest, grpc.Client.SeederSearchKeywordResponse> getSeederSearchKeywordMethod;
    if ((getSeederSearchKeywordMethod = clientGrpc.getSeederSearchKeywordMethod) == null) {
      synchronized (clientGrpc.class) {
        if ((getSeederSearchKeywordMethod = clientGrpc.getSeederSearchKeywordMethod) == null) {
          clientGrpc.getSeederSearchKeywordMethod = getSeederSearchKeywordMethod = 
              io.grpc.MethodDescriptor.<grpc.Client.SeederSearchKeywordRequest, grpc.Client.SeederSearchKeywordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "client", "SeederSearchKeyword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Client.SeederSearchKeywordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Client.SeederSearchKeywordResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new clientMethodDescriptorSupplier("SeederSearchKeyword"))
                  .build();
          }
        }
     }
     return getSeederSearchKeywordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Client.DownloadFileRequest,
      grpc.Client.DownloadFileResponse> getDownloadFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DownloadFile",
      requestType = grpc.Client.DownloadFileRequest.class,
      responseType = grpc.Client.DownloadFileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Client.DownloadFileRequest,
      grpc.Client.DownloadFileResponse> getDownloadFileMethod() {
    io.grpc.MethodDescriptor<grpc.Client.DownloadFileRequest, grpc.Client.DownloadFileResponse> getDownloadFileMethod;
    if ((getDownloadFileMethod = clientGrpc.getDownloadFileMethod) == null) {
      synchronized (clientGrpc.class) {
        if ((getDownloadFileMethod = clientGrpc.getDownloadFileMethod) == null) {
          clientGrpc.getDownloadFileMethod = getDownloadFileMethod = 
              io.grpc.MethodDescriptor.<grpc.Client.DownloadFileRequest, grpc.Client.DownloadFileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "client", "DownloadFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Client.DownloadFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Client.DownloadFileResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new clientMethodDescriptorSupplier("DownloadFile"))
                  .build();
          }
        }
     }
     return getDownloadFileMethod;
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
    public void seedersList(grpc.Client.SeedersListRequest request,
        io.grpc.stub.StreamObserver<grpc.Client.SeedersListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSeedersListMethod(), responseObserver);
    }

    /**
     * <pre>
     * list all seeders that match keywords
     * </pre>
     */
    public void seederSearchKeyword(grpc.Client.SeederSearchKeywordRequest request,
        io.grpc.stub.StreamObserver<grpc.Client.SeederSearchKeywordResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSeederSearchKeywordMethod(), responseObserver);
    }

    /**
     * <pre>
     * download file
     * </pre>
     */
    public void downloadFile(grpc.Client.DownloadFileRequest request,
        io.grpc.stub.StreamObserver<grpc.Client.DownloadFileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDownloadFileMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSeedersListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Client.SeedersListRequest,
                grpc.Client.SeedersListResponse>(
                  this, METHODID_SEEDERS_LIST)))
          .addMethod(
            getSeederSearchKeywordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Client.SeederSearchKeywordRequest,
                grpc.Client.SeederSearchKeywordResponse>(
                  this, METHODID_SEEDER_SEARCH_KEYWORD)))
          .addMethod(
            getDownloadFileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Client.DownloadFileRequest,
                grpc.Client.DownloadFileResponse>(
                  this, METHODID_DOWNLOAD_FILE)))
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
    public void seedersList(grpc.Client.SeedersListRequest request,
        io.grpc.stub.StreamObserver<grpc.Client.SeedersListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSeedersListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * list all seeders that match keywords
     * </pre>
     */
    public void seederSearchKeyword(grpc.Client.SeederSearchKeywordRequest request,
        io.grpc.stub.StreamObserver<grpc.Client.SeederSearchKeywordResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSeederSearchKeywordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * download file
     * </pre>
     */
    public void downloadFile(grpc.Client.DownloadFileRequest request,
        io.grpc.stub.StreamObserver<grpc.Client.DownloadFileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDownloadFileMethod(), getCallOptions()), request, responseObserver);
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
    public grpc.Client.SeedersListResponse seedersList(grpc.Client.SeedersListRequest request) {
      return blockingUnaryCall(
          getChannel(), getSeedersListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * list all seeders that match keywords
     * </pre>
     */
    public grpc.Client.SeederSearchKeywordResponse seederSearchKeyword(grpc.Client.SeederSearchKeywordRequest request) {
      return blockingUnaryCall(
          getChannel(), getSeederSearchKeywordMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * download file
     * </pre>
     */
    public grpc.Client.DownloadFileResponse downloadFile(grpc.Client.DownloadFileRequest request) {
      return blockingUnaryCall(
          getChannel(), getDownloadFileMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<grpc.Client.SeedersListResponse> seedersList(
        grpc.Client.SeedersListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSeedersListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * list all seeders that match keywords
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Client.SeederSearchKeywordResponse> seederSearchKeyword(
        grpc.Client.SeederSearchKeywordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSeederSearchKeywordMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * download file
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Client.DownloadFileResponse> downloadFile(
        grpc.Client.DownloadFileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDownloadFileMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEEDERS_LIST = 0;
  private static final int METHODID_SEEDER_SEARCH_KEYWORD = 1;
  private static final int METHODID_DOWNLOAD_FILE = 2;

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
          serviceImpl.seedersList((grpc.Client.SeedersListRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Client.SeedersListResponse>) responseObserver);
          break;
        case METHODID_SEEDER_SEARCH_KEYWORD:
          serviceImpl.seederSearchKeyword((grpc.Client.SeederSearchKeywordRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Client.SeederSearchKeywordResponse>) responseObserver);
          break;
        case METHODID_DOWNLOAD_FILE:
          serviceImpl.downloadFile((grpc.Client.DownloadFileRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Client.DownloadFileResponse>) responseObserver);
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
      return grpc.Client.getDescriptor();
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
              .build();
        }
      }
    }
    return result;
  }
}
