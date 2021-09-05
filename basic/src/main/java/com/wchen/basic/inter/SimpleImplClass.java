package com.wchen.basic.inter;

public class SimpleImplClass implements SimpleInterface{
    @Override
    public int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        new SimpleImplClass().defaultMethod();

    }
}
