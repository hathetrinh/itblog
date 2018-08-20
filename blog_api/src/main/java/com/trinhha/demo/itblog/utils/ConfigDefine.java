package com.trinhha.demo.itblog.utils;

import org.springframework.beans.factory.annotation.Value;

public class ConfigDefine {

    @Value("${user.password.length.min}")
    public static String PASSWORD_MIN_LENGTH;
}
