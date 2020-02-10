package com.adu.springboothelloworld.service;

import com.adu.springboothelloworld.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jintang
 * @date 2019-12-19
 */
@Service
public class ThreadService {
    @Autowired
    private UserService userService;

    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(2);

    public User getUser(Long id) {
        THREAD_POOL.submit(() -> userService.test());
        return new User(id, "Name");
    }
}
