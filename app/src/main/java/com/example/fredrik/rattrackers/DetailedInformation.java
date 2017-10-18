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
        String addLine = "\nUnique Key: " + line[0] +"\nCreated Date: " + line[1] + "\nAgency: " + line[3] +  "\nLocation Type: " + line[7] +  "\nIncident Zip: " + line[8] +  "\nIncident Address: " + line[9] +  "\nCity: " + line[16] +  "\nBorough: " + line[23] +  "\nLatitude: " + line[49] +  "\nLongitude: " + line[50];

        textView.setText(addLine);

    }
}
