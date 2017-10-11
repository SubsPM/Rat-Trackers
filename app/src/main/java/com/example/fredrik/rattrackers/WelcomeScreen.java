package com.example.fredrik.rattrackers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class WelcomeScreen extends AppCompatActivity {

    private EditText registrationEmailField;
    private EditText registrationPasswordField;
    private EditText confirmPassword;
    private Button signUpButton;
    private TextView toLogin;
    private Switch isUser;
    private User newUser;

    public static ArrayList<User> users = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        newUser = new User();
        registrationEmailField = (EditText) findViewById(R.id.registrationEmailField);
        registrationPasswordField = (EditText) findViewById(R.id.registrationPasswordField);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        toLogin = (TextView) findViewById(R.id.toLogin);
        isUser = (Switch) findViewById(R.id.isUser);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);



        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(registrationEmailField.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "You have to enter your email!", Toast.LENGTH_SHORT).show();
                }else if(registrationPasswordField.getText().toString().equals("") || confirmPassword.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "You have to enter a password in both fields..", Toast.LENGTH_SHORT).show();
                }else{
                    boolean rval =  passwordVerifier();
                    boolean unique = uniqueEmail();
                    if(rval && unique){
                        boolean user = isUser.isChecked();
                        users.add(new User(registrationEmailField.getText().toString(), registrationPasswordField.getText().toString(), true, user));
                        Toast.makeText(getApplicationContext(), "Successfully created a new account!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(WelcomeScreen.this, LoggedInScreen.class);
                        startActivity(intent);
                    }else if(!rval){
                        Toast.makeText(getApplicationContext(), "Passwords does'n match...", Toast.LENGTH_SHORT).show();
                    }else if(!unique){
                        Toast.makeText(getApplicationContext(), "Email already exists..", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean uniqueEmail() {
        boolean flag = true;
        String email = registrationEmailField.getText().toString();
        Log.i("TP!", "KOMMER HIT");
        Log.i("SIZE: ", String.valueOf(users.size()));
        for(int i = 0; i < users.size() && flag; i++){
            if(email.equals(users.get(i).getEmailID())){
                Log.i("Email in array: ", users.get(i).getEmailID());
                flag = false;
            }
        }

        return flag;
    }

    public void gotToLoginScreen(View view){
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }

    private boolean passwordVerifier() {
        boolean flag = false;
        if(registrationPasswordField.getText().toString().equals(confirmPassword.getText().toString())){
            flag = true;
        }
        return flag;
    }


}

