package com.example.fredrik.rattrackers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {


    // hardcoded username and password
    private String username = "user";
    private String pass = "pass";

    private TextView loginEmailField;
    private TextView loginPasswordField;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


        loginButton = (Button) findViewById(R.id.loginButton);
        loginPasswordField = (TextView) findViewById(R.id.loginPasswordField);
        loginEmailField = (TextView) findViewById(R.id.loginEmailField);


        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("Test button", "It works!");
                Log.i("Username: ", loginEmailField.getText().toString());
                Log.i("Password: ", loginPasswordField.getText().toString());

                if(username.equals(loginEmailField.getText().toString()) && pass.equals(loginPasswordField.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Correct password", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect password.. Try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
