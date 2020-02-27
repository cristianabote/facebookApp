package com.facebook.ui;

import com.facebook.exception.FbTechnicalException;
import com.facebook.model.Post;
import com.facebook.service.PostService;

import java.util.Scanner;

public class CommentsUi {

    PostService postService = new PostService();

    public void displayComments() throws FbTechnicalException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter post id: ");
        String postId = scanner.next();

         Post post = postService.readPostByPostId(postId);
    }

}
