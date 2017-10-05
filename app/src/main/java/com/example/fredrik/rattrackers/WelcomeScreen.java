package com.example.fredrik.rattrackers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class WelcomeScreen extends AppCompatActivity {

    private EditText registrationEmailField;
    private EditText registrationPasswordField;
    private Button buttonSignup;
    private TextView toLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);



        registrationEmailField = (EditText) findViewById(R.id.registrationEmailField);
        registrationPasswordField = (EditText) findViewById(R.id.registrationPasswordField);
        buttonSignup = (Button) findViewById(R.id.buttonSignUp);
        toLogin = (TextView) findViewById(R.id.toLogin);
        
    }

    public void gotToLoginScreen(View view){
        Log.i("Test", "kommer hit");
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }


}

