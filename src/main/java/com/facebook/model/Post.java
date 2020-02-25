package com.facebook.model;

import java.util.ArrayList;
import java.util.List;



public class Post {
    public Post(String postID, String userName, String title, String description, List<Like> likes, List<Comment> comments) {
        this.postID = postID;
        this.userName = userName;
        this.title = title;
        this.description = description;
        this.likes = likes;
        this.comments = comments;
    }

    private String postID;
    private String userName;
    private String title;
    private String description;
    private List<Like> likes;
    private List<Comment> comments;


    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


}
