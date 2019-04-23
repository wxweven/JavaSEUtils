package com.java8.optional;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * User实体
 * Created by wxweven
 * on 2017/5/19.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String address;
    private UserExt userExt;

    public User(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
