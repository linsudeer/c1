package com.test.zmq.ps;

import org.zeromq.ZMQ;

public class PubTest2 {

    public static void main(String args[]){
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.PUB);
        socket.bind("tcp://*:5555");

        int i=0;
        while(!Thread.currentThread().isInterrupted()){
            socket.send("李松林：消息"+i, 0);
            socket.send("周文：消息"+i, 0);
            i++;
        }

        socket.close();
        context.term();
    }
}
