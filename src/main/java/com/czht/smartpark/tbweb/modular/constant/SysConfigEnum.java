package com.czht.smartpark.tbweb.modular.constant;

/**
 * 系统配置常量
 */
public enum SysConfigEnum {

    /**
     * FastDFS连接有效时长(毫秒数)
     */
    FDFS_CONNECT_TIMEOUT("connect_timeout", "50"),
    /**
     * FastDFS网络超时时长(毫秒数)
     */
    FDFS_NETWORK_TIMEOUT("network_timeout", "300"),
    /**
     * fastDFS使用的编码
     */
    FDFS_CHARSET("charset", "UTF-8"),
    /**
     * fastDFS tracker的http端口
     */
    FDFS_TRACKER_HTTP_PORT("http.tracker_http_port", "8888"),
    /**
     * fastDFS是否防盗链(no,yes)
     */
    FDFS_ANTI_STEAL_TOKEN("http.anti_steal_token", "no"),
    /**
     * fastDFS秘钥
     */
    FDFS_SECRET_KEY("http.secret_key", "FastDFS1234567890"),
    /**
     * fastDFS tracker地址（ip:port）
     */
    FDFS_TRACKER_SERVER("tracker_server", "192.168.10.201:22122"),

    /**
     * 服务端ZMQ通行播报地址（ip:port或ip1:port,ip2:port2）
     */
    ZMQ_PASS("zmq_pass", "192.168.10.202:5001,192.168.10.203:5001"),
    /**
     * 服务端ZMQ系统态势图广播地址（ip:port或ip1:port,ip2:port2）（修改后需要刷新页面）
     */
    ZMQ_SITUATION("zmq_situation", "192.168.10.202:8001,192.168.10.203:8001"),

    /**
     * 通保单点登陆地址
     */
    THIRD_OA_SSO_URL("sso_url", "http://192.168.1.80/api/oauth/sso");


    private String name;
    private String value;

    SysConfigEnum(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
