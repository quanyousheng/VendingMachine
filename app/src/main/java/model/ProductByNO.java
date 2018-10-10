package model;

import java.util.List;

/**
 * Author: andy
 * Time:2018/9/27 0027
 * Description:
 */

public class ProductByNO {

    private int pagecount;

    private List<DsBean> ds;

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public List<DsBean> getDs() {
        return ds;
    }

    public void setDs(List<DsBean> ds) {
        this.ds = ds;
    }

    public static class DsBean {
        private int row_number;
        private int id;
        private int agentid;
        private int machineid;
        private int aisleid;
        private int volume;
        private int productid;
        private int currentnum;
        private String aisleno;
        private String img_s;
        private String img_b;
        private String productname;
        private double price;

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

        public int getAgentid() {
            return agentid;
        }

        public void setAgentid(int agentid) {
            this.agentid = agentid;
        }

        public int getMachineid() {
            return machineid;
        }

        public void setMachineid(int machineid) {
            this.machineid = machineid;
        }

        public int getAisleid() {
            return aisleid;
        }

        public void setAisleid(int aisleid) {
            this.aisleid = aisleid;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public int getProductid() {
            return productid;
        }

        public void setProductid(int productid) {
            this.productid = productid;
        }

        public int getCurrentnum() {
            return currentnum;
        }

        public void setCurrentnum(int currentnum) {
            this.currentnum = currentnum;
        }

        public String getAisleno() {
            return aisleno;
        }

        public void setAisleno(String aisleno) {
            this.aisleno = aisleno;
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

        public String getProductname() {
            return productname;
        }

        public void setProductname(String productname) {
            this.productname = productname;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
