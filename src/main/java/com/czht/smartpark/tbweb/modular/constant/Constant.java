package com.czht.smartpark.tbweb.modular.constant;

/**
 * 系统一些常量定义
 */
public interface Constant {

    String SESSION_USER = "TB_USER";

    int DEFAULT_LIMIT = 1000;

    /**
     * 可查看本部门的所有数据，以及其他部门的在岗情况，不可以查看具体通行记录
     */
    String ROLE_GENERAL = "general";


    String PASS_LOG_MODULE = "通行记录模块";

    /**
     * 添加
     */
    int PASS_LOG_TYPE_ADD = 1;

    /**
     * 修改
     */
    int PASS_LOG_TYPE_EDIT = 2;

    /**
     * 删除
     */
    int PASS_LOG_TYPE_DEL = 3;

    /**
     * 考勤异常情况被修正
     */
    int ATTEND_CAUSAL_FLAG_YES = 1;

    /**
     * 考勤异常情况没有被修正
     */
    int ATTEND_CAUSAL_FLAG_NO = 0;


}
