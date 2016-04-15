package com.example.hiteshjain.blankapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Hitesh Jain on 14-04-2016.
 */
public class Email extends Activity implements View.OnClickListener {

    Button sendEmail;
    EditText edEmail , edName , edIntro , edCollege , edDegree , edSubject;
    String stEmail , stName , stIntro , stCollege , stDegree , stSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        initializeVars();
        sendEmail.setOnClickListener(this);
    }

    private void initializeVars() {
        edEmail = (EditText) findViewById(R.id.etEmail) ;
        edName = (EditText) findViewById(R.id.etName) ;
        edIntro = (EditText) findViewById(R.id.etIntro);
        edCollege = (EditText) findViewById(R.id.etCollege);
        edDegree = (EditText) findViewById(R.id.etDegree);
        edSubject = (EditText) findViewById(R.id.etSubject);
        sendEmail = (Button) findViewById(R.id.btEmail);

    }

    @Override
    public void onClick(View v) {
        convertTextToString();
        String emailAddress[] = {stEmail};
        String message = "Name is " + stName +"this is my intro" + stIntro +
                "college name " + stCollege +"\n" + "Degree" + stDegree + "Subject" + stSubject;

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL , emailAddress);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT , "Hello Everybody");
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_TEXT , message);
        startActivity(emailIntent);

    }

    private void convertTextToString() {
        stEmail = edEmail.getText().toString();
        stName = edName.getText().toString() ;
        stIntro =edIntro.getText().toString();
        stCollege = edCollege.getText().toString() ;
        stDegree = edDegree.getText().toString();
        stSubject = edSubject.getText().toString();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
