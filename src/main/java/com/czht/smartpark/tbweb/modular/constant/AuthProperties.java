package com.czht.smartpark.tbweb.modular.constant;

public class AuthProperties {

    /**
     * 拥有最大权限，可以查看系统所有数据，以及所有修改权限；可以查看后台管理系统
     */
    public static String ROLE_ADMIN = "admin";

    /**
     * 可以查看所有数据，但是可以修改大队领导和军事办的权限
     */
    public static String ROLE_SENIOR = "senior";

    /**
     * 拥有中级权限，可以查看本部门以及修改所有本部门的数据
     */
    public static String ROLE_MIDDLE = "middle";

    /**
     * 拥有普通用户的权限，可以查看1.本部门所有数据，但不可以修改数据2.可以查看其他部门的基本数据，除过与通行记录有关的数据
     */
    public static String ROLE_GENERAL = "general";

    /**
     * 可以查看所有数据，但是不能修改任何数据
     */
    public static String ROLE_VIEW = "view";


}
