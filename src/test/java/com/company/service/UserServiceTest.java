package com.company.service;

import com.company.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class UserServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

//    @Test
//    public void testInsertUser() {
//        User user = new User();
//        int insertCount = 0;
//
//        user.setUserId(2);
//        user.setUsername("杨静");
//        user.setPassword("123456");
//        user.setNickname("南北");
//        user.setGender(false);
//
//        insertCount = userService.insertUser(user);
//        logger.info("insertCount = " + insertCount);
//    }

    @Test
    public void testInsertUserSelective() {
        User user = new User();
        int insertCount = 0;

        user.setUsername("杨静");
        user.setPassword("123456");
        user.setNickname("南北");

        insertCount = userService.insertUser(user);
        logger.info("insertCount = " + insertCount);
    }

}
