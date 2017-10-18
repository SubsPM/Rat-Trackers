package com.example.fredrik.rattrackers;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;


public class LoggedInScreen extends AppCompatActivity {

    private Button logOutButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_screen);
        logOutButton = (Button) findViewById(R.id.logOutButton);


        // TodoDatabaseHandler is a SQLiteOpenHelper class connecting to SQLite
        TodoDatabaseHandler handler = new TodoDatabaseHandler(this);
        // Get access to the underlying writeable database
        SQLiteDatabase db = handler.getWritableDatabase();
        // Query for items from the database and get a cursor back
        Cursor todoCursor = db.rawQuery("SELECT  * FROM RatData.db", null);

        Log.i("City", todoCursor.getString(todoCursor.getColumnIndexOrThrow("City")));

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
