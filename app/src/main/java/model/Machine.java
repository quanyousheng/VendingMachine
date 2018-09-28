package model;

/**
 * Author: andy
 * Time:2018/9/27 0027
 * Description:售货机
 */

public class Machine {

    private int id;
    private String mchno;
    private String typename;
    private String orgtype;
    private int aisletmptid;
    private String nameself;
    private String serialtype;
    private int heartbeat;
    private int restart;
    private int maxtimeout;
    private int agentid;
    private String loginpwd;
    private String refundpwd;
    private String govname;
    private String departname;
    private String address;
    private String setuptime;
    private String expiretime;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMchno() {
        return mchno;
    }

    public void setMchno(String mchno) {
        this.mchno = mchno;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(String orgtype) {
        this.orgtype = orgtype;
    }

    public int getAisletmptid() {
        return aisletmptid;
    }

    public void setAisletmptid(int aisletmptid) {
        this.aisletmptid = aisletmptid;
    }

    public String getNameself() {
        return nameself;
    }

    public void setNameself(String nameself) {
        this.nameself = nameself;
    }

    public String getSerialtype() {
        return serialtype;
    }

    public void setSerialtype(String serialtype) {
        this.serialtype = serialtype;
    }

    public int getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(int heartbeat) {
        this.heartbeat = heartbeat;
    }

    public int getRestart() {
        return restart;
    }

    public void setRestart(int restart) {
        this.restart = restart;
    }

    public int getMaxtimeout() {
        return maxtimeout;
    }

    public void setMaxtimeout(int maxtimeout) {
        this.maxtimeout = maxtimeout;
    }

    public int getAgentid() {
        return agentid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }

    public String getRefundpwd() {
        return refundpwd;
    }

    public void setRefundpwd(String refundpwd) {
        this.refundpwd = refundpwd;
    }

    public String getGovname() {
        return govname;
    }

    public void setGovname(String govname) {
        this.govname = govname;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSetuptime() {
        return setuptime;
    }

    public void setSetuptime(String setuptime) {
        this.setuptime = setuptime;
    }

    public String getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(String expiretime) {
        this.expiretime = expiretime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
