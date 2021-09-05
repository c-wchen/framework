package com.wchen.basic.stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamType {
    public static void main(String[] args) {
        IntStream.range(1, 10).filter(a -> a % 2 == 0).map(a->a * 2).forEach(System.out::println);

    }
}
