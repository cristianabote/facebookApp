package com.facebook.ui;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.model.Post;
import com.facebook.service.CommentService;
import com.facebook.service.LikeService;
import com.facebook.service.PostService;
import com.facebook.service.UserService;
import javafx.geometry.Pos;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static com.facebook.ui.MyFacebook.showOption;

public class NewsFeedUi {
    private UserService userService = new UserService();
    private PostService postService = new PostService();
    private CommentsUi commentsUi = new CommentsUi();
    private LikesUi likesUi = new LikesUi();


    public void displayNewsFeed() throws FacebookException {
        try {
            List<Post> postList = postService.readAllPosts();
            for(Post post : postList){
                System.out.println("Post Id: " + post.getPostID());
                System.out.println("Username: " + post.getUserName());
                System.out.println("Title: " + post.getTitle());
                System.out.println("Description: " + post.getDescription());
                System.out.println("Comments: " + post.getComments().size());
                System.out.println("Likes: " + post.getLikes().size());
                System.out.println("--------------------------------------");
            }

            Scanner newsFeedScanner = new Scanner(System.in);
            System.out.println("1. View all Comments: ");
            System.out.println("2. View all Likes: ");
            System.out.println("3. Add Comments: ");
            System.out.println("4. Add Like: ");
            System.out.println("5. View My Posts: ");
            System.out.println("6. Delete Post: ");
            System.out.println("7. Create Post: ");

            int option = newsFeedScanner.nextInt();

            switch (option){
                case 1:
                   commentsUi.displayComments();
                   break;
                case 2:
                    likesUi.displayLikes();

            }


        } catch (FbTechnicalException e) {
            e.printStackTrace();
            System.out.println("A system error appeared. Please contact your administrator");
        }

    }

}
