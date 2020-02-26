package com.facebook.dao;
import com.facebook.exception.FbFileException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Comment;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    private static final String COMMENTS_FILE = "./src/main/java/com/facebook/comments.txt";
    public List<Comment> readAllComments() throws FbTechnicalException {
        List<Comment> commentList = new ArrayList<>();
        try (
                BufferedReader commentReader = new BufferedReader(new FileReader(COMMENTS_FILE))){
            String commentLine = commentReader.readLine();
            while (commentLine != null) {

                String[] commentValues = commentLine.split(";");

                commentList.add(new Comment(Integer.parseInt(commentValues[0]), commentValues[1], commentValues[2], commentValues[3]));
                commentLine = commentReader.readLine();
            }
        } catch (IOException e) {
            throw new FbFileException("Error reading comments", e);
        }

        return commentList;
    }

    public void writeComment(Comment newComment) throws FbTechnicalException, IOException {
        System.out.println("Add new comment:" + newComment.getCommentId() + ";" + newComment.getPostId() + ";" + newComment.getUserName()+";"+newComment.getCommentContent());
        Writer outputStream;

        outputStream = new BufferedWriter(new FileWriter(COMMENTS_FILE, true));
        outputStream.write(newComment.getCommentId() + ";" + newComment.getPostId() + ";" + newComment.getUserName()+";"+newComment.getCommentContent());
        ((BufferedWriter) outputStream).newLine();
        outputStream.close();

    }
}
