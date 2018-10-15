package model;

/**
 * Author: andy
 * Time:2018/10/11 0011
 * Description:支付对象
 */

public class PayOrder {

    private int code;
    private String msg;
    private String qrcodeurl;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getQrcodeurl() {
        return qrcodeurl;
    }

    public void setQrcodeurl(String qrcodeurl) {
        this.qrcodeurl = qrcodeurl;
    }
}
