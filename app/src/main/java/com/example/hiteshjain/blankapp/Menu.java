package com.example.hiteshjain.blankapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Hitesh Jain on 14-04-2016.
 */
public class Menu  extends ListActivity {



    String classes[] = { "MainActivity" , "TextPlay" , "Email" , "Camera" , "example4" , "example5" , "example6" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(Menu.this , android.R.layout.simple_list_item_1 , classes));
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String newClasses = classes[position];

        try {


            Class ourClass = Class.forName("com.example.hiteshjain.blankapp." +newClasses);
            Intent ourIntent = new Intent(Menu.this, ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }



}
