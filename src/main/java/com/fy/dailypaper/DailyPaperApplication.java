package com.fy.dailypaper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.fy.dailypaper.mapper")
public class DailyPaperApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyPaperApplication.class, args);
    }

}
