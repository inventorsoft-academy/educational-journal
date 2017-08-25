package com.perepelitsya.demo;

import com.perepelitsya.custom.CustomList;

import java.util.Arrays;

/**
 * Created by Andriu on 8/25/2017.
 */
public class Mainq {
    public static void main(String[] args) {
        CustomList<Integer> list = new CustomList<>();

        list.add(2);
        list.add(13);
        list.add(6);

        Integer[] mas = {1, -2, 12, -23};
        list.sortToMax();

        System.out.println(list);
    }
}
