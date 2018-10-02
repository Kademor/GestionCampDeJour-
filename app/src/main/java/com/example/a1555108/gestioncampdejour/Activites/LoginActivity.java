package com.example.a1555108.gestioncampdejour.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.Toast;
=======
>>>>>>> 47eb70555c2be2620405809252d6beefda6f2628


import com.example.a1555108.gestioncampdejour.Classes.CamperList;
import com.example.a1555108.gestioncampdejour.Classes.User;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.RetroFitUtils;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.ServiceService;
import com.example.a1555108.gestioncampdejour.R;
import com.example.a1555108.gestioncampdejour.Singleton.SingletonUser;

import java.util.ArrayList;
import java.util.List;

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
<<<<<<< HEAD

        Button btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUserService();
                signIn();
            }
        });
       // setListeCamperMock();
=======
        //setUserService();
>>>>>>> 47eb70555c2be2620405809252d6beefda6f2628
        // Set up the login form.

    }

    public void register(View v){
        Intent i = new Intent(getApplicationContext(),SignUpActivity.class);

        startActivity(i);
    }
<<<<<<< HEAD
    public void signIn() {
        Intent i = new Intent(getApplicationContext(),ListActivity.class);
        SingletonUser userSetup = new SingletonUser(getApplicationContext());
        userSetup.init(getApplicationContext());
        //userSetup.bus.post(userSetup.connectedUser);
        startActivity(i);
=======
    public void signIn(View view) {
        setUserService();
>>>>>>> 47eb70555c2be2620405809252d6beefda6f2628
    }





    public void setUserService(){

        service.getUser().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // code si ca marche
                userConnect =response.body();
                Intent i = new Intent(getApplicationContext(),ListActivity.class);
                SingletonUser test = SingletonUser.getInstance();
                test.setUserConnected(userConnect);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
<<<<<<< HEAD
                Toast.makeText(getApplicationContext(),"fuck",Toast.LENGTH_LONG).show();
=======
                // code quand marche pas
                Log.i("erreur", "pas rentrer dans le response");
>>>>>>> 47eb70555c2be2620405809252d6beefda6f2628
            }
        });
    }









}

