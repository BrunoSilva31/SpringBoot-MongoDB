package com.mongoproject.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongoproject.demo.domain.User;
import com.mongoproject.demo.dto.UserDTO;
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


    public User insert(User obj) {
        if (obj.getId() == null) {
            obj.setId(UUID.randomUUID().toString());
        }
        
        return repo.insert(obj);
    }


    public void delete(String id) {

        if(!repo.existsById(id)) {
            throw new ObjectNotFoundException("Usuário não encontrado!");
        }

        repo.deleteById(id);
    }


    public User update(String id, User obj) {

        User newObj = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id));

        updateData(newObj, obj);

        return repo.save(newObj);
    }


    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }


   public User fromDTO(UserDTO objDto) {

    return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
   }



}
