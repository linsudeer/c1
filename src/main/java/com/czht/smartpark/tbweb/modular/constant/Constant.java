package com.czht.smartpark.tbweb.modular.constant;

/**
 * 系统一些常量定义
 */
public interface Constant {

    String SESSION_USER = "TB_USER";

    int DEFAULT_LIMIT = 1000;

    /**
     * 可以查看所有数据，可以修改所有数据
     */
    String ROLE_ADMIN = "admin";

    /**
     * 可查看和修改本单位的所有数据
     */
    String ROLE_SENIOR = "senior";

    /**
     * 可查看修改本单位本部门的所有数据
     */
    String ROLE_MIDDLE = "middle";

    /**
     * 可查看本部门的所有数据，以及其他部门的在岗情况，不可以查看具体通行记录
     */
    String ROLE_GENERAL = "general";


}
