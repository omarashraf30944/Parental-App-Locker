package com.example.controllproject.locked_app.data;

public class DataItem {
    String text;
    int img;
    boolean isLock;

    public DataItem(String text, int img, boolean isLock) {
        this.text = text;
        this.img = img;
        this.isLock = isLock;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }
}
