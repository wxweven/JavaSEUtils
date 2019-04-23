package com.java8.optional;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

/**
 * Optional 正确使用姿势
 * Created by wxweven
 * on 2017/5/19.
 */
@Slf4j
public class OptionalTest {
    private static final String UNKNOWN_NAME = "未知用户名";

    @Test
    public void testUser() {
        UserService userService = new UserService();
        Optional<User> user = userService.getUserById(445);
        String userName = user.map(User::getAddress)
                .map(String::toUpperCase)
                .orElse(UNKNOWN_NAME);

        System.out.println(userName);

    }

    @Test
    public void testUserOptional() throws Exception {
        UserService userService = new UserService();
        Optional<User> user = userService.getUserById(199);

        UserExt userExt = user.map(User::getUserExt)
                .filter(ext -> !ext.isFired())
                .orElseThrow(() -> new Exception("用户不合法"));

        log.info("userExt={}", userExt);

    }
}
