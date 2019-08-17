package com.newegg.mkpl.api.blogsystem.pojo;

import com.newegg.mkpl.api.blogsystem.enums.StateEnum;


/**
 * 包装返回的数据
 *
 * @author vz04
 * @date 8/8/2019 4:00 PM
 **/
public class Pack {

    private int code;
    private String message;
    private Object data;

    public Pack success(String message) {
        this.code = StateEnum.SUCCESS.value();
        this.message = message;
        this.data = null;
        return this;
    }

    public Pack success(String message, Object data) {
        this.code = StateEnum.SUCCESS.value();
        this.message = message;
        this.data = data;
        return this;
    }

    public Pack fail(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pack{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
