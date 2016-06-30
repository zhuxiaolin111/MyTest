package com.example.administrator.mytest.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 */
public class xiaohua {



    private int res_code;
    private String res_error;


    private ResBodyBean res_body;

    public int getRes_code() {
        return res_code;
    }

    public void setRes_code(int res_code) {
        this.res_code = res_code;
    }

    public String getRes_error() {
        return res_error;
    }

    public void setRes_error(String res_error) {
        this.res_error = res_error;
    }

    public ResBodyBean getRes_body() {
        return res_body;
    }

    public void setRes_body(ResBodyBean res_body) {
        this.res_body = res_body;
    }

    public static class ResBodyBean {
        private int Counts;
        private int PageCount;


        private List<JokeListBean> JokeList;

        public int getCounts() {
            return Counts;
        }

        public void setCounts(int Counts) {
            this.Counts = Counts;
        }

        public int getPageCount() {
            return PageCount;
        }

        public void setPageCount(int PageCount) {
            this.PageCount = PageCount;
        }

        public List<JokeListBean> getJokeList() {
            return JokeList;
        }

        public void setJokeList(List<JokeListBean> JokeList) {
            this.JokeList = JokeList;
        }

        public static class JokeListBean {
            private String BillNo;
            private String JokeTitle;
            private String JokeContent;
            private int Type;

            public String getBillNo() {
                return BillNo;
            }

            public void setBillNo(String BillNo) {
                this.BillNo = BillNo;
            }

            public String getJokeTitle() {
                return JokeTitle;
            }

            public void setJokeTitle(String JokeTitle) {
                this.JokeTitle = JokeTitle;
            }

            public String getJokeContent() {
                return JokeContent;
            }

            public void setJokeContent(String JokeContent) {
                this.JokeContent = JokeContent;
            }

            public int getType() {
                return Type;
            }

            public void setType(int Type) {
                this.Type = Type;
            }
        }
    }
}
