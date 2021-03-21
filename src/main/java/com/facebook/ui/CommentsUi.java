package com.facebook.ui;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Comment;
import com.facebook.model.Post;
import com.facebook.service.CommentService;
import com.facebook.service.PostService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static com.facebook.ui.MyFacebook.showOption;

public class CommentsUi {

    PostService postService = new PostService();
    CommentService commentService = new CommentService();

    public void displayComments(String userName) throws FacebookException, IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter post id: ");
        String postId = scanner.next();

         Post post = postService.readPostByPostId(postId);
         List<Comment> commentList = post.getComments();
         System.out.println("Post id: " + post.getPostID());
        System.out.println("Username: " + post.getUserName());
        System.out.println("Title: " + post.getTitle());
        System.out.println("Description: " + post.getDescription());
        System.out.println("Comments: ");
        System.out.println();

        for (Comment comments: commentList){
            System.out.println("Username: " + comments.getUserName());
            System.out.println("Comment id: " + comments.getCommentId());
            System.out.println("Content: " + comments.getCommentContent());
            System.out.println();
        }


        Scanner newsFeedScanner = new Scanner(System.in);
        System.out.println("1. Delete Comment: ");
        System.out.println("2. Add Comment: ");
        System.out.println("3. Go Back:");
        System.out.println("Enter your option: ");

        int option = newsFeedScanner.nextInt();
        switch (option){
            case 1:
                deleteComment(userName);
                NewsFeedUi newsFeedUi = new NewsFeedUi();
                newsFeedUi.displayNewsFeed(userName);
                break;
            case 2:
                addComment(userName);
                break;
            case 3:
                showOption(userName);
        }



    }

    public void addComment(String userName) throws FacebookException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Post Id: ");
        String postId = scanner.next();
        System.out.println("Enter Comment Content: ");
        String commentContent = scanner.next();
        commentService.addComment(postId, userName, commentContent);
        System.out.println("Comment was succesfully added! ");
        NewsFeedUi newsFeedUi = new NewsFeedUi();
        newsFeedUi.displayNewsFeed(userName);
    }

    public void deleteComment(String userName) throws IOException, FacebookException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter comment id : ");
        String commentId = scanner.next();
        commentService.deleteComment(commentId);

    }

}
