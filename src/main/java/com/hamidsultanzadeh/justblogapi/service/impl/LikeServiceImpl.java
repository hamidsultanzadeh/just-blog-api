package com.hamidsultanzadeh.justblogapi.service.impl;

import com.hamidsultanzadeh.justblogapi.dao.LikeDataInter;
import com.hamidsultanzadeh.justblogapi.dao.PostDataInter;
import com.hamidsultanzadeh.justblogapi.entity.AllLikes;
import com.hamidsultanzadeh.justblogapi.entity.Post;
import com.hamidsultanzadeh.justblogapi.entity.User;
import com.hamidsultanzadeh.justblogapi.service.inter.LikeServiceInter;
import com.hamidsultanzadeh.justblogapi.service.inter.SecurityServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeServiceInter {

    @Autowired
    PostDataInter postDataInter;

    @Autowired
    LikeDataInter likeDataInter;


    @Override
    public boolean save(Post post, AllLikes like) {
//        User user = securityServiceInter.getLoggedUser();
//
//        if(user == null) return false;
//
//        List<AllLikes> likes = post.getLikes();
//
//        if(likes == null){
//            likes = new ArrayList<>();
//        }
//
//        like.setDate(new java.sql.Date(new Date().getTime()));
//        like.setPostId(post);
//        like.setUserId(user);
//        likes.add(like);
//
//        post.setLikes(likes);
//        postDataInter.save(post);


        return true;
    }

    @Override
    public AllLikes findByPostIdAndUserId(Post post) {
//        User user = securityServiceInter.getLoggedUser();
//        return user == null ? null : likeDataInter.findByPostIdAndUserId(post,user);
        return null;
    }

    @Override
    public boolean delete(Post post, AllLikes like) {

//        User user = securityServiceInter.getLoggedUser();
//
//        if(user == null) return false;
//
//        List<AllLikes> likes = post.getLikes();
//
//        likes.remove(like);
//
//        post.setLikes(likes);
//        postDataInter.save(post);

        return true;
    }
}
