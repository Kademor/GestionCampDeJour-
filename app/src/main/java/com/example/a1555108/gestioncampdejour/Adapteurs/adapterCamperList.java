package com.example.a1555108.gestioncampdejour.Adapteurs;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1555108.gestioncampdejour.Activites.CamperActivity;
import com.example.a1555108.gestioncampdejour.Activites.ListActivity;
import com.example.a1555108.gestioncampdejour.Activites.SignUpActivity;
import com.example.a1555108.gestioncampdejour.Classes.Camper;
import com.example.a1555108.gestioncampdejour.Classes.CamperList;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.RetroFitUtils;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.ServiceService;
import com.example.a1555108.gestioncampdejour.R;
import com.example.a1555108.gestioncampdejour.Singleton.SingletonCamper;
import com.example.a1555108.gestioncampdejour.Singleton.SingletonUser;
import com.squareup.otto.Bus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class adapterCamperList extends ArrayAdapter<CamperList>{

    public Bus monbus = new Bus();
    Camper camperLoad;
    ServiceService service = RetroFitUtils.getMock();
    public Context c;



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
                getCamperALoad(camperUnit.getId());
            }
        });

        btncheckMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btncheckMark.getText().equals("✔") ){
                    btncheckMark.setText(" ");
                    camperUnit.setPresent(false);
                }
                else{
                    btncheckMark.setText("✔");
                    camperUnit.setPresent(true);
                }
            }
        });
        return  view;
    }

    //enqueue pour la requete
    public void getCamperALoad(int CamperId){
        service.getCamper(CamperId).enqueue(new Callback<Camper>() {
            @Override
            public void onResponse(Call<Camper> call, Response<Camper> response) {
                if (response.isSuccessful()){
                    camperLoad = response.body();
                    Intent i = new Intent( c,CamperActivity.class);
                    SingletonCamper test = SingletonCamper.getInstance();
                    test.setSelectedCamper(camperLoad);
                    c.startActivity(i);
                }
                else{
                    Log.i("ErreurResponse", "Response pas marcher");
                }
            }

            @Override
            public void onFailure(Call<Camper> call, Throwable t) {
                Log.i("Erreur mock",  t.getMessage());
            }
        });
    }

    public adapterCamperList(@NonNull Context context) {
        super(context,R.layout.lay_list_camper);
    }
}





