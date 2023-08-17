package com.ko.playermatch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ko.playermatch.mapper")
@EnableScheduling   //开启定时任务
public class PlayerMatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerMatchApplication.class, args);
    }

}
