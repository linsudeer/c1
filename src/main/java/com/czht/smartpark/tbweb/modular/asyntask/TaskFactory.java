package com.czht.smartpark.tbweb.modular.asyntask;

import com.czht.smartpark.tbweb.context.exception.ExceptionUtil;
import com.czht.smartpark.tbweb.context.support.SpringContextHolder;
import com.czht.smartpark.tbweb.modular.constant.SysConfigEnum;
import com.czht.smartpark.tbweb.modular.dto.CodeDTO;
import com.czht.smartpark.tbweb.modular.dto.PassDTO;
import com.czht.smartpark.tbweb.modular.service.CodeService;
import com.czht.smartpark.tbweb.modular.service.MsgService;
import com.czht.smartpark.tbweb.modular.zmq.FacedataProcessServer.FacedataUtil;
import com.czht.smartpark.tbweb.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.ZMQ;

import java.util.TimerTask;

/**
 * 异步任务工程，这里产生任务
 */
public class TaskFactory {

    private static Logger logger = LoggerFactory.getLogger(TaskFactory.class);

    public static TimerTask zmqPassTask(){
        return new TimerTask() {
            @Override
            public void run() {
                logger.debug("【ZMQ实时获取通行记录】-服务地址："+SysConfigEnum.ZMQ_PASS.getValue());
                ZMQ.Context context = null;
                ZMQ.Socket socket = null;
                try {
                    context = ZMQ.context(1);
                    socket = context.socket(ZMQ.SUB);
                }catch (Exception e){
                    e.printStackTrace();
                    return;
                }

                String server = SysConfigEnum.ZMQ_PASS.getValue();
                String[] parts = server.split(",");
                for(int i=0;i<parts.length;i++){
                    socket.connect("tcp://"+parts[i]);
                }
                socket.subscribe("");
                while(!Thread.currentThread().isInterrupted()){
                    byte[] recv = socket.recv(0);
                    PassDTO pass = FacedataUtil.parsePassMessage(recv);

                    if(pass != null){
                        if(pass.getFilterFlag() == 1){
                            logger.debug("【ZMQ消息-通行记录<已过滤>】"+pass.toString());
                        }else {
                            logger.debug("【ZMQ消息-通行记录】"+pass.toString());

                            try {
                                MsgService msgService = SpringContextHolder.getBean(MsgService.class);
                                CodeService codeService = SpringContextHolder.getBean(CodeService.class);
                                CodeDTO areaCode = codeService.getArea(pass.getDeviceAreaId());
                                //发送短信
                                StringBuilder sb = new StringBuilder();
                                sb.append("您已于").append(DateUtil.format(pass.getPassDatetime(), "yyyy年MM月dd日HH时mm分")).append(pass.getDeviceDirection()==1?"进入":"离开").append(areaCode==null?"考勤区域":areaCode.getText());

//                                msgService.sendMsg(pass.getUserId().intValue(), sb.toString());
                                logger.info("【短信】-发送成功["+pass.getUserName()+"]！内容："+sb.toString());
                            }catch (Exception e) {
                                logger.error(ExceptionUtil.getStackTrace(e));
                            }

                            //websocket TODO
                        }

                    }
                }
            }
        };
    }
}
