package com.facebook.model;

public class Comment{
    private int commentId;
    private int postId;
    private String userName;
    private String commentContent;

    public Comment(int commentId, int postId, String userName, String commentContent) {
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

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
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