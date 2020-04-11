package com.apps.omnipotent.system.bean;

public class Connect {

    //主键
    private String id;

    //说明
    private String text;

    //时间
    private String time;

    //是否集群：0单机，1集群
    private String isha;

    //类型：0默认，1：ssh
    private String type;

    //连接名
    private String sname;

    //主机
    private String rhost;

    //主机
    private String shost;

    //redis端口
    private String rport;

    //ssh端口
    private String sport;

    //redis密码
    private String rpass;

    //ssh密码
    private String spass;

    //ssh登录私钥
    private String spkey;

    //是否启用ssl
    private String onssl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIsha() {
        return isha;
    }

    public void setIsha(String isha) {
        this.isha = isha;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getRhost() {
        return rhost;
    }

    public void setRhost(String rhost) {
        this.rhost = rhost;
    }

    public String getShost() {
        return shost;
    }

    public void setShost(String shost) {
        this.shost = shost;
    }

    public String getRport() {
        return rport;
    }

    public void setRport(String rport) {
        this.rport = rport;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getRpass() {
        return rpass;
    }

    public void setRpass(String rpass) {
        this.rpass = rpass;
    }

    public String getSpass() {
        return spass;
    }

    public void setSpass(String spass) {
        this.spass = spass;
    }

    public String getSpkey() {
        return spkey;
    }

    public void setSpkey(String spkey) {
        this.spkey = spkey;
    }

    public String getOnssl() {
        return onssl;
    }

    public void setOnssl(String onssl) {
        this.onssl = onssl;
    }
}
