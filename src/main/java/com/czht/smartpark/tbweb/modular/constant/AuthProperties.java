package com.czht.smartpark.tbweb.modular.constant;

public class AuthProperties {

    /**
     * 拥有最大权限，可以查看系统所有数据，以及所有修改权限；
     */
    public static String role_admin = "admin";

    /**
     * 拥有高级权限，可以查看本单位以及修改所有本单位的数据
     */
    public static String role_senior = "senior";

    /**
     * 拥有中级权限，可以查看本部门以及修改所有本部门的数据
     */
    public static String role_middle = "middle";

    /**
     * 拥有普通用户的权限，可以查看1.本部门所有数据，但不可以修改数据2.可以查看其他部门的基本数据，除过与通行记录有关的数据
     */
    public static String role_general = "general";

    /**
     * 可以查看所有数据，但是不能修改任何数据
     */
    public static String role_view = "view";


}
