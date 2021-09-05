package com.wchen.basic.arr;


import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        // 数组创建方式
        int[] a = new int[4];

        int[] b = {1, 2, 3, 4};

        int[] c = new int[]{1, 2, 3};

        // Arrays工具类使用
        System.out.println(Arrays.toString(a) + " " + Arrays.toString(b) + " " + Arrays.toString(c));

    }
}
