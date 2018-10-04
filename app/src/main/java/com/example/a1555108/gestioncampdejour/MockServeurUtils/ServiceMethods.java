package com.example.a1555108.gestioncampdejour.MockServeurUtils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.a1555108.gestioncampdejour.Activites.CamperActivity;
import com.example.a1555108.gestioncampdejour.Activites.ListActivity;
import com.example.a1555108.gestioncampdejour.Activites.LoginActivity;
import com.example.a1555108.gestioncampdejour.Classes.Camper;
import com.example.a1555108.gestioncampdejour.Classes.User;
import com.example.a1555108.gestioncampdejour.R;
import com.example.a1555108.gestioncampdejour.Singleton.SingletonCamper;
import com.example.a1555108.gestioncampdejour.Singleton.SingletonUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceMethods {
    ServiceService service = RetroFitUtils.getMock();

    public void connectWithUser(final Context c, String campName, String password) {
        service.getUser(campName, password).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Intent i = new Intent(c.getApplicationContext(), ListActivity.class);
                    SingletonUser test = SingletonUser.getInstance();
                    test.setUserConnected(response.body());
                    c.startActivity(i);
                } else {
                    Log.i("ERREURMOCK", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i("ERREURMOCKFAILURE", "Failed to connect");
            }
        });
    }


    public void sendUserServer(final Context c, User u) {
        service.createUser(u).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(c.getApplicationContext(), "user crée", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(c.getApplicationContext(), LoginActivity.class);
                    c.startActivity(i);
                } else {
                    Log.i("ERREURMOCK", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i("ERREURMOCK", t.getMessage());
            }
        });

    }

    public void getCamperALoad(final Context c, int CamperId){
        service.getCamper(CamperId).enqueue(new Callback<Camper>() {
            @Override
            public void onResponse(Call<Camper> call, Response<Camper> response) {
                if (response.isSuccessful()){
                    Intent i = new Intent( c.getApplicationContext(),CamperActivity.class);
                    SingletonCamper test = SingletonCamper.getInstance();
                    test.setSelectedCamper( response.body());
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

    public void setAddCamper(final Context c , Camper camper){
        service.createCamper(camper).enqueue(new Callback<Camper>() {
            @Override
            public void onResponse(Call<Camper> call, Response<Camper> response) {
                if (response.isSuccessful()){
                    Toast.makeText(c.getApplicationContext(),"camper created", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(c.getApplicationContext(), ListActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    c.startActivity(i);
                }else{
                    Log.i("ErreurResponse", "Response pas marcher");
                }
            }

            @Override
            public void onFailure(Call<Camper> call, Throwable t) {
                Log.i(String.valueOf(R.string.ErreurMock),  t.getMessage());
            }
        });
    }
}
