package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({"com.spring.demo.module.role.mapper", "com.spring.demo.module.perm.mapper" ,
           "com.spring.demo.module.user.mapper" , "com.spring.demo.module.user_role.mapper"})

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
