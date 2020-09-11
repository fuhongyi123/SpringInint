package com.spring.demo.module.user_role.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "user_role")
public class UserRole implements Serializable {
    @Id
    private Long userId;
    @Id
    private Integer roleId;
}
