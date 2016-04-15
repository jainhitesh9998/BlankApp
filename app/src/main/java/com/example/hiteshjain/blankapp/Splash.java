package com.example.hiteshjain.blankapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Hitesh Jain on 14-04-2016.
 */
public class Splash extends Activity {

    long a;


    MediaPlayer myMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        myMusic = MediaPlayer.create(Splash.this , R.raw.xperia);
        //final long a = myMusic.getDuration();
        myMusic.start();





        Thread timer = new Thread(){

            public void run(){
                try{


                    sleep(2000);


                } catch (InterruptedException e) {

                    e.printStackTrace();

                } finally {
                    Intent openMainActivity = new Intent("com.example.hiteshjain.blankapp.MENU");

                    startActivity(openMainActivity);

                }


            }

        };


        timer.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        myMusic.release();


        finish();
    }
}
