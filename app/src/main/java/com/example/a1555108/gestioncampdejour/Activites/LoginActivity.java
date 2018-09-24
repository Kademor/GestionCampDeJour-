package com.example.a1555108.gestioncampdejour.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;


import com.example.a1555108.gestioncampdejour.Classes.User;
import com.example.a1555108.gestioncampdejour.R;

public class LoginActivity extends AppCompatActivity {

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
        User user = new User("Philippe" , "Morin" , "Merlin", " mdp");
        startActivity(i);
    }





}

