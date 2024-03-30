package com.mohbaba.api.data.repositories;

import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
    boolean existsByUsername(String username);
}
