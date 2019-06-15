package com.example.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.Vector;

public class Clothes extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<YouTubeVideo> youtubevideos=new Vector<>();
    CarouselView carouselView;
    int cimage[]={R.drawable.montecarlo,R.drawable.cloth1,R.drawable.cloth2};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_book );
        recyclerView=(RecyclerView)findViewById( R.id.recyclerView );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager(  this) );
        youtubevideos.add( new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/mMjOHAriaQg\" frameborder=\"0\" allowfullscreen></iframe>") );
        VideoAdapter videoAdapter=new VideoAdapter( youtubevideos );
        recyclerView.setAdapter( videoAdapter );
        carouselView=findViewById( R.id.carouselView );
        carouselView.setPageCount( cimage.length );
        carouselView.setImageListener(imageListener);
    }
    ImageListener imageListener=new ImageListener() {
        @Override
        public void setImageForPosition(int position,ImageView imageView) {
            imageView.setImageResource( cimage[position] );
        }
    };
}