package com.wchen.proxy.mybatis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wchen
 * @since 2020/11/27
 * 简单模拟configuration的内容
 */
public class Configuration {
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost/test?useSSL=false";
    public static final String USER_NAME = "xxxx";
    public static final String PWD = "xxxxx";
    public static final Map<String, Mapper> methodMapper = new HashMap<String, Mapper>();

    static {
        methodMapper.put("com.wchen.dao.UserMapper.selectAll", new Mapper("select name, password from user_info", "com.wchen.pojo.User"));
    }

    public static class Mapper {
        private String sql;
        private String result;
        private Mapper(String sql, String result) {
            this.sql = sql;
            this.result = result;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
