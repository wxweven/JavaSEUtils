package com.wxweven.shortcut.enums;

/**
 * Created by wxweven on 2019/7/13.
 */
public enum Status {
    CONTINUEFDSAFS1(100),
    CONTINUEFDSFDS2(101),
    CONTINUEFDSFDS3(102);

    private int code;
    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
