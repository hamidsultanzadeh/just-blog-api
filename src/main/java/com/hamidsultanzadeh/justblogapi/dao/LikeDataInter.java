package com.hamidsultanzadeh.justblogapi.dao;

import com.hamidsultanzadeh.justblogapi.entity.AllLikes;
import com.hamidsultanzadeh.justblogapi.entity.Post;
import com.hamidsultanzadeh.justblogapi.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface LikeDataInter extends CrudRepository<AllLikes, Integer> {

    AllLikes findByPostIdAndUserId(Post post, User user);
}
