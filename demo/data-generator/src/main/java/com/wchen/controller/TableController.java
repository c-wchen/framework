package com.wchen.controller;

import com.wchen.mapper.TableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableController {
    @Autowired
    TableMapper tableMapper;

    @RequestMapping("/list")
    public Object list() {
        return tableMapper.listTable();
    }
    @ResponseBody
    @RequestMapping("/columns")
    public Object info(String tableName) {
        return tableMapper.listTableColumn(tableName);
    }
}
