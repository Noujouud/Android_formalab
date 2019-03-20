package com.example.floussi_win_mcht;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView mylist ;
    ArrayList <Newachat> depences ;
    public  achatAdapter ad ;

    DBAdapter dbAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = findViewById(R.id.listview);
        depences = new ArrayList<Newachat>();
        dbAdaptor = new DBAdapter(this);
        depences =dbAdaptor.afficherdepence();
         achatAdapter achatAdapter = new achatAdapter( this , R.layout.achat_ithem_1, depences);
        mylist.setAdapter(achatAdapter);




        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete ");

                adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbAdaptor.remove(depences.get(position).getId());
                        depences=dbAdaptor.afficherdepence();

                        achatAdapter achatAdapter = new achatAdapter( MainActivity.this , R.layout.achat_ithem_1, depences);
                        mylist.setAdapter(achatAdapter);

                    }});

                adb.setNegativeButton("cancel", null);
                adb.setIcon(android.R.drawable.ic_dialog_alert);
                adb.show();

            }
        });}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.add_achat_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.add){
            Intent intent = new Intent( MainActivity.this ,Main2Activity.class);
            startActivity(intent);


        }
        if(item.getItemId()==R.id.total){
            String S = Sum().toString();
            String dte;
            if (depences.size()!=0){
                 dte = depences.get(0).getDate().toString();
            }
            else { dte = "fammech date khatr mazilt masraft chey ya9armat :p ";}
            //String dte = depences.get(0).getDate().toString();
            Intent intent = new Intent( MainActivity.this ,Main3Activity.class);
            intent.putExtra("somme",S);
            intent.putExtra("date",dte);
            startActivity(intent);}
            return true;


}    public Float Sum (){
        Float somme = 0f ;
        if ( depences.size()!=0){


        for ( int i =0 ; i < depences.size() ; i++){
            somme=somme+depences.get(i).getMontant();
        } return somme ;}
        else return somme ;
    }






}
