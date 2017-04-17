package com.example.xenon.phoneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView) findViewById(R.id.phones);

        String phones[] = {"Samsung Galaxy S8", "Xiaomi Redmi Note 3 Pro", "HTC One m9"};

        ArrayList<String> phoneList = new ArrayList<String>();
        phoneList.addAll( Arrays.asList(phones) );

        adapter = new ArrayAdapter<String>(this, R.layout.row, phoneList);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch ((int) id){
                    case 0:
                        intent = new Intent(getApplicationContext(), Samsung.class);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), Xiaomi.class);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), HTC.class);
                        break;
                    default:
                        intent = new Intent(getApplicationContext(), Samsung.class);
                }
                startActivity(intent);
            }
        });
    }
}
