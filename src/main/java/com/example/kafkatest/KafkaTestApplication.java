package com.example.kafkatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients(basePackages ={"com.kian.notification.api.**"})
public class KafkaTestApplication {


    public static void main(String[] args) {
        SpringApplication.run(KafkaTestApplication.class, args);
    }

}
