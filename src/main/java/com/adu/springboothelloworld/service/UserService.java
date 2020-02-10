package com.adu.springboothelloworld.service;

import com.adu.springboothelloworld.annotation.ControllerWebLog;
import com.adu.springboothelloworld.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jintang
 * @date 2019-12-19
 */
@Service
@Slf4j
public class UserService {

    @ControllerWebLog
    public User getUser(Long id) {
        log.info("info");
        log.warn("warn");
        log.debug("debug");
        log.error("error");
        log.trace("trace");



        if (999L == id) {
            throw new RuntimeException();
        }

        return new User(id, "name");
    }

    @ControllerWebLog
    public void test() {
        log.info("test");
    }
}
