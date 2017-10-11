package com.example.fredrik.rattrackers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;


public class LoggedInScreen extends AppCompatActivity {

    private Button logOutButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_screen);
        logOutButton = (Button) findViewById(R.id.logOutButton);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User currentUser = null;
                boolean flag = false;
                for(int i = 0; i < WelcomeScreen.users.size() && !flag; i++){
                    if(WelcomeScreen.users.get(i).isActiveSession()){
                        currentUser = WelcomeScreen.users.get(i);
                        flag = true;
                    }
                }
                if(flag){
                    currentUser.setctiveSession(false);
                }
                Toast loggedOutToast = Toast.makeText(getApplicationContext(),
                        "You have successfully logged out.", Toast.LENGTH_SHORT);
                loggedOutToast.show();
                Intent intent = new Intent(LoggedInScreen.this, WelcomeScreen.class);
                startActivity(intent);
            }
        });
    }
}
