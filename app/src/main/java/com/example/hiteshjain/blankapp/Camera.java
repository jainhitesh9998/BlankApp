package com.example.hiteshjain.blankapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by Hitesh Jain on 14-04-2016.
 */
public class Camera extends Activity implements View.OnClickListener {


    ImageButton ib;
    Button b;
    ImageView iv;
    Intent i;
    Bitmap bmp ;
    final static int cameraData = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        initialize();
        InputStream is = getResources().openRawResource(R.drawable.darthvader);
        bmp = BitmapFactory.decodeStream(is);

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
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        if(resultCode == RESULT_OK) {
            Bundle extra = data.getExtras();
            bmp = (Bitmap) extra.get("data");
            iv.setImageBitmap(bmp);

        }
    }
}
