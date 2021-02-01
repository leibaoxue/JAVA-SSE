package com.xbd.pushdata.enums;

public enum IsNotDeleteFlag {
    IS_DELETE(1001, "删除"),
    IS_NOT_DELETE(1002, "不删除");
    private int code;
    private String str;

    IsNotDeleteFlag(int code, String str) {
        this.code = code;
        this.str = str;
    }

    public static String getCodeStr(int code) {
        for (IsNotDeleteFlag flagDelete : IsNotDeleteFlag.values()) {
            if (flagDelete.code == code) {
                return flagDelete.str;
            }
        }
        return "必填";
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public String getStr() {
        return this.str;
    }

    public void setStr(final String str) {
        this.str = str;
    }
}
