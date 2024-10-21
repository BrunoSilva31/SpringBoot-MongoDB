package com.mongoproject.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongoproject.demo.domain.User;
import com.mongoproject.demo.repository.UserRepository;
import com.mongoproject.demo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    
    public List<User> findAll(){
        return repo.findAll();
    }


    public User findById(String id) {

        Optional<User> user = repo.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }


    
}
