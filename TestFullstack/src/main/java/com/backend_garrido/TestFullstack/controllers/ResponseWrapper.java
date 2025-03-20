package com.backend_garrido.TestFullstack.controllers;

import java.util.List;

public class ResponseWrapper<T> {

    private boolean status;
    private String msg;
    private List<T> data;

    // Constructor sin parámetros
    public ResponseWrapper() {
    }

    // Constructor con parámetros
    public ResponseWrapper(boolean status, String msg, List<T> data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    // Getters y setters
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

