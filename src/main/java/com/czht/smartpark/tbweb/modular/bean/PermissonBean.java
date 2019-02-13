package com.czht.smartpark.tbweb.modular.bean;

import com.czht.smartpark.tbweb.context.support.HttpServletRequestHolder;
import com.czht.smartpark.tbweb.modular.constant.AuthProperties;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;

/**
 * 权限有关的bean
 */
public class PermissonBean {

    /**
     * 部门父ID
     */
    private Integer deptId;
    private Integer deptPid;

    /**
     * 用户ID
     */
    private Long userId;

    public PermissonBean(){}

    public Integer getDeptId() {
        /*UserDTO user = getSessinonUser();
        if(user != null){
            // 这里开始数据权限判断
            String role = user.getDataRole();
            if(AuthProperties.ROLE_ADMIN.equals(role)){
                deptId = 0;
            }else if(AuthProperties.ROLE_SENIOR.equals(role)){
                deptId = 0;
            }else if(AuthProperties.ROLE_VIEW.equals(role)){
                deptId = 0;
            }else {
                deptId = user.getDeptId();
            }
        }*/
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptPid() {

        /*UserDTO user = getSessinonUser();
        if(user != null){
            // 这里开始数据权限判断
            String role = user.getDataRole();
            if(AuthProperties.ROLE_ADMIN.equals(role)){
                deptId = 0;
            }else if(AuthProperties.ROLE_SENIOR.equals(role)){
                deptPid = user.getDeptId();
            }else if(AuthProperties.ROLE_VIEW.equals(role)){
                deptPid = user.getDeptId();
            }else {
                deptPid = user.getDeptId();
            }
        }*/
        return deptPid;
    }

    public void setDeptPid(Integer deptPid) {
        this.deptPid = deptPid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private UserDTO getSessinonUser(){
        return HttpServletRequestHolder.getSessionInfo();
    }

}
