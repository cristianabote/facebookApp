package com.facebook.service;

import com.facebook.dao.LikeDao;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Like;
import java.io.IOException;
import java.util.ArrayList;


public class LikeService {

 /*   public static void main(String[] args) throws FbTechnicalException, IOException {
        LikeService testLike=new LikeService();
        testLike.addLike("p3","Crisju");
        System.out.println(testLike.viewNrOfLikes("p3"));
        for (String likeUserName : testLike.viewLikesUserList("p3")) {
           System.out.println(likeUserName);

        }
    }*/

    private LikeDao likeDao = new LikeDao();

    public int viewNrOfLikes(String postId) throws FbTechnicalException {
        int counter=0;
        for (Like like : likeDao.readAllLike()) {
            if (postId.equals(like.getPostId()) ) {
                counter++;
            }
        }
        return counter;
    }
    public ArrayList<String> viewLikesUserList(String postId) throws FbTechnicalException {
        ArrayList<String> userLikeList=new ArrayList<>();
        for (Like like : likeDao.readAllLike()) {
            if (postId.equals(like.getPostId())) {
                userLikeList.add(like.getUserName());
            }
        }
        return userLikeList;
    }
    public void addLike(String postId, String userName) throws IOException, FbTechnicalException {
        int maxIdLike=0;
        for (Like like : likeDao.readAllLike()){
          maxIdLike++;
        }
        Like like = new Like(maxIdLike+1,postId, userName);
        likeDao.writeLike(like);
    }
}
