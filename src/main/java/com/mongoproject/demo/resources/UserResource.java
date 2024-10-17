package com.mongoproject.demo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongoproject.demo.domain.User;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        
        User maria = new User("maria@gmail.com", "1", "Maria Brown");
        User alex = new User("alex@email.com", "2", "Alex Green");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(list);
    }
}
