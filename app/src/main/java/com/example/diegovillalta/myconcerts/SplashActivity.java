package com.example.diegovillalta.myconcerts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // Parse.enableLocalDatastore(this);
        Parse.initialize(this, "RZZlpsDqoH3oawhVto1BV4WNrTAgwLsdgoVhJoEw", "g2fGLIDAI24KkwgHOza7mRO2sWMKz3QVBLGsJO3O");


        Runnable runnable2Seconds = new Runnable() {
            @Override
            public void run() {
                nextActivity();
                finish();
            }
        };


        android.os.Handler myhandler = new android.os.Handler();
        myhandler.postDelayed(runnable2Seconds, 3000);

    }

    public void nextActivity(){
        Intent myintent = new Intent(this,MainActivity.class);
        startActivity(myintent);


    }

}