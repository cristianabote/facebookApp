package com.facebook.service;
import com.facebook.dao.CommentDao;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Comment;
import java.io.IOException;


public class CommentService {

    private CommentDao commentDao = new CommentDao();

    public static void main(String[] args) throws IOException, FbTechnicalException {
        CommentService testComment=new CommentService();
        testComment.writeComment("1","p1", "Cris", "nice");
        System.out.println(testComment.viewAllComments("p1","Cris"));
    }

    public int viewAllComments(String postId, String userName) throws FbTechnicalException {
        int counter=0;
        for (Comment comment : commentDao.readAllComments()) {
            if (postId.equals(comment.getPostId())) {
                counter++;
            }
        }
        return counter;
    }
    public void writeComment(String commentId, String postId, String userName, String commentContent) throws IOException, FbTechnicalException {
        Comment comment = new Comment(commentId, postId, userName, commentContent);
        commentDao.writeComment(comment);
    }
}
//postId.equals(comment.getPostId())&& userName.equals(comment.getUserName())&& commentContent.equals(comment.getCommentContent()))