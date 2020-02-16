package com.hamidsultanzadeh.justblogapi.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
@Table(name = "status")
@Entity
public class Status implements Serializable {

    private static final long serialVersionLong = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Basic(optional = false)
    private Integer id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "statusId", fetch = FetchType.LAZY)
    private List<Post> posts;

    public Status() {
    }

    public Status(String name,List<Post> posts) {
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
