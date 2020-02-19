package com.facebook.model;

public class Comment {
    private String postID;
    private String userName;
    private String commentContent;

    public Comment(String postID, String userName, String commentContent) {
        this.postID = postID;
        this.userName = userName;
        this.commentContent = commentContent;
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

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
