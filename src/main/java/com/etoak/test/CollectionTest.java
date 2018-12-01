package com.etoak.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 2018/11/19 21:24.
 */
public class CollectionTest {

    public static void main(String[] args) {

        ListTest listTest = new ListTest("Adam","Sun");
        ListTest listTest1 = new ListTest("Adams","");

        List<ListTest> list = new ArrayList<>();
        list.add(listTest);
        list.add(listTest1);
        System.out.println("Hello");
        //list.forEach(x -> System.out.println(x.getName() + "||" + x.getValue()));
        System.out.println(list.remove(new ListTest("a","b")));
        System.out.println(list.remove(new ListTest("a","b")));
        list.forEach(x -> System.out.println(x.getName() + "||" + x.getValue()));


    }
}

class ListTest {
    private String name;
    private String value;

    public ListTest(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

}
