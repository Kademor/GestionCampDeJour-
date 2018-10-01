package com.example.a1555108.gestioncampdejour.Activites;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.a1555108.gestioncampdejour.Classes.User;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.RetroFitUtils;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.ServiceMethods;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.ServiceService;
import com.example.a1555108.gestioncampdejour.R;
import com.example.a1555108.gestioncampdejour.Singleton.Singleton;
import com.example.a1555108.gestioncampdejour.Singleton.SingletonUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    User userConnect;
    ServiceService service = RetroFitUtils.getMock();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

    }

    public void register(View v){
        Intent i = new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(i);
    }
    public void signIn(View view) {
        Intent i = new Intent(getApplicationContext(),ListActivity.class);
        SingletonUser userSetup = new SingletonUser(getApplicationContext());
        userSetup.init(getApplicationContext());
        setUserService();

        //userSetup.bus.post(userSetup.connectedUser);
        startActivity(i);
    }





    public void setUserService(){
        service.getUser().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                userConnect =response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }





}

