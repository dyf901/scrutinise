package com.zty.scrutinise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.zty.scrutinise")
@MapperScan("com.zty.scrutinise.dao")
@EnableScheduling
public class ScrutiniseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrutiniseApplication.class, args);
    }

}
