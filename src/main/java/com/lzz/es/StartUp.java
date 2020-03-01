package com.lzz.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李振振
 * @version 1.0
 * @date 2020/2/29 13:19
 */
@SpringBootApplication
public class StartUp {
    public static void main(String[] args) {
        SpringApplication.run(StartUp.class, args);
    }
}
