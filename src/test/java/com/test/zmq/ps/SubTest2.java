package com.test.zmq.ps;

import FacedataProcessServer.FacedataProcess;
import com.czht.smartpark.tbweb.modular.dto.PassDTO;
import com.google.protobuf.InvalidProtocolBufferException;
import org.zeromq.ZMQ;

import java.io.IOException;
import java.sql.Date;

public class SubTest2 {
    public static void main (String[] args) throws IOException {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.SUB);
        socket.connect("tcp://192.168.10.202:5001");
        socket.connect("tcp://192.168.10.203:5001");
        socket.subscribe("");

        while(!Thread.currentThread().isInterrupted()){
            byte[] recv = socket.recv(0);
            PassDTO pass = parsePassMessage(recv);
            if(pass != null){
                System.out.println(pass.toString());
            }

        }

        socket.close();
        context.term();
    }

    private static PassDTO parsePassMessage(byte[] request){
        PassDTO passDto = new PassDTO();
        FacedataProcess.PassbyInfo passByInfo = null;
        try{
            passByInfo = FacedataProcess.PassbyInfo.parseFrom(request);
            Integer filterFlag = passByInfo.getFilterFlag();

            passDto.setUserId(Long.valueOf(passByInfo.getUserId()==null?"0":passByInfo.getUserId()));
            passDto.setUserName(passByInfo.getUserName());
            passDto.setDeviceId(Integer.parseInt(passByInfo.getDeviceId()));
            passDto.setPassDatetime(new Date(passByInfo.getPassDatetime()*1000));
            passDto.setFaceFdfsId(passByInfo.getPassPicFacePath());
            passDto.setFullFdfsId(passByInfo.getPassPicFullPath());
            passDto.setUserType(passByInfo.getUserType());
            if(filterFlag == 1) {
                System.out.println(passDto.toString());
                System.out.println("数据被过滤");
                return null;
            }
        }catch(InvalidProtocolBufferException e){
            e.printStackTrace();
        }
        return passDto;
    }
}
