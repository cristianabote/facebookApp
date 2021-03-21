package com.facebook.service;

import com.facebook.dao.LikeDao;
import com.facebook.model.Like;
import com.facebook.exception.FbTechnicalException;
import java.io.IOException;

public class LikeService {

    private LikeDao likeDao = new LikeDao();


    public void viewNrOfLikes(String postId) throws FbTechnicalException {
        int counter=0;
        for (Like like : likeDao.readAllLikes()) {
            if (postId.equals(like.getPostId()) ) {
                counter++;
            }
        }
        System.out.println(counter);
    }
    public void viewLikesUserList(String postId) throws FbTechnicalException {
        //ArrayList<String> userLikeList=new ArrayList<>();
        for (Like like : likeDao.readAllLikes()) {
            if (postId.equals(like.getPostId())) {
                //userLikeList.add(like.getUserName());
                 System.out.println(like.toString());
            }
        }
    }
    public void addLike(String postId, String userName) throws IOException, FbTechnicalException {

        String maxLikeId = likeDao.readAllLikes().get(likeDao.readAllLikes().size()-1).getLikeId();
        if (maxLikeId != null) {
            int likeId = (Integer.parseInt(maxLikeId)) + 1;
            Like like = new Like(likeId + "", postId, userName);
            likeDao.writeLike(like);
        }
    }
}
