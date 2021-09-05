package com.wchen.test;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
        String caseVal = "abc";
        switch(caseVal) {
            case "abc":
                System.out.println("abc");
                break;
            case "cdef":
                System.out.println("test");
                break;
            default:
                break;
        }
    }

}
