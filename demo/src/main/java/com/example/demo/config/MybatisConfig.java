package com.example.demo.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author IT_donggua
 * @version V1.0
 * @create 2018-03-13 下午 03:26
 */
@Configuration
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    /**
     * 当容器中没有指定的Bean的情况下创建该对象
     */
    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactoryBean sqlSessionFactoryBean(){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置mybatis的配置文件
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource sqlMapConfigXml = resourcePatternResolver.getResource("classpath:mybatis/sqlMapConfig.xml");
        sqlSessionFactoryBean.setConfigLocation(sqlMapConfigXml);
        // 设置别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.demo.model");

        return sqlSessionFactoryBean;
    }
}
