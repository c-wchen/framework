package com.wchen;

import com.wchen.util.GithubUtils;
import com.wchen.util.JDUtils;

import java.io.IOException;

public class JsoupMain {
    public static void main(String[] args) throws IOException {
//        JDUtils.search("书籍", 1).forEach(System.out::println);
        GithubUtils.parse("java");

    }
}
