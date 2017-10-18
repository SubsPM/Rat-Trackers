package com.example.fredrik.rattrackers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayRatList extends AppCompatActivity {
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rat_list);

        listView = (ListView) findViewById(R.id.listView);

        final ArrayList<String> temp = new ArrayList<>();
        for(int i = 0; i < 100;i++){
            if (i != 0) {
                String[] line = LoggedInScreen.lista.get(i).split(",");
                String addLine = "Date: " + line[1] + "\tLocation: " + line[7];
                temp.add(addLine);
            }else{
                String[] line = LoggedInScreen.lista.get(i).split(",");
                String addLine = "Date: " + "\tLocation: ";
                temp.add(addLine);
            }


        }

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, temp);
        // Set The Adapter
        listView.setAdapter(arrayAdapter);

        // register onClickListener to handle click events on each item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {

                String selectedRatReport = temp.get(position);
                Toast.makeText(getApplicationContext(), "Pressed Item at position: " + position,   Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DisplayRatList.this, DetailedInformation.class);
                intent.putExtra("POSITION", position);
                startActivity(intent);
            }
        });
    }
}
