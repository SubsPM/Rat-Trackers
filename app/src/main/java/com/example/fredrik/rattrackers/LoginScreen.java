package com.example.fredrik.rattrackers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

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

                String username = loginEmailField.getText().toString();
                String pass = loginPasswordField.getText().toString();
                boolean user = false;
                User currentUser = null;
                Log.i("Size", String.valueOf(WelcomeScreen.users.size()));
                for(int i = 0; i < WelcomeScreen.users.size() && !user; i++) {
                    if (WelcomeScreen.users.get(i).getEmailID().equals(username) && WelcomeScreen.users.get(i).getPassword().equals(pass)) {
                        currentUser = WelcomeScreen.users.get(i);
                        user = true;
                    }
                }

                if(user){
                    Toast.makeText(getApplicationContext(), "Correct password", Toast.LENGTH_SHORT).show();
                    // set active session to true!
                    currentUser.setctiveSession(true);
                    Intent intent = new Intent(LoginScreen.this, LoggedInScreen.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect password.. Try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
