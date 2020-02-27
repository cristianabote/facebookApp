package com.facebook.service;

import com.facebook.dao.CommentDao;
import com.facebook.dao.LikeDao;
import com.facebook.dao.PostDao;
import com.facebook.dao.UserDao;
import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.model.Comment;
import com.facebook.model.Like;
import com.facebook.model.Post;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class PostService {

private CommentDao commentDao = new CommentDao();
private LikeDao likeDao = new LikeDao();
private UserDao userDao = new UserDao();
private PostDao postDao = new PostDao();

public List<Post> readAllPosts() throws FbTechnicalException {
    return postDao.readAllPosts();
}

public Post readPostByPostId(String postId) throws FbTechnicalException {
    return postDao.readPostById(postId);
}


public List<Post> readPostsByUsername(String userName) throws FacebookException {
    List<Post> postList = new ArrayList<Post>();
    for (Post post: postDao.readAllPosts()){
        if(userName.equals(post.getUserName())){
            postList.add(post);
        }
        return postList;
    }
    throw new FbWrongCredentialsException();
}

public void addPost(){}

public  void deletePost(){}


}
