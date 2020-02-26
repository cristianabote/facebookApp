package com.facebook.model;

public class Comment{
    private int commentId;
    private String postId;
    private String userName;
    private String commentContent;

    public Comment(int commentId, String postId, String userName, String commentContent) {
        this.commentId = commentId;
        this.postId = postId;
        this.userName = userName;
        this.commentContent = commentContent;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
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
    public String toString(){
        return "ID:"+this.getCommentId()+" POSTID:"+this.getPostId()+" User:"+this.getUserName()+" Comment:"+this.getCommentContent();
    }
}