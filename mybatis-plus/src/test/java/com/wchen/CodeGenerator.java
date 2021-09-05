package com.wchen;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wchen
 * @since 2020/12/7
 */
public class CodeGenerator {
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String AUTHOR = "wchen";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://106.14.136.195:3306/framework";
    private static final String USER_NAME = "framework";
    private static final String PASSWORD = "6F69C76E7FFD74413E63FB566FD6ADAE";
    private static final String PROJECT_MODULE = "mybatis-plus";
    private static final String MODULE = "temp";

    /**
     * 全局配置
     * 配置相关文件名格式，项目出口等
     */
    public static GlobalConfig getGlobalConfig() {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_PATH + String.format("/%s/src/main/java", PROJECT_MODULE));
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setFileOverride(false);
        // 去掉业务逻辑层前缀
        gc.setServiceName("%sService");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.ONLY_DATE);
        // 自动生成Swagger
//        gc.setSwagger2(true);
        return gc;
    }

    /**
     * 配置数据源
     * 关联数据库，通过该数据库进行映射
     * @return
     */
    public static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        // 设置数据库类型
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUrl(URL);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        return dsc;
    }

    /**
     * 配置包信息
     * 配置文件存放的位置
     * @return
     */
    public static PackageConfig getPackageConfig() {
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(MODULE);
        pc.setParent("com.wchen");
        pc.setEntity("pojo");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        return pc;
    }
    /**
     * 模板配置
     */
    public static TemplateConfig getTemplateConfig() {
        TemplateConfig tc = new TemplateConfig();
        // 设置默认不生成配置文件
        tc.setXml(null);
        return tc;
    }
    /**
     * 注入配置， 个性定制化配置
     */
    public static InjectionConfig getInjectionConfig() {

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PROJECT_PATH + String.format("/%s/src/main/resources/mapper/", PROJECT_MODULE)
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    /**
     * 生成策略配置，对生成代码的相关配置
     * @return
     */
    public static StrategyConfig  getStrategyConfig() {
        // 生成策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 包含生成的表
        strategy.setInclude("user");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 设置映射类继承基类
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        strategy.setControllerMappingHyphenStyle(true);
        return strategy;
    }


    public static void main(String[] args) {
        // 构建代码生成器对象
        AutoGenerator generator = new AutoGenerator();
        GlobalConfig gc = getGlobalConfig();
        DataSourceConfig dsc = getDataSourceConfig();
        PackageConfig pc = getPackageConfig();
        TemplateConfig tc = getTemplateConfig();
        InjectionConfig cfg = getInjectionConfig();
        StrategyConfig sc = getStrategyConfig();

        generator.setGlobalConfig(gc);
        generator.setDataSource(dsc);
        generator.setPackageInfo(pc);
        generator.setTemplate(tc);
        generator.setCfg(cfg);
        generator.setStrategy(sc);
        // 执行生成
        generator.execute();
    }

}
