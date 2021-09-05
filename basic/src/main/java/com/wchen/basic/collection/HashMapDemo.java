package com.wchen.basic.collection;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HashMapDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        IntStream.iterate(0, i -> i + 11).limit(1000000).forEach(i -> {
            map.put("" + i, "v" + i);
        });

        map.get("11");

        Field table = map.getClass().getDeclaredField("table");
        table.setAccessible(true);

        Object[] obj = (Object[])table.get(map);
        Arrays.stream(obj).filter(Objects::nonNull)
                .filter(item -> item.getClass().getName()
                        .contains("TreeNode"))
                            .forEach(System.out::println);


    }




}
