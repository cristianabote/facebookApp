package com.facebook.service;

import com.facebook.dao.LikeDao;
import com.facebook.exception.FacebookException;
import com.facebook.model.Like;

public class LikeService {

    private LikeDao likeDao = new LikeDao();

    public Like readLikes(String likeId, String postId, String userName) throws FacebookException {

        for (Like like : likeDao.readAllLikes()){
        }
        return null;
    }

}
