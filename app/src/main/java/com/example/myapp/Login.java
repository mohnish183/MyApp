package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static EditText name;
    private static EditText password;
    private static Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

            name = (EditText) findViewById( R.id.editText );
            password = (EditText) findViewById( R.id.editText3 );
            login = (Button) findViewById( R.id.login );


            login.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (name.getText().toString().equals( "mohnish" ) && password.getText().toString().equals( "dhoni183" )) {

                        Toast.makeText( Login.this, "user name is correct", Toast.LENGTH_SHORT ).show();

                        Intent intent = new Intent(getApplicationContext(),Index.class);
                        startActivity( intent );


                    } else {
                        Toast.makeText( Login.this, "user name and password is not correct", Toast.LENGTH_SHORT ).show();
                    }


                }

            } );
        }
    }

