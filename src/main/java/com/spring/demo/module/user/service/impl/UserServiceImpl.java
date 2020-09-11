package com.spring.demo.module.user.service.impl;

import com.spring.demo.module.user.entity.User;
import com.spring.demo.module.user.mapper.UserMapper;
import com.spring.demo.module.user.service.UserService;
import com.spring.demo.module.user_role.entity.UserRole;
import com.spring.demo.module.user_role.mapper.UserRoleMapper;
import com.spring.demo.utils.MailUtils;
import com.spring.demo.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public void register(User user) {
        user.setStatus(0);
//        MailUtils.sendMail("729182125@qq.com","这是一个邮箱","你好");
        String salt = SaltUtils.getSalt(10);
        String md5Pwd = new Md5Hash(user.getPassword(), salt, 1024).toHex();
        user.setPassword(md5Pwd);
        user.setSalt(salt);
        userMapper.insertSelective(user);

        MailUtils.sendMail(user.getEmail(), "<a href='http://localhost:8888/user/active/" + user.getUserId() + "'>" +
                "你正在注册xxxx系统，点击此链接以激活账户</a>", "激活邮件");
    }

    @Override
    public boolean isUsernameUsable(String username) {
        User user = new User();
        user.setUsername(username);
        int count = userMapper.selectCount(user);
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int updataEmailstatus(Long id) {
        User user1 = new User();
        user1.setUserId(id);
        user1.setStatus(1);

        return userMapper.updateByPrimaryKeySelective(user1);
    }

    @Override
    public User findUserByUserName(String username) {
        User user = new User();
        user.setUsername(username);
        return userMapper.selectOne(user);
    }


}
