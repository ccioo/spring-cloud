package com.example.grpcserver.service;


import com.example.grpc.lib.HelloReply;
import com.example.grpc.lib.HelloRequest;
import com.example.grpc.lib.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import sun.java2d.pipe.SpanShapeRenderer;


@GrpcService(SpanShapeRenderer.Simple.class)
public class GrpcServerServiceImpl extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello =============> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
