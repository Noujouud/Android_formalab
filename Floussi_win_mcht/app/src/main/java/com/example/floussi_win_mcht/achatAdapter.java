package com.example.floussi_win_mcht;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class achatAdapter extends ArrayAdapter< Newachat> {
    private ArrayList<Newachat> arrayList;
    private Context ctx;
    private int item;

    public achatAdapter(@NonNull Context context , int resource , ArrayList<Newachat> myarrayList) {
        super(context , resource, myarrayList);
        this.arrayList = myarrayList;
        this.ctx = context;
        this.item = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(ctx).inflate(item, parent, false);
        TextView montant = convertView.findViewById(R.id.montant);
        TextView achat = convertView.findViewById(R.id.achat);
        TextView date = convertView.findViewById(R.id.date);
        montant.setText(Float.toString(arrayList.get(position).getMontant()));
        date.setText(arrayList.get(position).getDate());
        achat.setText(arrayList.get(position).getAchat());


        return convertView ;
    }
}
