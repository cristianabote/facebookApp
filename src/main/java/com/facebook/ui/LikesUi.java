package com.facebook.ui;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Post;
import com.facebook.service.LikeService;
import com.facebook.service.PostService;

import java.io.IOException;
import java.util.Scanner;

import static com.facebook.ui.MyFacebook.showOption;

public class LikesUi {

    PostService postService = new PostService();
    LikeService likeService = new LikeService();

    public void displayLikes(String userName) throws FacebookException, IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter post id: ");
        String postId = scanner.next();

        Post post = postService.readPostByPostId(postId);

        Scanner newsFeedScanner = new Scanner(System.in);
        System.out.println("1. Add Like: ");
        System.out.println("2. Go Back: ");
        System.out.println("Enter your option: ");

        int option = newsFeedScanner.nextInt();
        switch (option){
            case 1:
                addLike(userName);
                break;
            case 2:
                showOption(userName);
                break;
        }
    }

    public void addLike(String userName) throws FacebookException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter post id: ");
        String postId = scanner.next();
        likeService.addLike(postId, userName);
        NewsFeedUi newsFeedUi = new NewsFeedUi();
        newsFeedUi.displayNewsFeed(userName);
    }


}
