package com.mohbaba.api.data.repositories;

import com.mohbaba.api.data.models.View;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends MongoRepository<View, String> {
}
