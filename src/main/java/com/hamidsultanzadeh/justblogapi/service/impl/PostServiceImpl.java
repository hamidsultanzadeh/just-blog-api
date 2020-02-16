package com.hamidsultanzadeh.justblogapi.service.impl;

import com.hamidsultanzadeh.justblogapi.config.AllConfig;
import com.hamidsultanzadeh.justblogapi.dao.PostDataInter;
import com.hamidsultanzadeh.justblogapi.entity.Post;
import com.hamidsultanzadeh.justblogapi.entity.Status;
import com.hamidsultanzadeh.justblogapi.entity.User;
import com.hamidsultanzadeh.justblogapi.service.inter.PostServiceInter;
import com.hamidsultanzadeh.justblogapi.service.inter.SecurityServiceInter;
import com.hamidsultanzadeh.justblogapi.service.inter.StatusServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostServiceInter {

    @Autowired
    PostDataInter postDataInter;

    @Autowired
    StatusServiceInter statusServiceInter;


    @Override
    public Page<Post> findAll(Integer page) {
        Pageable resPage = PageRequest.of(page-1,5);
        return postDataInter.findAllByStatusIdOrderByInsertTimeDesc(statusServiceInter.findById(1),resPage);
    }

    @Override
    public List<Post> findAllByUserIdAndStatusId(User userId) {
        return postDataInter.findAllByUserIdAndStatusId(userId,statusServiceInter.findById(1));
    }

    @Override
    public Post findById(Integer id) {
        Optional post = postDataInter.findById(id);
        return post.isPresent() ? (Post) post.get() : null;
    }

    @Override
    @CacheEvict(value={ "categoriesNavbar", "categoriesWrite" }, allEntries=true)
    public boolean save(Post post,String typeSubmit) {

//        User user = securityServiceInter.getLoggedUser();
//
//        if(user == null) return false;
//
//        Status statusId;
//
//        if(typeSubmit.equals("archive")) statusId = statusServiceInter.findById(2); //archived
//        else statusId = statusServiceInter.findById(1); //publish
//
//        post.setInsertTime(new java.sql.Date(new Date().getTime()));
//
//        String text = AllConfig.replaceAllText(post.getContent());
//
//        post.setUserId(user);
//        post.setStatusId(statusId); //published
//        post.setContent(text);
//        postDataInter.save(post);
        return true;
    }

    @Override
    public boolean changeStatus(Post post,Status statusId) {
        post.setStatusId(statusId);
        post.setLastUpdateTime(new java.sql.Date(new Date().getTime()));
        postDataInter.save(post);
        return true;
    }

    @Override
    @CacheEvict(value={ "categoriesNavbar", "categoriesWrite" }, allEntries=true)
    public boolean update(Post update, Post post) {
        update.setTitle(post.getTitle());
        update.setLastUpdateTime(new java.sql.Date(new Date().getTime()));

        String text = AllConfig.replaceAllText(post.getContent());

        update.setContent(text);
        update.setCategories(post.getCategories());
        postDataInter.save(update);
        return true;
    }

    @Override
    @CacheEvict(value={ "categoriesNavbar", "categoriesWrite" }, allEntries=true)
    public boolean remove(Post post) {
        post.setCategories(new ArrayList<>());
        postDataInter.save(post);
        postDataInter.delete(post);
        return true;
    }

}