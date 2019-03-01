package com.czht.smartpark.tbweb.modular.zmq.FacedataProcessServer;

import FacedataProcessServer.FacedataProcess;
import com.czht.smartpark.tbweb.modular.dto.PassDTO;
import com.google.protobuf.InvalidProtocolBufferException;

import java.sql.Date;

public class FacedataUtil {

    public static PassDTO parsePassMessage(byte[] request){
        PassDTO passDto = new PassDTO();
        FacedataProcess.PassbyInfo passByInfo = null;
        try{
            passByInfo = FacedataProcess.PassbyInfo.parseFrom(request);
            passDto.setUserId(Long.valueOf(passByInfo.getUserId()==null?"0":passByInfo.getUserId()));
            passDto.setUserName(passByInfo.getUserName());
            passDto.setDeviceDirection(passByInfo.getDeviceDirection());
            passDto.setDeviceId(Integer.parseInt(passByInfo.getDeviceId()));
            passDto.setPassDatetime(new Date(passByInfo.getPassDatetime()*1000));
            passDto.setDeviceAreaId(passByInfo.getDeviceAreaId());
            passDto.setUserName(passByInfo.getUserName());
            passDto.setFaceFdfsId(passByInfo.getPassPicFacePath());
            passDto.setFullFdfsId(passByInfo.getPassPicFullPath());
            passDto.setUserType(passByInfo.getUserType());
            passDto.setFilterFlag(passByInfo.getFilterFlag());
        }catch(InvalidProtocolBufferException e){
            e.printStackTrace();
        }
        return passDto;
    }
}
