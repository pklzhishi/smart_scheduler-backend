package org.example.smart_schedulerbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("org.example.smart_schedulerbackend.mapper")
@EnableCaching
@SpringBootApplication
public class SmartSchedulerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartSchedulerBackendApplication.class, args);
    }

}
