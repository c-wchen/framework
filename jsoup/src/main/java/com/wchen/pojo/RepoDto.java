package com.wchen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepoDto {
    private String repoName;
    private String star;
    private String desc;
    private String lang;
}
