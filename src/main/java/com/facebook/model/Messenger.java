package com.facebook.model;

import java.util.List;

public class Messenger {
    private User recipient;
    private List<Message> messageArchive;

    public Messenger(User recipient, List<Message> messageArchive) {
        this.recipient = recipient;
        this.messageArchive = messageArchive;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public List<Message> getMessageArchive() {
        return messageArchive;
    }

    public void setMessageArchive(List<Message> messageArchive) {
        this.messageArchive = messageArchive;
    }
}
