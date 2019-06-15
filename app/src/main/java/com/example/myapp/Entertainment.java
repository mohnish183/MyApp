package com.example.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Vector;

public class Entertainment extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<YouTubeVideo> youtubevideos=new Vector<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_book );
        recyclerView=(RecyclerView)findViewById( R.id.recyclerView );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager(  this) );
        youtubevideos.add( new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RiANSSgCuJk\" frameborder=\"0\" allowfullscreen></iframe>") );
        VideoAdapter videoAdapter=new VideoAdapter( youtubevideos );
        recyclerView.setAdapter( videoAdapter );
    }
}