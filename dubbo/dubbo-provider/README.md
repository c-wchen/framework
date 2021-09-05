## dubbo + zookeeper
1. zookeeper下载并启动
> https://zookeeper.apache.org/releases.html
> ZOOKEEPER_HOME/bin/zkServer.cmd
2. 提供者
    * 配置服务名
    * 添加注册中心
    * 扫描包
    * 添加消费服务
```
dubbo:
  application:
    name: dubbo-provider
  registry:
    address: zookeeper://127.0.0.1:2181
  scan:
    base-packages: com.wchen.service
```
3. 消费者
    * 配置服务名
    * 配置注册中心
    * 获取提供者服务
    * 调用提供者服务
    
```
dubbo:
  application:
    name: dubbo-consumer
  registry:
    address: zookeeper://127.0.0.1:2181
```