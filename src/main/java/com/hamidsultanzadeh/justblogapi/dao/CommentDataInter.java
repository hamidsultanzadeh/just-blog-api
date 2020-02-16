package com.hamidsultanzadeh.justblogapi.dao;

import com.hamidsultanzadeh.justblogapi.entity.AllComments;
import com.hamidsultanzadeh.justblogapi.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentDataInter extends CrudRepository<AllComments, Integer> {

    List<AllComments> findAllByPostId(Post post, Pageable pageable);
}
