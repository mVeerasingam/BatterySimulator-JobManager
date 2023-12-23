package com.example.batterysimjobmanager_prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BatterySimJobManagerPrototypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatterySimJobManagerPrototypeApplication.class, args);
    }

}
