package com.hamidsultanzadeh.justblogapi.service.impl;

import com.hamidsultanzadeh.justblogapi.config.AllConfig;
import com.hamidsultanzadeh.justblogapi.dao.CommentDataInter;
import com.hamidsultanzadeh.justblogapi.dao.PostDataInter;
import com.hamidsultanzadeh.justblogapi.entity.AllComments;
import com.hamidsultanzadeh.justblogapi.entity.Post;
import com.hamidsultanzadeh.justblogapi.entity.User;
import com.hamidsultanzadeh.justblogapi.service.inter.CommentServiceInter;
import com.hamidsultanzadeh.justblogapi.service.inter.SecurityServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentServiceInter {

    @Autowired
    PostDataInter postDataInter;

    @Autowired
    CommentDataInter commentDataInter;

    @Override
    public boolean save(Post post, AllComments comment) {

//        User user = securityServiceInter.getLoggedUser();
//
//        if(user != null){
//            List<AllComments> commentsList = post.getComments();
//
//            if(commentsList == null){
//                commentsList = new ArrayList<>();
//            }
//
//            String content = AllConfig.replaceAllText(comment.getContent());
//
//            comment.setContent(content);
//            comment.setUserId(user);
//            comment.setPostId(post);
//            comment.setDate(new java.sql.Date(new Date().getTime()));
//            commentsList.add(comment);
//
//            post.setComments(commentsList);
//            postDataInter.save(post);
//            return true;
//        }
        return false;
    }

    @Override
    public List<AllComments> findAllByPostId(Post post, Integer page) {
        Pageable resPage = PageRequest.of(page-1,5, Sort.Direction.DESC,"date");
        return commentDataInter.findAllByPostId(post,resPage);
    }


}
