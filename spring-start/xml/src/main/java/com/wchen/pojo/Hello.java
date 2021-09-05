package com.wchen.pojo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Component
public class Hello {
    @Value("chen")
    private String name;
    @Value("21")
    private String age;
    private List<String> happy;
}
