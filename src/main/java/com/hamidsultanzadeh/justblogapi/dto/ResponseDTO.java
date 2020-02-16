package com.hamidsultanzadeh.justblogapi.dto;

import java.util.List;

public class ResponseDTO {

    private Integer code;
    private String status;
    private List<? extends Object> objectList;

    public ResponseDTO() {
    }

    public ResponseDTO(Integer code, String status, List<? extends Object> objectList) {
        this.code = code;
        this.status = status;
        this.objectList = objectList;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<? extends Object> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<? extends Object> objectList) {
        this.objectList = objectList;
    }
}
