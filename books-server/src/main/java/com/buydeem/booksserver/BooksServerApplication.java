package com.buydeem.booksserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.buydeem.booksserver.api")
public class BooksServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksServerApplication.class, args);
    }
}
