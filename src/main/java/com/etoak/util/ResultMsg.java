package com.etoak.util;

/**
 * Created by Adam on 2018/11/7 16:43.
 */
public class ResultMsg {
    private Integer code;
    private String msg;

    public ResultMsg() {}

    public ResultMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
