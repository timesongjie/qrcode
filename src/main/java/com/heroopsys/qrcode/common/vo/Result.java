package com.heroopsys.qrcode.common.vo;

import org.apache.commons.lang.StringUtils;

public class Result<T> {
    private Boolean result = true;

    private String msg = StringUtils.EMPTY;

    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
