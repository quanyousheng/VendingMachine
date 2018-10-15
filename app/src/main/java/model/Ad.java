package model;

import java.util.List;

/**
 * Author: andy
 * Time:2018/10/11 0011
 * Description:广告图对象
 */

public class Ad {
    private List<Ds> ds;

    public List<Ds> getDs() {
        return ds;
    }

    public void setDs(List<Ds> ds) {
        this.ds = ds;
    }

    public static class Ds {

        private int id;
        private String title;
        private String img;
        private int seconds;
        private int sortid;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        public int getSortid() {
            return sortid;
        }

        public void setSortid(int sortid) {
            this.sortid = sortid;
        }
    }
}
