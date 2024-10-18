package com.mongoproject.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mongoproject.demo.domain.User;
import com.mongoproject.demo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        
        User maria = new User("maria@gmail.com", null, "Maria Brown");
        User alex = new User("alex@verdinho.com", null, "Alex Green");
        User bob = new User("bob@construtor.com", null, "Bob Grey");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }


}