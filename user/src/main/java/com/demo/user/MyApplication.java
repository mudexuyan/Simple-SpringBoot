package com.demo.user;

import com.demo.springboot.SpringApplication;
import com.demo.springboot.SpringBootApplication;
import com.demo.springboot.WebServerAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class);

    }
}
