package com.facebook.model;

public class Like {
    private String postID;
    private String userName;

    public Like(String postID, String userName) {
        this.postID = postID;
        this.userName = userName;
    }

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


}
