package com.facebook.model;

import java.util.List;

public class FacebookAccount {
    private User user;
    private List<Friend> friendsList;
    private List<Post> myPosts;
    private Post myStory;
    private ProfileInfo generalInformation;
    private List<Messenger> conversation;

    public FacebookAccount(User user, List<Friend> friendsList, List<Post> myPosts, Post myStory, ProfileInfo generalInformation, List<Messenger> conversation) {
        this.user = user;
        this.friendsList = friendsList;
        this.myPosts = myPosts;
        this.myStory = myStory;
        this.generalInformation = generalInformation;
        this.conversation = conversation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Friend> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<Friend> friendsList) {
        this.friendsList = friendsList;
    }

    public List<Post> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(List<Post> myPosts) {
        this.myPosts = myPosts;
    }

    public Post getMyStory() {
        return myStory;
    }

    public void setMyStory(Post myStory) {
        this.myStory = myStory;
    }

    public ProfileInfo getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(ProfileInfo generalInformation) {
        this.generalInformation = generalInformation;
    }

    public List<Messenger> getConversation() {
        return conversation;
    }

    public void setConversation(List<Messenger> conversation) {
        this.conversation = conversation;
    }
}




