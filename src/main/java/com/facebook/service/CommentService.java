package com.facebook.service;

import com.facebook.dao.CommentDao;
import com.facebook.exception.FacebookException;
import com.facebook.model.Comment;

public class CommentService {

    private CommentDao commentDao = new CommentDao();

    public Comment readComments(String postId, String commentId, String userName, String commentContent) throws FacebookException {

        for (Comment comment : commentDao.readAllComments()){
        }
        return null;
    }

}
