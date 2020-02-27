package com.facebook.service;

import com.facebook.dao.CommentDao;
import com.facebook.exception.FacebookException;
import com.facebook.model.Comment;
import com.facebook.exception.FbTechnicalException;
import java.io.IOException;
import java.util.ArrayList;


public class CommentService {

    private CommentDao commentDao = new CommentDao();

    public Comment readComments(String postId, String commentId, String userName, String commentContent) throws FacebookException {

        for (Comment comment : commentDao.readAllComments()){
        }
        return null;
    }

    public void viewNrOfComments(String postId) throws FbTechnicalException {
        int counter=0;
        for (Comment comment : commentDao.readAllComments()) {
            if (postId.equals(comment.getPostId())) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    public void viewCommentList() throws FbTechnicalException {
        //ArrayList<Comment> commentList = new ArrayList<>();
        for (Comment comment : commentDao.readAllComments()) {
            //commentList.add(comment);
            System.out.println(comment.toString());
        }
    }

    public void addComment(String postId, String userName, String commentContent) throws IOException, FbTechnicalException {
        String maxCommentId = commentDao.readAllComments().get(commentDao.readAllComments().size()-1).getCommentId();
        int commentId = (Integer.parseInt(maxCommentId)) + 1;
        Comment comment = new Comment(commentId + "", postId, userName, commentContent);
        commentDao.writeComment(comment);
    }
    public void deleteComment(String commentId) throws FbTechnicalException, IOException {
        ArrayList<Comment> commentsList= new ArrayList<>();
        for (Comment comment : commentDao.readAllComments()) {
            if (commentId!=comment.getCommentId()) {
                commentsList.add(comment);
            }
        }
        commentDao.overWriteAllComments(commentsList);
    }
}
