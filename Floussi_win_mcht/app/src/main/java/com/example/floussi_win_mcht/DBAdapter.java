package com.example.floussi_win_mcht;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DBAdapter extends SQLiteOpenHelper {
    public DBAdapter(@Nullable Context context) {
        super(context, "noujou", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE depence(id integer Primary key , achat text ,montant float ,date text );";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable = "DROP Table  IF EXISTS depence;";
        db.execSQL(deleteTable);
        onCreate(db);

    }

    public void adddepence(Newachat newachat) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("achat", newachat.getAchat());
        contentValues.put("montant", newachat.getMontant());
        contentValues.put("date", newachat.getDate());
        db.insert("depence", null, contentValues);

    }


    public ArrayList<Newachat> afficherdepence() {
        SQLiteDatabase db = getReadableDatabase();
        String selectall = "select * from depence";
        Cursor cursor = db.rawQuery(selectall,null);
        ArrayList<Newachat> depences = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                Newachat achat = new Newachat();
                achat.setId(cursor.getInt(0));
                achat.setAchat(cursor.getString(1));
                achat.setMontant(cursor.getFloat(2));
                achat.setDate(cursor.getString(3));
                depences.add(achat);
            }while(cursor.moveToNext());
        }
        return depences;

    }
    public void remove(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("depence","id="+Integer.toString(id),null);}

}
