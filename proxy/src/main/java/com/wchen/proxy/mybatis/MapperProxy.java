package com.wchen.proxy.mybatis;

import com.wchen.pojo.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wchen
 * @since 2020/11/27 14:27
 * 从mybatis-config.xml中解析节点生成Configuration
 * 对全限定类名方法进行动态代理，实现Mapper
 */

@SuppressWarnings({"all"})
public class MapperProxy implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO 解析XML文件生成Configuration，通过Driver获取相关配置
        Class.forName(Configuration.DRIVER_NAME);
        Connection connection = DriverManager
                .getConnection(Configuration.URL, Configuration.USER_NAME, Configuration.PWD);
        // 从Mapper.xml文件中获取SQL语句
        String[] m = method.toString().split(" ");
        // 获取全限定方法名
        String methodName = m[m.length - 1].replaceAll("\\(w*\\)", "");
        Configuration.Mapper mapper = Configuration.methodMapper.get(methodName);
        // 使用PreparedStatement
        PreparedStatement statement = connection.prepareStatement(mapper.getSql());
        // TODO 进行参数处理
        ResultSet resultSet = statement.executeQuery();
        // 从ResultType属性上获取
        List<User> users = new LinkedList<User>();
        // 注入用户对象
        List<Object> results = new LinkedList<Object>();
        Class resultClass = Class.forName(mapper.getResult());
        while (resultSet.next()) {
            Object result = resultClass.newInstance();
            System.out.println(result);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <  metaData.getColumnCount() + 1; i++) {
                String resultMethodName = "set" + captureName(metaData.getColumnName(i));
                // 可以设置获取类的参数类型进行设置
                // TODO 驼峰命名法转换...
                resultClass.getDeclaredMethod(resultMethodName, String.class).invoke(result, resultSet.getString(metaData.getColumnName(i)));
            }
            results.add(result);
        }
        resultSet.close();
        connection.close();
        return results;
    }
    // 设置首字母大写
    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return  name;
    }
}
