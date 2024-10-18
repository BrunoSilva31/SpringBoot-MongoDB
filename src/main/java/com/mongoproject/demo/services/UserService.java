package com.mongoproject.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongoproject.demo.domain.User;
import com.mongoproject.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    
    public List<User> findAll(){
        return repo.findAll();
    }

    
}
