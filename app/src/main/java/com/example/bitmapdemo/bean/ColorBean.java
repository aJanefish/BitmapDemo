package com.example.bitmapdemo.bean;

public class ColorBean {
    int color;
    String des;

    public ColorBean(int color, String des) {
        this.color = color;
        this.des = des;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
