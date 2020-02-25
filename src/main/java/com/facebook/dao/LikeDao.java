package com.facebook.dao;
import com.facebook.exception.FbFileException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Like;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LikeDao {
    private static final String LIKES_FILE = "./src/main/java/com/facebook/likes.txt";

    public List<Like> readAllLike() throws FbTechnicalException {
        List<Like> likeList = new ArrayList<>();
        try (
                BufferedReader likeReader = new BufferedReader(new FileReader(LIKES_FILE))) {
            String likeLine = likeReader.readLine();
            while (likeLine != null) {
                String[] likeValues = likeLine.split(";");

                likeList.add(new Like(likeValues[0], likeValues[1], likeValues[2]));
                likeLine = likeReader.readLine();
            }
        } catch (IOException e) {
            throw new FbFileException("Error reading likes", e);
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
