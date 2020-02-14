package com.facebook.model;

public class Friend {
    private User userFriend;
    private SuggestedFriend friendsOfFriend;
    private Post friendsPosts;

    public Friend(User userFriend, SuggestedFriend friendsOfFriend, Post friendsPosts) {
        this.userFriend = userFriend;
        this.friendsOfFriend = friendsOfFriend;
        this.friendsPosts = friendsPosts;
    }

    public User getUserFriend() {
        return userFriend;
    }

    public void setUserFriend(User userFriend) {
        this.userFriend = userFriend;
    }

    public SuggestedFriend getFriendsOfFriend() {
        return friendsOfFriend;
    }

    public void setFriendsOfFriend(SuggestedFriend friendsOfFriend) {
        this.friendsOfFriend = friendsOfFriend;
    }

    public Post getFriendsPosts() {
        return friendsPosts;
    }

    public void setFriendsPosts(Post friendsPosts) {
        this.friendsPosts = friendsPosts;
    }
}
