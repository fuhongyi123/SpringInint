package com.spring.demo.module.perm.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "perm")
public class Perm {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer permId;
    private String permName;
    private String permCode;
    private String url;
}
