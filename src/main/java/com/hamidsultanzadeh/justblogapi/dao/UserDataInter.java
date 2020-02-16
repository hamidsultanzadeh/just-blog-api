package com.hamidsultanzadeh.justblogapi.dao;

import com.hamidsultanzadeh.justblogapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserDataInter extends JpaRepository<User, Integer> {

    User findByMail(String m);

    User findByUsername(String u);

}
