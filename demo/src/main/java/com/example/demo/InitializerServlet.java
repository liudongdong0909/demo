package com.example.demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author IT_donggua
 * @version V1.0
 * @create 2018-03-13 下午 03:10
 */
@Configuration
@PropertySource(value = {"classpath:jdbc.properties"})
@SpringBootApplication
public class InitializerServlet extends SpringBootServletInitializer {

    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(jdbcDriverClassName);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(jdbcUsername);
        druidDataSource.setPassword(jdbcPassword);

        druidDataSource.setInitialSize(3);
        druidDataSource.setMaxActive(10);
        druidDataSource.setMinIdle(5);
        druidDataSource.setMaxWait(6000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);

        druidDataSource.setValidationQuery("SELECT 'X'");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(false);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        druidDataSource.setFilters("stat");

        return druidDataSource;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(InitializerServlet.class);
    }

    /**
     * ResponseBody格式化LocalDateTime
     *
     * Spring默认使用使用jackson来进行json格式转换，
     * 我们只需要使用@Bean注解创建一个ObjectMapperbean，并将JavaTimeModule注册到ObjectMapper中即可，
     * spring会使用该bean创建MappingJackson2HttpMessageConverter进行json格式转换。
     *
     */
    @Bean(name = "mapperObject")
    public ObjectMapper getObjectMapper() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        return  new ObjectMapper().registerModule(javaTimeModule);
    }
}
