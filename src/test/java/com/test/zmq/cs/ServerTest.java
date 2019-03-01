package com.test.zmq.cs;

import org.zeromq.ZMQ;

/**
 * 服务端
 */
public class ServerTest {

    public static void main(String[] args){
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.REP);
        socket.bind("tcp://127.0.0.1:10001");

        while (!Thread.currentThread().isInterrupted()) {
            byte[] res = socket.recv();
            System.out.println("收到消息"+new String(res));
            socket.send("服务端收到了你的消息，这是返回给你的信号");
        }

        socket.close();
        context.term();

    }
}
