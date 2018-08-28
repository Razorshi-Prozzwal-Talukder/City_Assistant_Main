package com.example.user.androideatit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    TextView welcometext;
    private ProgressBar progressBar;
    private int progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        welcometext = findViewById(R.id.welcometext);
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/Amelia Script.otf");
        welcometext.setTypeface(face);

        progressBar = findViewById(R.id.progressBarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });

        thread.start();
    }

    public void doWork(){

        for(progress=20; progress<=100; progress=progress+20){

            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void startApp(){

        Intent intent = new Intent(SplashScreen.this, SectorChoice.class);
        startActivity(intent);
        finish();
    }
}
