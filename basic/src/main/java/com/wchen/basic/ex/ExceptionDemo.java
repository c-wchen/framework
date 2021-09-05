package com.wchen.basic.ex;

public class ExceptionDemo {
    /**
     * 不检查异常
     * extends RuntimeException
     */
    public void throwUncheckedEx(String str) {
        if (str.isEmpty()) {
            throw new NullPointerException();
        }
    }

    /**
     * 检查异常
     * extends Exception
     */
    public void throwCheckedEx(String str) throws CustomException {
        if (str.isEmpty()) {
            throw new CustomException();
        }
    }


    public void test() {
        try {
            throwCheckedEx(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void test2() {
        throwUncheckedEx(null);
    }

    public static void main(String[] args) {
        new ExceptionDemo().test2();
        System.out.println("hello world");
    }
}
