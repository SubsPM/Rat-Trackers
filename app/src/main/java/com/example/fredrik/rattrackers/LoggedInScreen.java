package com.example.fredrik.rattrackers;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

import java.io.InputStream;
import java.util.List;


public class LoggedInScreen extends AppCompatActivity {
    private Button logOutButton;
    private SQLiteDatabase mydatabase;
    private Cursor todoCursor;
    private ListView lvItems;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_screen);
        logOutButton = (Button) findViewById(R.id.logOutButton);

        //new DownloadFilesTask().execute();
        // Attach cursor adapter to the ListView

        mydatabase = openOrCreateDatabase("ratdata.db",MODE_PRIVATE,null);
        todoCursor = mydatabase.rawQuery("SELECT  * FROM 'RatData.db';", null);
        TodoCursorAdapter todoAdapter = new TodoCursorAdapter(this, todoCursor);

        lvItems = (ListView) findViewById(R.id.listView);
        lvItems.setAdapter(todoAdapter);


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

    private class DownloadFilesTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {

            mydatabase = openOrCreateDatabase("ratdata.db",MODE_PRIVATE,null);
            todoCursor = mydatabase.rawQuery("SELECT  * FROM ratdata.db", null);



            return null;
        }
    }

}
