package com.facebook.dao;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbFileException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Comment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    private static final String COMMENTS_FILE = "C:/Users/User/IdeaProjects/facebookApp/src/main/java/com/facebook/comments.txt";

    public List<Comment> readAllComments() throws FbTechnicalException {
        List<Comment> commentList = new ArrayList<>();

        try (
                BufferedReader commentReader = new BufferedReader(new FileReader(COMMENTS_FILE))){
            while ((commentReader.readLine()) != null) {
                String commentLine = commentReader.readLine();
                String[] commentValues = commentLine.split(";");

                commentList.add(new Comment(commentValues[0], commentValues[1], commentValues[2], commentValues[3]));
            }
        } catch (IOException e) {
            throw new FbFileException("Error reading comments", e);
        }

        return commentList;
    }

    public List<Comment> readCommentsByPostId(String postId) throws FacebookException{
        List<Comment> commentList = new ArrayList<>();
        try (
                BufferedReader commentReader = new BufferedReader(new FileReader(COMMENTS_FILE))) {
            while ((commentReader.readLine()) != null) {
                String commentLine = commentReader.readLine();
                String[] commentValues = commentLine.split(";");

                if (commentValues[0].equals(postId)) {

                    commentList.add(new Comment(commentValues[0], commentValues[1], commentValues[2], commentValues[3]));
                }
            }
        }
        catch (IOException e) {
            throw new FbFileException("Error reading users", e);
        }

        return commentList;

    }

}
