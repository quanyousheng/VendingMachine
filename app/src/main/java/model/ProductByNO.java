package model;

import java.util.List;

/**
 * Author: andy
 * Time:2018/9/27 0027
 * Description:
 */

public class ProductByNO {

    private int pagecount;
    private List<Ds> ds;

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public List<Ds> getDs() {
        return ds;
    }

    public void setDs(List<Ds> ds) {
        this.ds = ds;
    }

    public static class Ds {

        private int row_number;
        private int id;
        private int tmptid;
        private String aisleno;
        private int volume;
        private boolean isonline;
        private boolean ishotsale;
        private int status;
        private int productid;
        private double price_discount;
        private int sortid;
        private int classid;
        private String productname;
        private String place;
        private double price;
        private String spec;
        private String img_s;
        private String img_b;
        private String classname;

        public int getRow_number() {
            return row_number;
        }

        public void setRow_number(int row_number) {
            this.row_number = row_number;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTmptid() {
            return tmptid;
        }

        public void setTmptid(int tmptid) {
            this.tmptid = tmptid;
        }

        public String getAisleno() {
            return aisleno;
        }

        public void setAisleno(String aisleno) {
            this.aisleno = aisleno;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public boolean isIsonline() {
            return isonline;
        }

        public void setIsonline(boolean isonline) {
            this.isonline = isonline;
        }

        public boolean isIshotsale() {
            return ishotsale;
        }

        public void setIshotsale(boolean ishotsale) {
            this.ishotsale = ishotsale;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getProductid() {
            return productid;
        }

        public void setProductid(int productid) {
            this.productid = productid;
        }

        public double getPrice_discount() {
            return price_discount;
        }

        public void setPrice_discount(double price_discount) {
            this.price_discount = price_discount;
        }

        public int getSortid() {
            return sortid;
        }

        public void setSortid(int sortid) {
            this.sortid = sortid;
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

        public String getSpec() {
            return spec;
        }

        public void setSpec(String spec) {
            this.spec = spec;
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

        public String getClassname() {
            return classname;
        }

        public void setClassname(String classname) {
            this.classname = classname;
        }
    }
}
