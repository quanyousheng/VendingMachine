package model;

/**
 * Author: andy
 * Time:2018/9/27 0027
 * Description:
 */

public class Product {

    private int id;
    private int classid;
    private String productname;
    private String place;
    private double price;
    private double costprice;
    private String spec;
    private String lotno;
    private String img_s;
    private String img_b;
    private String descr;
    private String addtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCostprice() {
        return costprice;
    }

    public void setCostprice(double costprice) {
        this.costprice = costprice;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getLotno() {
        return lotno;
    }

    public void setLotno(String lotno) {
        this.lotno = lotno;
    }

    public String getImg_s() {
        return img_s;
    }

    public void setImg_s(String img_s) {
        this.img_s = img_s;
    }

    public String getImg_b() {
        return img_b;
    }

    public void setImg_b(String img_b) {
        this.img_b = img_b;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
