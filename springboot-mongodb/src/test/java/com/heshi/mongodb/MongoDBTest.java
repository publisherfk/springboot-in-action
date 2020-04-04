package com.heshi.mongodb;

import com.heshi.mongodb.entity.Trace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author: fukun
 * @Date: 2020/3/31 22:35
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void add() {
        Trace trace = new Trace();
        trace.setLatitude("123.434545D");
        trace.setLongitude("43.4545");
        trace.setUserId(343545465L);
        trace.setTimestamp(Timestamp.valueOf(LocalDateTime.now()).getTime());
        mongoTemplate.save(trace);
    }

    @Test
    public void query() {
        Query query = new Query(Criteria.where("userId").is(343545465L));
        Trace trace = mongoTemplate.findOne(query, Trace.class);
        logger.info(String.valueOf(trace));
    }
}
