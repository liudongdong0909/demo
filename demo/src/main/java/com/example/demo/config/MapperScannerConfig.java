package com.example.demo.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * 保证在MybatisConfig实例化之后再实例化该类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2018-03-13 下午 03:30
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MapperScannerConfig {

    /**
     * mapper 接口的扫描器
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.example.demo.mapper");
        return mapperScannerConfigurer;
    }

}
