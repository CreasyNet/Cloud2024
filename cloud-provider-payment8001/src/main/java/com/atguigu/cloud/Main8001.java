package com.atguigu.cloud;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.atguigu.cloud.mapper")
@RefreshScope // 动态刷新
public class Main8001 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Main8001.class,args);
    }
}