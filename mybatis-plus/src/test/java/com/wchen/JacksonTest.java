package com.wchen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.wchen.pojo.User;
import org.junit.jupiter.api.Test;

public class JacksonTest {
    @Test
    public void  testSerializable() throws JsonProcessingException {
        User user = new User();
        user.setPassword("chen");
        user.setUserName("wang");
        user.setUserId(1212L);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(user));
    }
    @Test
    public void testFilter() throws JsonProcessingException {
        User user = new User();
        user.setPassword("chen");
        user.setUserName("wang");
        user.setUserId(1212L);
        SimpleFilterProvider filter = new SimpleFilterProvider();
        filter.addFilter("myFilter", SimpleBeanPropertyFilter.serializeAllExcept("userId"));



        System.out.println(new ObjectMapper().setFilterProvider(filter).writeValueAsString(user));
    }

}
