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
    comments = "Source: seeder_server.proto")
public final class seeder_serverGrpc {

  private seeder_serverGrpc() {}

  public static final String SERVICE_NAME = "seeder_server";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.SeederServer.registerRequest,
      grpc.SeederServer.registerResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = grpc.SeederServer.registerRequest.class,
      responseType = grpc.SeederServer.registerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.SeederServer.registerRequest,
      grpc.SeederServer.registerResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<grpc.SeederServer.registerRequest, grpc.SeederServer.registerResponse> getRegisterMethod;
    if ((getRegisterMethod = seeder_serverGrpc.getRegisterMethod) == null) {
      synchronized (seeder_serverGrpc.class) {
        if ((getRegisterMethod = seeder_serverGrpc.getRegisterMethod) == null) {
          seeder_serverGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<grpc.SeederServer.registerRequest, grpc.SeederServer.registerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seeder_server", "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.SeederServer.registerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.SeederServer.registerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new seeder_serverMethodDescriptorSupplier("register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static seeder_serverStub newStub(io.grpc.Channel channel) {
    return new seeder_serverStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static seeder_serverBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new seeder_serverBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static seeder_serverFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new seeder_serverFutureStub(channel);
  }

  /**
   */
  public static abstract class seeder_serverImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * register seeder in db
     * </pre>
     */
    public void register(grpc.SeederServer.registerRequest request,
        io.grpc.stub.StreamObserver<grpc.SeederServer.registerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.SeederServer.registerRequest,
                grpc.SeederServer.registerResponse>(
                  this, METHODID_REGISTER)))
          .build();
    }
  }

  /**
   */
  public static final class seeder_serverStub extends io.grpc.stub.AbstractStub<seeder_serverStub> {
    private seeder_serverStub(io.grpc.Channel channel) {
      super(channel);
    }

    private seeder_serverStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected seeder_serverStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new seeder_serverStub(channel, callOptions);
    }

    /**
     * <pre>
     * register seeder in db
     * </pre>
     */
    public void register(grpc.SeederServer.registerRequest request,
        io.grpc.stub.StreamObserver<grpc.SeederServer.registerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class seeder_serverBlockingStub extends io.grpc.stub.AbstractStub<seeder_serverBlockingStub> {
    private seeder_serverBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private seeder_serverBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected seeder_serverBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new seeder_serverBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * register seeder in db
     * </pre>
     */
    public grpc.SeederServer.registerResponse register(grpc.SeederServer.registerRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class seeder_serverFutureStub extends io.grpc.stub.AbstractStub<seeder_serverFutureStub> {
    private seeder_serverFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private seeder_serverFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected seeder_serverFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new seeder_serverFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * register seeder in db
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.SeederServer.registerResponse> register(
        grpc.SeederServer.registerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final seeder_serverImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(seeder_serverImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((grpc.SeederServer.registerRequest) request,
              (io.grpc.stub.StreamObserver<grpc.SeederServer.registerResponse>) responseObserver);
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

  private static abstract class seeder_serverBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    seeder_serverBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.SeederServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("seeder_server");
    }
  }

  private static final class seeder_serverFileDescriptorSupplier
      extends seeder_serverBaseDescriptorSupplier {
    seeder_serverFileDescriptorSupplier() {}
  }

  private static final class seeder_serverMethodDescriptorSupplier
      extends seeder_serverBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    seeder_serverMethodDescriptorSupplier(String methodName) {
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
      synchronized (seeder_serverGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new seeder_serverFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
