package com.facebook.service;
import com.facebook.dao.CommentDao;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Comment;
import java.io.IOException;
import java.util.ArrayList;


public class CommentService {

    private CommentDao commentDao = new CommentDao();

/*    public static void main(String[] args) throws IOException, FbTechnicalException {
        CommentService testComment=new CommentService();
        testComment.addComment("p1", "Alexandru", "great");
        testComment.viewNrOfComments("p2");
        testComment.viewCommentList();
        testComment.deleteComment(3);
    }*/
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
        int maxCommentId=0;
        for (Comment comment : commentDao.readAllComments()){
            maxCommentId=comment.getCommentId();
        }
        Comment comment = new Comment(maxCommentId+1, postId, userName, commentContent);
        commentDao.writeComment(comment);
    }
    public void deleteComment(int commentId) throws FbTechnicalException, IOException {
        ArrayList<Comment> commentsList= new ArrayList<>();
        for (Comment comment : commentDao.readAllComments()) {
            if (commentId!=comment.getCommentId()) {
                commentsList.add(comment);
            }
        }
        commentDao.overWriteAllComments(commentsList);
    }
}
