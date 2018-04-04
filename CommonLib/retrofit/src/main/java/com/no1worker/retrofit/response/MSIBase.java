package com.no1worker.retrofit.response;

import java.io.Serializable;

/**
 * Created by yuzhiyong on 2018/3/22.
 */

public class MSIBase<T> implements Serializable{

    private int status;//0：成功；1：失败

    private String msg;//提示信息

    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
