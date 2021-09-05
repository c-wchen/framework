package com.wchen.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent("basic shell")
public class BasicCommand {

    /**
     *ShellMethod
     *   key     设置命令名称集合
     *   value   设置描述
     *   prefix  设置命令前缀
     *   group   设置命令分组
     */
    @ShellMethod("Add two integers together.")
    public int add(int a, int b) {
        return a + b;
    }
    @ShellMethod("hello world")
    public void hello() {
        System.out.println("hello world");
    }
}