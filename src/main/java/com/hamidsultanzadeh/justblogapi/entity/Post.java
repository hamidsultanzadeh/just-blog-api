package com.hamidsultanzadeh.justblogapi.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "post")
@XmlRootElement
@Entity
public class Post implements Serializable {

    private static final Long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Basic(optional = false)
    private Integer id;
    @Size(min = 10, max = 30,message = "Use minimum 10 and maximum 30 symbols")
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Size(min = 10, max = 1000,message = "Use minimum 10 and maximum 1000 symbols")
    @Basic(optional = false)
    @Column(name = "content")
    private String content;
    @Column(name = "insert_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTime;
    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User userId;
    @OneToMany(mappedBy = "postId",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AllComments> comments;
    @OneToMany(mappedBy = "postId",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AllLikes> likes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "post_category",
    joinColumns = @JoinColumn(name = "post_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "status_id",nullable = false)
    private Status statusId;

    public Post() {
    }
    public Post(String title, String content, Date insertTime, User userId, List<Category> categories, List<AllComments> comments, List<AllLikes> likes,Status statusId) {
        this.title = title;
        this.content = content;
        this.insertTime = insertTime;
        this.userId = userId;
        this.categories = categories;
        this.comments = comments;
        this.likes = likes;
        this.statusId = statusId;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<AllComments> getComments() {
        return comments;
    }

    public void setComments(List<AllComments> comments) {
        this.comments = comments;
    }

    public List<AllLikes> getLikes() {
        return likes;
    }

    public void setLikes(List<AllLikes> likes) {
        this.likes = likes;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
