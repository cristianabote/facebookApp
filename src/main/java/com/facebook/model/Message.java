package com.facebook.model;

public class Message {
    private User messageWriter;
    private Post comment;

    public Message(User messageWriter, Post comment) {
        this.messageWriter = messageWriter;
        this.comment = comment;
    }

    public User getMessageWriter() {
        return messageWriter;
    }

    public void setMessageWriter(User messageWriter) {
        this.messageWriter = messageWriter;
    }

    public Post getComment() {
        return comment;
    }

    public void setComment(Post comment) {
        this.comment = comment;
    }
}
