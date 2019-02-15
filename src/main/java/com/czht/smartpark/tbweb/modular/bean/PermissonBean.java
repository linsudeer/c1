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
        UserDTO user = getSessinonUser();
        if(user != null){
            // 这里开始数据权限判断
            String role = user.getDataRole();

            if(role.contains(AuthProperties.ROLE_GENERAL)){// 最低权限，只可以看到本部门的通行记录
                deptId = user.getDeptId();
            }else {// 其他角色可以看到所有部门的
                deptId = 0;
            }
        }
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptPid() {

        UserDTO user = getSessinonUser();
        if(user != null){
            // 这里开始数据权限判断
            String role = user.getDataRole();
            if(role.contains(AuthProperties.ROLE_ADMIN) || role.contains(AuthProperties.ROLE_VIEW)){// 只有管理员和数据查看两个角色可以查看所有数据，否则只能看本部门下的数据
                deptPid = 0;
            }else {
                deptPid = user.getDeptPid();
            }
        }
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
