package com.example.hiteshjain.blankapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    int counter;
    Button add , sub  ,next ;
    TextView display;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = 0;
        add = (Button) findViewById(R.id.button);
        sub = (Button) findViewById(R.id.button1);
        display = (TextView) findViewById(R.id.textView);

        add.setOnClickListener(new View.OnClickListener()   {

            public void onClick(View view){

                counter++;

                display.setText("Your Total is " +counter);


            }
        });

        sub.setOnClickListener(new View.OnClickListener()   {

            public void onClick(View view){

                counter--;

                display.setText("Your Total is " +counter);


            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
