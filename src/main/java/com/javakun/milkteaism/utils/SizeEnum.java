package com.javakun.milkteaism.utils;

public enum SizeEnum {

    SMALL(0, "Small"),
    MEDIUM(1, "Medium"),
    LARGE(2, "Large");

    private String size;
    private int code;
    
    SizeEnum(int code, String size) {
        this.code = code;
        this.size = size;
    }

    public String getSize() {
        return size;
    }

}
