package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.bean.countOnWorkBean;
import com.czht.smartpark.tbweb.modular.dmo.TsTodayOnworkCount;
import com.czht.smartpark.tbweb.modular.dto.OnWorkPassDTO;
import com.czht.smartpark.tbweb.modular.dto.OnWrokCntDTO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TsTodayOnworkCountMapper extends Mapper<TsTodayOnworkCount> {

    /**
     * 统计24小时在岗人数
     * @param bean
     * @return
     */
    List<TsTodayOnworkCount> countOnworkBy24h(@Param("areaId") Integer areaId, @Param("deptPid") Integer deptPid, @Param("deptId")  Integer deptId);

    /**
     * 根据在岗类型统计
     * @param deptPid
     * @return
     */
    List<OnWrokCntDTO> countOnworkByType(@Param("deptId") Integer deptId, @Param("deptPid") Integer deptPid);

    /**
     * 不同区域人员在岗数统计
     * @param deptPid
     * @return
     */
    List<OnWrokCntDTO> countOnworkByArea(@Param("deptId") Integer deptId, @Param("deptPid") Integer deptPid);

    /**
     * 某个区域 不同部门在岗情况
     * @param areaId
     * @param deptPid
     * @return
     */
    List<OnWrokCntDTO> countOnworkByDept(@Param("areaId") Integer areaId,  @Param("deptPid") Integer deptPid);

    /**
     * 查看在岗记录
     * @param bean
     * @return
     */
    List<OnWorkPassDTO> getOnWorkPassRecords(countOnWorkBean bean);

    /**
     * 查看在岗记录
     * @param bean
     * @return
     */
    List<OnWorkPassDTO> getOnWorkPassRecordsBy24h(countOnWorkBean bean);



    /**
     * 查看临时离岗记录
     * @param bean
     * @return
     */
    List<OnWorkPassDTO> getTempWorkPassRecords(countOnWorkBean bean);

    /**
     * 查看不在岗记录
     * @param bean
     * @return
     */
    List<OnWorkPassDTO> getOffWorkPassRecords(countOnWorkBean bean);

    /**
     * 查看所有人在岗情况，如果不在岗，显示最后一条记录
     * @param bean
     * @return
     */
    List<OnWorkPassDTO> getUsersOnworkPassRecords(countOnWorkBean bean);

    /**
     * 统计迟到情况
     * @param bean
     * @return
     */
    List<OnWrokCntDTO> countOnWorkByAttend(countOnWorkBean bean);

    /**
     * 考勤情况
     * @param bean
     * @return
     */
    List<OnWorkPassDTO> getOnWorkAttendPassRecords(countOnWorkBean bean);
}