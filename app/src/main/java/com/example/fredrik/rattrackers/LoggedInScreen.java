package com.example.fredrik.rattrackers;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class LoggedInScreen extends AppCompatActivity {
    static ArrayList<String> lista;
    private Button logOutButton;
    private Button displayList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_screen);
        logOutButton = (Button) findViewById(R.id.logOutButton);
        displayList = (Button) findViewById(R.id.displayList);

        lista = new ArrayList<String>();
        //new DownloadFilesTask().execute();
        lista = readInText();

        displayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoggedInScreen.this, DisplayRatList.class);
                startActivity(intent);
            }
        });


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


    private ArrayList<String> readInText(){

        ArrayList<String> temp = new ArrayList<>();
        try {
            InputStream inputStream = getApplicationContext().getAssets().open("rat_sightings.csv");


            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                //StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    //stringBuilder.append(receiveString);
                    temp.add(receiveString);

                }

                inputStream.close();

            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return temp;
    }
}
