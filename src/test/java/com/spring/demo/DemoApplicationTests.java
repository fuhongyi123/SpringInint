package com.spring.demo;

import com.spring.demo.module.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private UserService userService;
    @Test
    public void contextLoads() {

    }


}
