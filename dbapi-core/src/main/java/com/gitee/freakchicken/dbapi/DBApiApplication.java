package com.gitee.freakchicken.dbapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @program: dbApi
 * @description:
 * @author: jiangqiang
 * @create: 2021-01-19 16:31
 **/
@SpringBootApplication
@ServletComponentScan
@EnableCaching
public class DBApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DBApiApplication.class, args);
    }

}
