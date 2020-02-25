package com.facebook.service;

import com.facebook.dao.LikeDao;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Like;

import java.io.IOException;


public class LikeService {
    private LikeDao likeDao = new LikeDao();

    public int viewAllLikes(String likeId, String postId, String userName) throws FbTechnicalException {
        int counter=0;
        for (Like like : likeDao.readAllLike()) {
            if (postId.equals(like.getPostId())) {
                counter++;
            }
        }
        return counter;
    }
    public void addLike(String likeId, String postId, String userName) throws IOException {
        Like like = new Like(likeId, postId, userName);
        likeDao.writeLike(like);
    }
}
