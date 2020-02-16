package com.hamidsultanzadeh.justblogapi.service.inter;

import com.hamidsultanzadeh.justblogapi.entity.AllComments;
import com.hamidsultanzadeh.justblogapi.entity.Post;

import java.util.List;

public interface CommentServiceInter {

    boolean save(Post post, AllComments comment);

    List<AllComments> findAllByPostId(Post post, Integer page);

}
