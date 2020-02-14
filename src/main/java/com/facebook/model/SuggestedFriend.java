package com.facebook.model;

public class SuggestedFriend extends Friend {
        private User user;
        private Post suggestedFriendPosts;

    public SuggestedFriend(User userFriend, SuggestedFriend friendsOfFriend, Post friendsPosts, User user, Post suggestedFriendPosts) {
        super(userFriend, friendsOfFriend, friendsPosts);
        this.user = user;
        this.suggestedFriendPosts = suggestedFriendPosts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getSuggestedFriendPosts() {
        return suggestedFriendPosts;
    }

    public void setSuggestedFriendPosts(Post suggestedFriendPosts) {
        this.suggestedFriendPosts = suggestedFriendPosts;
    }
}
