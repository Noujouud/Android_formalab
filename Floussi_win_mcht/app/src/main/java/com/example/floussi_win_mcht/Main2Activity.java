package com.example.floussi_win_mcht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    Button b ;
    EditText E1;
    EditText E2;
    EditText E3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DBAdapter dbAdapter = new DBAdapter(this);
        setContentView(R.layout.activity_main2);
        b = findViewById(R.id.btn);
        E1 = findViewById(R.id.ach);
        E2 = findViewById(R.id.mnt);
        //E3 = findViewById(R.id.dt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String achat = E1.getText().toString();
                Float montant = Float.valueOf(E2.getText().toString());
               // String date = E3.getText().toString();
                Newachat newachat = new Newachat(achat,montant);
                dbAdapter.adddepence(newachat);
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);


            }
        });

    }
}
