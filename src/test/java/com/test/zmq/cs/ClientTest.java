package com.test.zmq.cs;

import org.zeromq.ZMQ;

public class ClientTest {

    public static void main(String[] args){
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.REQ);
        socket.connect("tcp://127.0.0.1:10001");

        socket.send("发送个服务端一个请求".getBytes());
        byte[] recv = socket.recv();
        System.out.println("客户端收到了服务端发送的请求:"+new String(recv));

        socket.close();
        context.term();
    }
}
