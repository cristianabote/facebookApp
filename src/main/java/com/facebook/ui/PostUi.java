package com.facebook.ui;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.service.PostService;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class PostUi {

    PostService postService = new PostService();

    public void addPost(String userName) throws FacebookException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Title: ");
        String title = scanner.next();
        System.out.println("Enter Description: ");
        String description = scanner.next();
        postService.addPost(userName, title, description);
        System.out.println("Post was succesfully added! ");
        NewsFeedUi newsFeedUi = new NewsFeedUi();
        newsFeedUi.displayNewsFeed(userName);
    }

    public void deletePost(String userName) throws IOException, FacebookException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Post id: ");
        String postId = scanner.next();
        postService.deletePost(postId);
        System.out.println("Post " + postId + " was succesfully deleted! ");
        NewsFeedUi newsFeedUi = new NewsFeedUi();
        newsFeedUi.displayNewsFeed(userName);
    }

}
