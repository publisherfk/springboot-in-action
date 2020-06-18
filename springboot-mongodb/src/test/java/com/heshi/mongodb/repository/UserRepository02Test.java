package com.heshi.mongodb.repository;

import com.heshi.mongodb.DO.UserDO;
import com.heshi.mongodb.MongoDBApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoDBApp.class)
public class UserRepository02Test {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserRepository02 userRepository;

    @Test
    public void testFindByUsername() {
        UserDO userDO = userRepository.findByUsername("heshi");
        logger.info("result==" + userDO);
    }

    @Test // 使用 username 模糊查询，分页返回结果
    public void testFindByNameLike() {
        // 创建排序条件
        Sort sort = Sort.by(Sort.Direction.DESC, "id"); // ID 倒序
        // 创建分页条件。
        Pageable pageable = PageRequest.of(0, 10, sort);
        // 执行分页操作
        Page<UserDO> page = userRepository.findByUsernameLike("he", pageable);
        // 打印
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
    }
}
