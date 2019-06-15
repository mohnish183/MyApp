package com.example.myapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    List<YouTubeVideo> youTubeVideoList;
    public VideoAdapter(){

    }
    public VideoAdapter(List<YouTubeVideo>youTubeVideoList){
        this.youTubeVideoList=youTubeVideoList;

    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view= LayoutInflater.from( parent.getContext()).inflate(R.layout.video_view ,parent, false) ;


        return new VideoViewHolder(view);
    }
    public void onBindViewHolder(VideoViewHolder holder,int position){
        holder.videoWeb.loadData(youTubeVideoList.get( position ).getVideoUrl(),"text/html","utf-8");
    }
    public int getItemCount()
    {
        return youTubeVideoList.size();
    }
    public class VideoViewHolder extends RecyclerView.ViewHolder{
        WebView videoWeb;
        public VideoViewHolder(View itemView){
            super(itemView);
            videoWeb=(WebView) itemView.findViewById( R.id.videoWebView );
            videoWeb.getSettings().setJavaScriptEnabled( true );
            videoWeb.setWebChromeClient( new WebChromeClient(){

            } );
        }
    }
}
