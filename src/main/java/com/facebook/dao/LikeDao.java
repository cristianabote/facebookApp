package com.facebook.dao;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbFileException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Like;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LikeDao {
    private static final String LIKES_FILE = "C:/Users/User/IdeaProjects/facebookApp/src/main/java/com/facebook/likes.txt";

    public List<Like> readAllLikes() throws FbTechnicalException {
        List<Like> likeList = new ArrayList<>();
        try (
                BufferedReader likeReader = new BufferedReader(new FileReader(LIKES_FILE))){
            while ((likeReader.readLine()) != null) {
                String likeLine = likeReader.readLine();
                String[] likeValues = likeLine.split(";");

                likeList.add(new Like(likeValues[0], likeValues[1], likeValues[2]));
            }
        } catch (IOException e) {
            throw new FbFileException("Error reading users", e);
        }

        return likeList;
    }

    public List<Like> readLikeByPostId(String postId) throws FacebookException {
        List<Like> likeList = new ArrayList<>();
        try (
                BufferedReader likeReader = new BufferedReader(new FileReader(LIKES_FILE))) {
            while ((likeReader.readLine()) != null) {
                String likeLine = likeReader.readLine();
                String[] likeValues = likeLine.split(";");

                if (likeValues[1].equals(postId)) {

                    likeList.add(new Like(likeValues[0], likeValues[1], likeValues[2]));
                }
            }
        }
            catch (IOException e) {
            throw new FbFileException("Error reading users", e);
        }

        return likeList;
    }

    public void writeLike(Like newLike) throws IOException {
        System.out.println("New Like:" + newLike.getLikeId() + ";" + newLike.getPostId() + ";" + newLike.getUserName());
        Writer outputStream;

        outputStream = new BufferedWriter(new FileWriter(LIKES_FILE, true));
        outputStream.write(newLike.getLikeId() + ";" + newLike.getPostId() + ";" + newLike.getUserName());
        ((BufferedWriter) outputStream).newLine();
        outputStream.close();

    }
}
