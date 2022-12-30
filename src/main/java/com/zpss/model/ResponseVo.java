package com.zpss.model;

public class ResponseVo {
    private int id;
    private String msg;
    private Object data;

    public ResponseVo(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public ResponseVo(int id, String msg, Object data) {
        this.id = id;
        this.msg = msg;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
