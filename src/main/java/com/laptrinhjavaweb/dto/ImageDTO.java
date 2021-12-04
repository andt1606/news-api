package com.laptrinhjavaweb.dto;

public class ImageDTO {

    private Long id;
    private String name;
    private String type;
    private Byte[] picbyte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Byte[] getPicbyte() {
        return picbyte;
    }

    public void setPicbyte(Byte[] picbyte) {
        this.picbyte = picbyte;
    }
}
