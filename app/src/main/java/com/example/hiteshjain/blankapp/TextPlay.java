package com.example.hiteshjain.blankapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by Hitesh Jain on 14-04-2016.
 */
public class TextPlay extends Activity implements View.OnClickListener {
    Button chkCmd;
    ToggleButton thButton;
    EditText edText;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        initialization();



        thButton.setOnClickListener(this);


        chkCmd.setOnClickListener(this);


    }

    private void initialization() {
        chkCmd = (Button) findViewById(R.id.button2  );
        thButton = (ToggleButton) findViewById(R.id.toggleButton);
        edText = (EditText) findViewById(R.id.etCommand);
        tv = (TextView) findViewById(R.id.textView2);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button2:
                String check = edText.getText().toString();
                tv.setText(check);

                if(check.contentEquals("left")){

                    tv.setGravity(Gravity.LEFT);


                } else if (check.contentEquals("center")){
                    tv.setGravity(Gravity.CENTER);



                } else if (check.contentEquals("right")){
                    tv.setGravity(Gravity.RIGHT);


                } else if (check.contentEquals("blue")){
                    tv.setTextColor(Color.BLUE);


                } else if (check.contains("WTF")){

                    Random crazy =new Random();
                    tv.setText("WTF!!!!");
                    tv.setTextSize(crazy.nextInt(75));
                    tv.setTextColor(Color.rgb(crazy.nextInt(255), crazy.nextInt(255), crazy.nextInt(255)));
                    switch (crazy.nextInt(3)){
                        case 0 :
                            tv.setGravity(Gravity.LEFT);
                            break;
                        case 1 :
                            tv.setGravity(Gravity.CENTER);
                            break;
                        case 2 :
                            tv.setGravity(Gravity.RIGHT);
                            break;
                    }


                } else {
                    tv.setText("invalid");
                    tv.setGravity(Gravity.CENTER);
                    tv.setTextColor(Color.BLACK);

                }

                break;
            case R.id.toggleButton:
                if(thButton.isChecked()){

                    edText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                }else{
                    edText.setInputType(InputType.TYPE_CLASS_TEXT);

                }



                break;


        }

    }
}
