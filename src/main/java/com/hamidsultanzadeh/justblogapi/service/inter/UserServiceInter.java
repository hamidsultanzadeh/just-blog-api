package com.hamidsultanzadeh.justblogapi.service.inter;

import com.hamidsultanzadeh.justblogapi.entity.User;

import java.util.List;

public interface UserServiceInter {

    List<User> findAll();

    boolean save(User user);

    User findById(Integer id);

    User findByUsername(String u);

    boolean editProfile(User u);

    boolean editSecurity(User u, String pass);

}
