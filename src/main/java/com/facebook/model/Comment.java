package com.facebook.model;

public class Comment {
    private String commentId;
    private String postId;
    private String userName;
    private String commentContent;

    public Comment(String commentId, String postId, String userName, String commentContent) {
        this.commentId = commentId;
        this.postId = postId;
        this.userName = userName;
        this.commentContent = commentContent;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
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

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}