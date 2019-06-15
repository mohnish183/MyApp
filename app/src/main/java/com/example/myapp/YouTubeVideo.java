package com.example.myapp;

public class YouTubeVideo {
    String VideoUrl;
    public YouTubeVideo(){

    }
    public YouTubeVideo(String videoUrl){this.VideoUrl=videoUrl;}


    public String getVideoUrl(){return VideoUrl;}
    public void setVideoUrl(String videoUrl){this.VideoUrl=videoUrl;}

}
