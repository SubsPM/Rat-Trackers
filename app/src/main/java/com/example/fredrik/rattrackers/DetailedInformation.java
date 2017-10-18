package com.example.fredrik.rattrackers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailedInformation extends AppCompatActivity {
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_information);


        int position = getIntent().getIntExtra("POSITION", -1);
        Log.i("Position: ", Integer.toString(position));
        textView = (TextView) findViewById(R.id.textView);

        String[] line = LoggedInScreen.lista.get(position).split(",");
        String addLine = "Date: " + line[1] + "\nAgency: " + line[3] +  "\nLocation: " + line[7];

        textView.setText(addLine);

    }
}
