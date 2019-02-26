package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_third_tst_user")
public class ThirdTstUser {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 单位ID
     */
    private String unitencodeid;

    /**
     * 用户名称
     */
    private String name;

    private String showname;

    private String role;

    private String tel1;

    private String tel2;

    private String tel3;

    private String roomid;

    private Byte curstate;

    private String curtitle;

    private String dm;

    private String yl;

    private Integer px;

    private String typename;

    private Date createtime;

    /**
     * 获取用户ID
     *
     * @return id - 用户ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户ID
     *
     * @param id 用户ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取单位ID
     *
     * @return unitencodeid - 单位ID
     */
    public String getUnitencodeid() {
        return unitencodeid;
    }

    /**
     * 设置单位ID
     *
     * @param unitencodeid 单位ID
     */
    public void setUnitencodeid(String unitencodeid) {
        this.unitencodeid = unitencodeid;
    }

    /**
     * 获取用户名称
     *
     * @return name - 用户名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名称
     *
     * @param name 用户名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return showname
     */
    public String getShowname() {
        return showname;
    }

    /**
     * @param showname
     */
    public void setShowname(String showname) {
        this.showname = showname;
    }

    /**
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return tel1
     */
    public String getTel1() {
        return tel1;
    }

    /**
     * @param tel1
     */
    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    /**
     * @return tel2
     */
    public String getTel2() {
        return tel2;
    }

    /**
     * @param tel2
     */
    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    /**
     * @return tel3
     */
    public String getTel3() {
        return tel3;
    }

    /**
     * @param tel3
     */
    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }

    /**
     * @return roomid
     */
    public String getRoomid() {
        return roomid;
    }

    /**
     * @param roomid
     */
    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    /**
     * @return curstate
     */
    public Byte getCurstate() {
        return curstate;
    }

    /**
     * @param curstate
     */
    public void setCurstate(Byte curstate) {
        this.curstate = curstate;
    }

    /**
     * @return curtitle
     */
    public String getCurtitle() {
        return curtitle;
    }

    /**
     * @param curtitle
     */
    public void setCurtitle(String curtitle) {
        this.curtitle = curtitle;
    }

    /**
     * @return dm
     */
    public String getDm() {
        return dm;
    }

    /**
     * @param dm
     */
    public void setDm(String dm) {
        this.dm = dm;
    }

    /**
     * @return yl
     */
    public String getYl() {
        return yl;
    }

    /**
     * @param yl
     */
    public void setYl(String yl) {
        this.yl = yl;
    }

    /**
     * @return px
     */
    public Integer getPx() {
        return px;
    }

    /**
     * @param px
     */
    public void setPx(Integer px) {
        this.px = px;
    }

    /**
     * @return typename
     */
    public String getTypename() {
        return typename;
    }

    /**
     * @param typename
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}