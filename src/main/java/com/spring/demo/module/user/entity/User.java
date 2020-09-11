package com.spring.demo.module.user.entity;

import com.spring.demo.module.role.entity.Role;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name = "user")
public class User implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long userId;

    private String username;
    private String password;
    private String phone_number;
    private String email;
    private String salt;
    private String url;
    private Integer status;

    List<Role > roles;
}
