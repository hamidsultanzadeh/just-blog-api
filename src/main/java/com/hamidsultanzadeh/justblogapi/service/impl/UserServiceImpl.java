package com.hamidsultanzadeh.justblogapi.service.impl;

import com.hamidsultanzadeh.justblogapi.dao.RoleDataInter;
import com.hamidsultanzadeh.justblogapi.dao.UserDataInter;
import com.hamidsultanzadeh.justblogapi.entity.Role;
import com.hamidsultanzadeh.justblogapi.entity.User;
import com.hamidsultanzadeh.justblogapi.service.inter.SecurityServiceInter;
import com.hamidsultanzadeh.justblogapi.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    UserDataInter userDataInter;

    @Autowired
    RoleDataInter roleDataInter;


    @Override
    public List<User> findAll() {
        return userDataInter.findAll();
    }

    @Override
    public boolean save(User user) {

//        //facebook youtube
//        if(user.getYoutube().length() == 0) user.setYoutube(null);
//        if(user.getFacebook().length() == 0) user.setFacebook(null);
//
//        //role
//        Role role = roleDataInter.findById(1).get();
//        Set<Role> roles = new HashSet<>();
//        roles.add(role);
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(roles);
//        userDataInter.save(user);
        return true;
    }

    @Override
    public User findById(Integer id) {
        Optional user = userDataInter.findById(id);
        return user.isPresent() ? (User) user.get() : null;
    }

    @Override
    public User findByUsername(String u) {
        return userDataInter.findByUsername(u);
    }

    @Override
    public boolean editProfile(User u) {

//        User user = securityServiceInter.getLoggedUser();
//
//        if(user == null) return false;
//
//        user.setUsername(u.getUsername());
//        user.setNameSurname(u.getNameSurname());
//        user.setPhotoId(u.getPhotoId());
//        user.setFacebook(u.getFacebook().length() == 0 ? null : u.getFacebook());
//        user.setYoutube(u.getYoutube().length() == 0 ? null : u.getYoutube());
//        user.setId(u.getId());
//        user.setDescription(u.getDescription());
//
//        userDataInter.save(user);

        return true;
    }

    @Override
    public boolean editSecurity(User u, String newPass) {

//        User user = securityServiceInter.getLoggedUser();
//
//        if(user == null) return false;
//
//        user.setMail(u.getMail());
//        user.setPassword(passwordEncoder.encode(newPass));
//
//        userDataInter.save(user);

        return true;
    }
}
