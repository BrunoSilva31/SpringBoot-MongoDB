package com.mongoproject.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongoproject.demo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{}
