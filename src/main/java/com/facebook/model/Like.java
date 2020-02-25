package com.facebook.model;

public class Like {
    private String likeId;
    private String postId;
    private String userName;

    public Like(String likeId, String postId, String userName) {
        this.likeId = likeId;
        this.postId = postId;
        this.userName = userName;
    }

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
