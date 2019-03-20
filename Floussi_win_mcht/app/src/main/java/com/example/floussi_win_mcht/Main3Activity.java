package com.example.floussi_win_mcht;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView d ;
        TextView t ;
        String output1= getIntent().getStringExtra("date");
        String output2= getIntent().getStringExtra("somme");
        d = findViewById(R.id.d1);
        t = findViewById(R.id.total);
        d.setText(output1);
        t.setText(output2);


    }
}
