package com.codingshadows.ipgeolocation.bootloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class IpgeolocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(IpgeolocationApplication.class, args);
    }

}
