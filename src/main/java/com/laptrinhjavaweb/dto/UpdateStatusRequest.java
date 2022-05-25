package com.laptrinhjavaweb.dto;

import java.util.List;

public class UpdateStatusRequest {
    private List<Long> id;
    private Integer status;

    public List<Long> getId() {
        return id;
    }

    public void setId(List<Long> id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
