package com.czht.smartpark.tbweb.modular.service;

import com.czht.smartpark.tbweb.modular.bean.countOnWorkBean;
import com.czht.smartpark.tbweb.modular.dmo.TsTodayOnworkCount;
import com.czht.smartpark.tbweb.modular.dto.OnWorkPassDTO;
import com.czht.smartpark.tbweb.modular.dto.OnWrokCntDTO;

import java.util.List;

/**
 * 实时数据
 */
public interface CurrentService {

    /**
     * 24小时在岗人数统计
     * @param deptPid
     * @return
     */
    List<TsTodayOnworkCount> countOnWorkBy24h(Integer areaId, Integer deptPid, Integer deptId);

    /**
     * 根据在岗类型统计
     * @param deptPid
     * @return
     */
    List<OnWrokCntDTO> countOnworkByType(Integer deptId, Integer deptPid);

    /**
     * 不同区域人员在岗树统计
     * @param deptPid
     * @return
     */
    List<OnWrokCntDTO> countOnworkByArea(Integer deptId, Integer deptPid);

    /**
     * 某个区域 不同部门在岗情况
     * @param areaId
     * @param deptPid
     * @return
     */
    List<OnWrokCntDTO> countOnworkByDept(Integer areaId, Integer deptPid);

    /**
     * 统计某区域，不同人员进出次数
     * @param areaId
     * @param deptPid
     * @return
     */
    List<OnWrokCntDTO> countInOutByUserGroup(Integer areaId, Integer deptPid);

    /**
     * 查看在岗人员
     * @param bean
     * @return
     */
    List<OnWorkPassDTO> getOnWorkPassRecords(countOnWorkBean bean);
}
