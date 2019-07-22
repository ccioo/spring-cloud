package com.example.grpcclient.service;


import com.example.grpc.lib.HelloReply;
import com.example.grpc.lib.HelloRequest;
import com.example.grpc.lib.SimpleGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;


@Service
public class RemoteCallService {

    @GrpcClient("cloud-grpc-server")
    private Channel serverChannel;

    public String sendMessage(String name) {
        SimpleGrpc.SimpleBlockingStub stub = SimpleGrpc.newBlockingStub(serverChannel);
        HelloRequest helloRequest = HelloRequest.newBuilder().setName(name)
                .build();
        HelloReply response = stub.sayHello(helloRequest);
        return response.getMessage();

    }
}
