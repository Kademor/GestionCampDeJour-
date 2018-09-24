package com.example.a1555108.gestioncampdejour.Adapteurs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.a1555108.gestioncampdejour.Classes.Camper;
import com.example.a1555108.gestioncampdejour.Classes.CamperList;
import com.example.a1555108.gestioncampdejour.R;
import com.squareup.otto.Bus;

public class adapterCamperList extends ArrayAdapter<CamperList>{

    public Bus monbus = new Bus();

    @NonNull
    @Override
    public View getView(int position , @Nullable View convertView, @NonNull ViewGroup parent){


        monbus.register(this);
        LayoutInflater li = LayoutInflater.from(getContext());
        View view = li.inflate(R.layout.lay_list_camper,null);
        final CamperList camperUnit = getItem(position);

        final Button btncamperName = (Button) view.findViewById(R.id.btnListCamper);
        final Button btncheckMark = (Button)view.findViewById(R.id.btnListCheck);

        btncamperName.setText(camperUnit.getLastName() + ", " + camperUnit.getFirstName());
        btncheckMark.setText(" ");

        btncamperName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btncheckMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btncheckMark.getText().equals("✔") ){
                    btncheckMark.setText(" ");
                }
                else{
                    btncheckMark.setText("✔");
                }
            }
        });
        return  view;
    }

    public adapterCamperList(@NonNull Context context) {
        super(context,R.layout.lay_list_camper);
    }
}





