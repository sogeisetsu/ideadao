package cn.one;

import java.util.ArrayList;
import java.util.List;

public class AA {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("hi");
        list.add("hello");
        list.add("haha");
        list.forEach(System.out::println);
        System.out.println("\n"+">-----------------");
        list.forEach((ll)->System.out.print(ll+"\t"));
    }
}
