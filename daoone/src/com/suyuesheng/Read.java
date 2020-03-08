package com.suyuesheng;

import cn.suyuesheng.he.Book;

public class Read {
    private Book bb;
    private String name;

    public Read() {
    }

    public Read(Book bb) {
        this.bb = bb;
    }

    public Read(Book bb, String name) {
        this.bb = bb;
        this.name = name;
    }

    public Book getBb() {
        return bb;
    }

    public void setBb(Book bb) {
        this.bb = bb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Read{" +
                "bb=" + bb +
                ", name='" + name + '\'' +
                '}';
    }
}
