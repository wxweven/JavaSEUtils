/**
 * @(#)LiveTemplatesTest.java, Jul 07, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven;

import com.java8.optional.User;
import com.java8.optional.UserExt;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;


/**
 * @author wangxw03
 */
public class LiveTemplatesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LiveTemplatesTest.class);
    private static final int ZERO = 0;

    private User user;

    public void test(int i, String a){
        LOGGER.info("test:" + "i = [" + i + "], a = [" + a + "]");

        List<Integer> integers = Collections.singletonList(11);

        try {
            System.out.println();
            User userDao = new User();
            userDao.setId(0);
            userDao.setName("");
            userDao.setAddress("");
            userDao.setUserExt(new UserExt());

            CollectionUtils.isNotEmpty(integers);




            set(userDao);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }


        System.out.println();


    }

    private void set(User userDao) {
        userDao.setId(ZERO);
        userDao.setName("");
        userDao.setAddress("");
        userDao.setUserExt(new UserExt());
    }


}