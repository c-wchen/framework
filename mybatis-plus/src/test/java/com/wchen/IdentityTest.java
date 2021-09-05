package com.wchen;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class IdentityTest {
   @Test
    public void testUUID() {
       Set<String> uuidSet = new HashSet<>();
       for (int i = 0; i < 10000; i++) {
           uuidSet.add(UUID.randomUUID().toString());
       }
       uuidSet.forEach(System.out::println);
       System.out.println(uuidSet.size());
   }
}
