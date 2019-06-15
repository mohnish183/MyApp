package com.example.myapp;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import 	android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import static com.example.myapp.R.*;
import static com.example.myapp.R.string.navigation_drawer_close;


public class Index extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    GridView androidGridView;

    Integer[] imageIDs = {
            drawable.book,drawable.cloth,
            drawable.piza,drawable.mobile,
            drawable.gift,drawable.grocery,
            drawable.entertainment,drawable.hope,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( layout.activity_index );
        android.widget.Toolbar toolbar = findViewById( id.toolbar );
        setSupportActionBar(toolbar);
        drawer = findViewById( id.drawer_layout );
        NavigationView navigationView = findViewById( id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );







//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( drawer,this,toolbar,string.navigation_drawer_open,string.navigation_drawer_close );
//        drawer.addDrawerListener( toggle );
//        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace( id.fragment_container,new PersonFragment() ).commit();
            navigationView.setCheckedItem( id.nav_person );
        }


    }

    private void setSupportActionBar(android.widget.Toolbar toolbar) {
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case id.nav_person:
                getSupportFragmentManager().beginTransaction().replace( id.fragment_container,new PersonFragment() ).commit();
                break;
            case id.nav_cart:
                getSupportFragmentManager().beginTransaction().replace( id.fragment_container,new CartFragment() ).commit();
                break;
            case id.nav_message:
                getSupportFragmentManager().beginTransaction().replace( id.fragment_container,new MessageFragment() ).commit();
                break;
            case id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace( id.fragment_container,new ChatFragment() ).commit();
                break;


        }
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }


    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById( id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }

        androidGridView = findViewById( id.gridview );
        androidGridView.setAdapter( new ImageAdapterGridView( this ) );

        androidGridView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v,int position,long id) {
//                Toast.makeText(getBaseContext(), "Grid Item " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();


                switch (position + 1) {
                    case 1: // books
                        Intent i1 = new Intent( getApplicationContext(),Book.class );
                        startActivity( i1 );
                        break;
                    case 2:
                        Intent i2 = new Intent( getApplicationContext(),Clothes.class );
                        startActivity( i2 );
                    case 3:
                        Intent i3 = new Intent( getApplicationContext(),Food.class );
                        startActivity( i3 );
                    case 4:
                        Intent i4 = new Intent( getApplicationContext(),Mobile.class );
                        startActivity( i4 );
                    case 5:
                        Intent i5 = new Intent( getApplicationContext(),Gift.class );
                        startActivity( i5 );
                    case 6:
                        Intent i6 = new Intent( getApplicationContext(),Grocery.class );
                        startActivity( i6 );
                    case 7:
                        Intent i7 = new Intent( getApplicationContext(),Entertainment.class );
                        startActivity( i7 );
                    case 8:
                        Intent i8 = new Intent( getApplicationContext(),Charity.class );
                        startActivity( i8 );


                }

            }
        } );

    }

    public void setSupportActionBar(android.support.v7.widget.Toolbar toolbar) {
    }

    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position,View convertView,ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView( mContext );
                mImageView.setLayoutParams( new GridView.LayoutParams( 540,500 ) );
                mImageView.setScaleType( ImageView.ScaleType.CENTER_CROP );
                mImageView.setPadding( 6,6,6,6 );
            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource( imageIDs[position] );
            return mImageView;
        }
    }


}