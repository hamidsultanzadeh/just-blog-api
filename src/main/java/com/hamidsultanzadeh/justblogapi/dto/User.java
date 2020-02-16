package com.hamidsultanzadeh.justblogapi.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private Integer id;
    private String nameSurname;
    private String description;
    private String mail;
    private String facebook;
    private String youtube;

    private String photoUrl;
    private Integer postCount;
    private List<com.hamidsultanzadeh.justblogapi.dto.Post> postList = new ArrayList<>();
    private Set<com.hamidsultanzadeh.justblogapi.dto.Role> roleList = new HashSet<>();

    public User() {
    }

    public User(com.hamidsultanzadeh.justblogapi.entity.User user){
        this.id = user.getId();
        this.nameSurname = user.getNameSurname();
        this.description = user.getDescription();
        this.mail = user.getMail();
        this.facebook = user.getFacebook();
        this.youtube = user.getYoutube();
        this.photoUrl = user.getPhotoId().getUrl();
        this.postCount = user.getPosts().size();
        if(user.getPosts().size() != 0){
            user.getPosts().forEach(post -> {
                this.postList.add(new Post(post));
            });
        }
        if(user.getRoles().size() != 0){
            user.getRoles().forEach(role -> {
                this.roleList.add(new Role(role));
            });
        }
    }

    public User(Integer id, String nameSurname, String description, String mail, String facebook, String youtube, String photoUrl, Integer postCount, List<com.hamidsultanzadeh.justblogapi.dto.Post> postList, Set<com.hamidsultanzadeh.justblogapi.dto.Role> roleList) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.description = description;
        this.mail = mail;
        this.facebook = facebook;
        this.youtube = youtube;
        this.photoUrl = photoUrl;
        this.postCount = postCount;
        this.postList = postList;
        this.roleList = roleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public List<com.hamidsultanzadeh.justblogapi.dto.Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Set<com.hamidsultanzadeh.justblogapi.dto.Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }
}
