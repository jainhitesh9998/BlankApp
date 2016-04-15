package com.example.hiteshjain.blankapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


/**
 * Created by Hitesh Jain on 14-04-2016.
 */
public class Camera extends Activity implements View.OnClickListener {


    ImageButton ib;
    Button b;
    ImageView iv;
    Intent i;
    final static int cameraData = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        initialize();
        
    }

    private void initialize() {
        ib = (ImageButton) findViewById( R.id.ibTakePic);
        iv = (ImageView) findViewById(R.id.ivReturnedPic);
        b = (Button)findViewById(R.id.bSetWallpaper);
        b.setOnClickListener(this);
        ib.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bSetWallpaper:
                break;
            case R.id.ibTakePic:
                i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,cameraData);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
