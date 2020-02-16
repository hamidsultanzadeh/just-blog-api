package com.hamidsultanzadeh.justblogapi.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "all_comments")
@XmlRootElement
public class AllComments implements Serializable {

    private static final long serialVersionLong = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "content")
    private String content;
    @Column(name = "insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    //relationship
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private Post postId;

    public AllComments() {
    }

    public AllComments(String content, Date date, User userId, Post postId) {
        this.content = content;
        this.date = date;
        this.userId = userId;
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }
}
