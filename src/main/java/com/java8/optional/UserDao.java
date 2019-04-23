package com.java8.optional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * UserDao
 * Created by wxweven
 * on 2017/5/19.
 */
public class UserDao {
    private Map<Integer, User> users = new HashMap<>(100);

    public void initUsers() {
        IntStream.range(1, 100)
                .forEach(id -> users.put(id, new User(id, "name" + id, "address" + id)));

        users.get(1).setUserExt(new UserExt().setFired(true).setDate(new Date()));
        users.get(2).setUserExt(new UserExt().setFired(false).setDate(new Date()));
    }

    public User getById(int id) {
        initUsers();
        return users.get(id);
    }
}
