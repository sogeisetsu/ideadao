package com.suyuesheng;

import cn.suyuesheng.he.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloDemo {
    public static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3307/shiyan?characterEncoding=utf-8";
    public static final String DBUSER="root";
    public static final String DBPAS="su15990904343";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("hello world");
        Class.forName(DBDRIVER);
        Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPAS);
        con.close();
        Book bb = new Book(13.5, "kjjk");
    }
}
