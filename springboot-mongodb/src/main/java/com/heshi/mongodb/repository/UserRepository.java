package com.heshi.mongodb.repository;

import com.heshi.mongodb.DO.UserDO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDO, Integer> {
}
