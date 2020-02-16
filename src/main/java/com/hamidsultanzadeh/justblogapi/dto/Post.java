package com.hamidsultanzadeh.justblogapi.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    private Integer id;
    private String title;
    private String content;
    private Date insertTime;
    private Date lastUpdateTime;

    private Integer likeCount;
    private Integer commentCount;

    private Integer categoryCount;
    private List<Category> categoryList = new ArrayList<>();

    public Post() {
    }

    public Post(com.hamidsultanzadeh.justblogapi.entity.Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.insertTime = post.getInsertTime();
        this.lastUpdateTime = post.getLastUpdateTime();
        this.likeCount = post.getLikes().size();
        this.commentCount = post.getComments().size();
        this.categoryCount = post.getCategories().size();
        if(post.getCategories().size() != 0){
            post.getCategories().forEach(category -> {
                this.categoryList.add(new Category(category));
            });
        }

    }

    public Post(Integer id, String title, String content, Date insertTime, Date lastUpdateTime, Integer likeCount, Integer commentCount, Integer categoryCount, List<Category> categoryList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.insertTime = insertTime;
        this.lastUpdateTime = lastUpdateTime;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.categoryCount = categoryCount;
        this.categoryList = categoryList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getCategoryCount() {
        return categoryCount;
    }

    public void setCategoryCount(Integer categoryCount) {
        this.categoryCount = categoryCount;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
