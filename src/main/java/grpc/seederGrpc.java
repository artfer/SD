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
    comments = "Source: seeder.proto")
public final class seederGrpc {

  private seederGrpc() {}

  public static final String SERVICE_NAME = "seeder";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Seeder.RegisterRequest,
      grpc.Seeder.RegisterResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = grpc.Seeder.RegisterRequest.class,
      responseType = grpc.Seeder.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Seeder.RegisterRequest,
      grpc.Seeder.RegisterResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<grpc.Seeder.RegisterRequest, grpc.Seeder.RegisterResponse> getRegisterMethod;
    if ((getRegisterMethod = seederGrpc.getRegisterMethod) == null) {
      synchronized (seederGrpc.class) {
        if ((getRegisterMethod = seederGrpc.getRegisterMethod) == null) {
          seederGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<grpc.Seeder.RegisterRequest, grpc.Seeder.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seeder", "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Seeder.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Seeder.RegisterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new seederMethodDescriptorSupplier("register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Seeder.ClosureRequest,
      grpc.Seeder.ClosureResponse> getClosureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "closure",
      requestType = grpc.Seeder.ClosureRequest.class,
      responseType = grpc.Seeder.ClosureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Seeder.ClosureRequest,
      grpc.Seeder.ClosureResponse> getClosureMethod() {
    io.grpc.MethodDescriptor<grpc.Seeder.ClosureRequest, grpc.Seeder.ClosureResponse> getClosureMethod;
    if ((getClosureMethod = seederGrpc.getClosureMethod) == null) {
      synchronized (seederGrpc.class) {
        if ((getClosureMethod = seederGrpc.getClosureMethod) == null) {
          seederGrpc.getClosureMethod = getClosureMethod = 
              io.grpc.MethodDescriptor.<grpc.Seeder.ClosureRequest, grpc.Seeder.ClosureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seeder", "closure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Seeder.ClosureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Seeder.ClosureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new seederMethodDescriptorSupplier("closure"))
                  .build();
          }
        }
     }
     return getClosureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static seederStub newStub(io.grpc.Channel channel) {
    return new seederStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static seederBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new seederBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static seederFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new seederFutureStub(channel);
  }

  /**
   */
  public static abstract class seederImplBase implements io.grpc.BindableService {

    /**
     */
    public void register(grpc.Seeder.RegisterRequest request,
        io.grpc.stub.StreamObserver<grpc.Seeder.RegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    public void closure(grpc.Seeder.ClosureRequest request,
        io.grpc.stub.StreamObserver<grpc.Seeder.ClosureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getClosureMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Seeder.RegisterRequest,
                grpc.Seeder.RegisterResponse>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getClosureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Seeder.ClosureRequest,
                grpc.Seeder.ClosureResponse>(
                  this, METHODID_CLOSURE)))
          .build();
    }
  }

  /**
   */
  public static final class seederStub extends io.grpc.stub.AbstractStub<seederStub> {
    private seederStub(io.grpc.Channel channel) {
      super(channel);
    }

    private seederStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected seederStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new seederStub(channel, callOptions);
    }

    /**
     */
    public void register(grpc.Seeder.RegisterRequest request,
        io.grpc.stub.StreamObserver<grpc.Seeder.RegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closure(grpc.Seeder.ClosureRequest request,
        io.grpc.stub.StreamObserver<grpc.Seeder.ClosureResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getClosureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class seederBlockingStub extends io.grpc.stub.AbstractStub<seederBlockingStub> {
    private seederBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private seederBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected seederBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new seederBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Seeder.RegisterResponse register(grpc.Seeder.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Seeder.ClosureResponse closure(grpc.Seeder.ClosureRequest request) {
      return blockingUnaryCall(
          getChannel(), getClosureMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class seederFutureStub extends io.grpc.stub.AbstractStub<seederFutureStub> {
    private seederFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private seederFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected seederFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new seederFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Seeder.RegisterResponse> register(
        grpc.Seeder.RegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Seeder.ClosureResponse> closure(
        grpc.Seeder.ClosureRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getClosureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_CLOSURE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final seederImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(seederImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((grpc.Seeder.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Seeder.RegisterResponse>) responseObserver);
          break;
        case METHODID_CLOSURE:
          serviceImpl.closure((grpc.Seeder.ClosureRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Seeder.ClosureResponse>) responseObserver);
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

  private static abstract class seederBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    seederBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Seeder.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("seeder");
    }
  }

  private static final class seederFileDescriptorSupplier
      extends seederBaseDescriptorSupplier {
    seederFileDescriptorSupplier() {}
  }

  private static final class seederMethodDescriptorSupplier
      extends seederBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    seederMethodDescriptorSupplier(String methodName) {
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
      synchronized (seederGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new seederFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getClosureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
