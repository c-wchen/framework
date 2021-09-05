package com.wchen.basic.collection;


import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // 初始化容量进行优化，ArrayList太小会导致每次都进行重新申请内存
        ArrayList<Integer> list = new ArrayList<>(100);
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        // 删除操作
        list.remove(1);
        list.remove(2);
    }
}
