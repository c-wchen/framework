package com.wchen.proxy.mybatis;

@SuppressWarnings("all")
public class SqlSession {
    /**
     * 通过Mapper Class动态代理实现
     * @param mapper
     * @param <T>
     * @return
     */
    public static <T> T getMapper(Class<T> mapper) {
        T obj;
        obj = (T) java.lang.reflect.Proxy.newProxyInstance(
                        mapper.getClassLoader(),
                        new Class[] { mapper },
                        new MapperProxy());
        return obj;
    }
}
