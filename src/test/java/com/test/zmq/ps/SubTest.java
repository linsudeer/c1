package com.test.zmq.ps;

import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.io.IOException;
import java.util.StringTokenizer;

public class SubTest {

    public static void main (String[] args) throws IOException {
        ZMQ.Context context = ZMQ.context(1);
        //  Socket to talk to server
        System.out.println("Collecting updates from weather server");
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5556");

        //  Subscribe to zipcode, default is NYC, 10001
        String filter = (args.length > 0) ? args[0] : "10001 ";
        subscriber.subscribe(filter.getBytes());

        while (!Thread.currentThread ().isInterrupted ()) {
            //  Use trim to remove the tailing '0' character
            String string = subscriber.recvStr(0).trim();
            StringTokenizer sscanf = new StringTokenizer(string, " ");
            int zipcode = Integer.valueOf(sscanf.nextToken());
            int temperature = Integer.valueOf(sscanf.nextToken());
            int relhumidity = Integer.valueOf(sscanf.nextToken());

            System.out.println(zipcode+ "' was " + temperature);
        }

        System.in.read();
        subscriber.close();
        context.term();
    }
}
