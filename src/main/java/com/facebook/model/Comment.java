package com.facebook.model;

public class Comment {
    private String postId;
    private String commentId;
    private String userName;
    private String commentContent;

    public Comment(String postId, String commentId, String userName, String commentContent) {
        this.postId = postId;
        this.commentId = commentId;
        this.userName = userName;
        this.commentContent = commentContent;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getPostID() {
        return postId;
    }

    public void setPostID(String postId) {
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
