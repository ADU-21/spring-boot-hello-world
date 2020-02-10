package com.adu.springboothelloworld.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author jintang
 * @date 2020-02-05
 */
@Configuration
@Getter
public class AppConfiguration {
    @Value("${test.var}")
    private boolean Var;
}
