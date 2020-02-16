package com.hamidsultanzadeh.justblogapi.controller;

import com.hamidsultanzadeh.justblogapi.dto.ResponseDTO;
import com.hamidsultanzadeh.justblogapi.entity.User;
import com.hamidsultanzadeh.justblogapi.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    UserServiceInter userServiceInter;

    @GetMapping("/users")
    public ResponseEntity getUsers(@RequestParam(value = "uid",required = false) Integer id){

        if(id != null){
            User user = userServiceInter.findById(id);

            if(user == null)
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(1,"Not found",new ArrayList<>()));


            com.hamidsultanzadeh.justblogapi.dto.User userRes =
                    new com.hamidsultanzadeh.justblogapi.dto.User(user);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDTO(3,"OK!",new ArrayList<>(Collections.singletonList(userRes))));

        }

        List<User> userList = userServiceInter.findAll();
        List<com.hamidsultanzadeh.justblogapi.dto.User> users = new ArrayList<>();

        userList.forEach(u -> {
            users.add(new com.hamidsultanzadeh.justblogapi.dto.User(u));
        });

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(2,"OK!",users));
    }

}
