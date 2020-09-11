package com.spring.demo.module.user.service;

import com.spring.demo.module.user.entity.User;

public interface UserService {
    void register(User user);

    boolean isUsernameUsable(String username);

    int updataEmailstatus(Long id);

    User findUserByUserName(String username);
}
