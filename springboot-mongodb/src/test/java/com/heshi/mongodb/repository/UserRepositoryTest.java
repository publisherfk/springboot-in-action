package com.heshi.mongodb.repository;

import com.heshi.mongodb.DO.UserDO;
import com.heshi.mongodb.MongoDBApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoDBApp.class)
public class UserRepositoryTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserRepository userRepository;

    @Test // 插入一条记录
    public void testInsert() {
        // 创建 UserDO 对象
        UserDO user = new UserDO();
        user.setId(1); // 这里先临时写死一个 ID 编号，后面演示自增 ID 的时候，在修改这块
        user.setUsername("heshi");
        user.setPassword("1");
        user.setCreateTime(new Date());
        // 创建 Profile 对象
        UserDO.Profile profile = new UserDO.Profile();
        profile.setNickname("publisher");
        profile.setGender(1);
        user.setProfile(profile);
        // 存储到 DB
        userRepository.insert(user);
    }

    @Test
    public void testUpdate() {
        Optional<UserDO> userResult = userRepository.findById(1);
        Assert.isTrue(userResult.isPresent(), "userdo object must exists!");
        UserDO userDO = userResult.get();
        logger.info("before==" + userDO);
        userDO.setUsername("heshi4");
        logger.info("after==" + userDO);
        userRepository.save(userDO);
    }

    @Test
    public void testDelete() {
        userRepository.deleteById(1);
        Optional<UserDO> userResult = userRepository.findById(1);
        Assert.isTrue(userResult.isPresent() == false, "userdo object not exists!");
    }

    @Test
    public void testSelectByIds() {
        Iterable<UserDO> users = userRepository.findAllById(Arrays.asList(1, 4));
        users.forEach(System.out::println);
    }
}

