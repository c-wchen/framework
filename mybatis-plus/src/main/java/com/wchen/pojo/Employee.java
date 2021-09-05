package com.wchen.pojo;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    public interface T1View{};
    public interface T2View extends T1View{};
    @JsonView(T1View.class)
    private String name;
    @JsonView(T2View.class)
    private String password;
    @JsonView(T1View.class)
    private String email;
    @JsonView(T2View.class)
    private Integer sex;
    @JsonView(T2View.class)
    private Integer age;
    private String address;
}
