package com.wagner.demo.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Table(name = "menu")
public class Menu {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    protected Long id;

    @Column(name = "menu_name")
    private String menuName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    protected Date createTime;

    @Column(name = "create_user")
    protected String createUser;
}
