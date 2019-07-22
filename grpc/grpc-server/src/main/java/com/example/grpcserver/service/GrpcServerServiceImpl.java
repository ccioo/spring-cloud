package com.example.grpcserver.service;


import com.example.grpc.lib.HelloReply;
import com.example.grpc.lib.HelloRequest;
import com.example.grpc.lib.SimpleGrpc;
import com.netflix.discovery.converters.Auto;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import sun.java2d.pipe.SpanShapeRenderer;


@GrpcService(SpanShapeRenderer.Simple.class)
public class GrpcServerServiceImpl extends SimpleGrpc.SimpleImplBase {

    @Value("${server.port}")
    int port;

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        System.out.println("请求进来了");
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello =============> " + req.getName() + " 我来自服务端：" + port).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
