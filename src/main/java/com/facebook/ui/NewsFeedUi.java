package com.facebook.ui;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Post;
import com.facebook.service.CommentService;
import com.facebook.service.PostService;
import com.facebook.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static com.facebook.ui.MyFacebook.showOption;

public class NewsFeedUi {
    private UserService userService = new UserService();
    private PostService postService = new PostService();
    private CommentsUi commentsUi = new CommentsUi();
    private CommentService commentService = new CommentService();
    private LikesUi likesUi = new LikesUi();
    private PostUi postUi = new PostUi();


    public void displayNewsFeed(String userName) throws FacebookException {
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
            System.out.println("1. View all Comments from post id: ");
            System.out.println("2. View all Likes from post id: ");
            System.out.println("3. Add Comments: ");
            System.out.println("4. Add Like: ");
            System.out.println("5. View My Posts: ");
            System.out.println("6. Delete Post: ");
            System.out.println("7. Create Post: ");
            System.out.println("8. Go Back:");
            System.out.println("Enter your option: ");

            int option = newsFeedScanner.nextInt();
            switch (option){
                case 1:
                   commentsUi.displayComments(userName);
                   break;
                case 2:
                    likesUi.displayLikes(userName);
                    break;
                case 3:
                    commentsUi.addComment(userName);
                    break;
                case 4:
                    likesUi.addLike(userName);
                    break;
                case 5:
                    postService.readPostsByUsername(userName);
                case 6:
                    postUi.deletePost(userName);

                    break;
                case 7:
                    postUi.addPost(userName);
                    break;
                case 8:
                    showOption(userName);


            }


        } catch (FbTechnicalException | IOException e) {
            e.printStackTrace();
            System.out.println("A system error appeared. Please contact your administrator");
        }

    }

}
