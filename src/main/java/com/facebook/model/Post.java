package com.facebook.model;

public class Post {
    private String image;
    private String video;
    private String liveVideo;
    private String text;
    private String checkIn;

    public Post(String text) {
        this.text = text;
    }

    public Post(String image, String video, String liveVideo, String text, String checkIn) {
        this.image = image;
        this.video = video;
        this.liveVideo = liveVideo;
        this.text = text;
        this.checkIn = checkIn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getLiveVideo() {
        return liveVideo;
    }

    public void setLiveVideo(String liveVideo) {
        this.liveVideo = liveVideo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
}
