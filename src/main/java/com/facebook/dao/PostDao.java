package com.facebook.dao;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbFileException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Comment;
import com.facebook.model.Like;
import com.facebook.model.Post;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    LikeDao likeDao = new LikeDao();
    CommentDao commentDao = new CommentDao();

    private static final String POST_PATH = "./src/main/java/com/facebook/posts.txt";

    public List<Post> readAllPosts() throws FbTechnicalException {
        List<Post> postsList = new ArrayList<>();

        try (
                BufferedReader postReader = new BufferedReader(new FileReader(POST_PATH))){
            String postLine = null;
            while ((postLine = postReader.readLine()) != null) {
                String[] postValues = postLine.split(";");
                List<Comment> commentList = commentDao.readCommentsByPostId(postValues[0]);
                List<Like> likeList = likeDao.readLikeByPostId(postValues[0]);
                postsList.add(new Post(postValues[0], postValues[1], postValues[2], postValues[3], likeList, commentList));
            }
        } catch (IOException | FacebookException e) {
            throw new FbFileException("Error reading comments", e);
        }

        return postsList;
    }

    public Post readPostById(String postId) throws FbTechnicalException {

        Post post=null;

        try (
                BufferedReader postReader = new BufferedReader(new FileReader(POST_PATH))) {
            String postLine = null;
            while ((postLine = postReader.readLine()) != null) {
                String[] postValues = postLine.split(";");
                if (postValues[0].equals(postId)) {
                    List<Comment> commentList = commentDao.readCommentsByPostId(postValues[0]);
                    List<Like> likeList = likeDao.readLikeByPostId(postValues[0]);
                    post = new Post(postValues[0], postValues[1], postValues[2], postValues[3], likeList, commentList);
                }

            }
        } catch (IOException | FacebookException e) {
            throw new FbFileException("Error reading comments", e);
        }
        return post;
    }

    public void addPost(Post post) throws IOException {
        System.out.println("Add new comment:" + post.getPostID() + ";" + post.getTitle() + ";" + post.getDescription());
        Writer outputStream;

        outputStream = new BufferedWriter(new FileWriter(POST_PATH, true));
        outputStream.write(post.getPostID() + ";" + post.getUserName() + ";" + post.getTitle()+";"+post.getDescription());
        ((BufferedWriter) outputStream).newLine();
        outputStream.close();
    }

    public void overWriteAllPosts (List<Post> newPostList) throws FbTechnicalException, IOException {
        System.out.println("OverWrite list of posts." );
        Writer outputStream;
        outputStream = new BufferedWriter(new FileWriter(POST_PATH));
        for(Post post: newPostList) {
            outputStream.write(post.getPostID() + ";" + post.getUserName() + ";" + post.getTitle() + ";" + post.getDescription());
            ((BufferedWriter) outputStream).newLine();
        }
        outputStream.close();

    }

}
