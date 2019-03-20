package com.example.floussi_win_mcht;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Newachat {
    private String achat ;
    private  int id ;
    private  float montant ;
    //private String date ;

    String date;



    public Newachat () {

    }

    public Newachat( String achat, float montant) {
        this.montant = montant;
        this.achat = achat;
        //this.date = date;
        Date now = new Date();
        DateFormat dateformatter = DateFormat.getDateInstance(DateFormat.SHORT);
        date = dateformatter.format(now);

    }

    public int getId() {
        return id;
    }
    public String getAchat() {
        return achat;
    }

    public float getMontant() {
        return montant ;
    }

    public String getDate() {
        return date;
    }
    public void setId(int id) { this.id = id; }
    public void setAchat(String achat) {
        this.achat= achat;
    }

    public void setMontant(float montant) {
        this.montant= montant;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

