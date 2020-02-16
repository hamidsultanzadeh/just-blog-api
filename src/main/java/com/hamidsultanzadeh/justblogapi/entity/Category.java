package com.hamidsultanzadeh.justblogapi.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Table(name = "category")
@XmlRootElement
@Entity
public class Category implements Serializable {

    private static final long serialVersionLong = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;

    public Category() {
    }

    public Category(Integer id,String name){
        this.id = id;
        this.name = name;
    }

    public Category(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
