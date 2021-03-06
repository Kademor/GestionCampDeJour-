package com.example.a1555108.gestioncampdejour.Activites;

import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1555108.gestioncampdejour.Classes.User;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.RetroFitUtils;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.ServiceMethods;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.ServiceSeriveMock;
import com.example.a1555108.gestioncampdejour.MockServeurUtils.ServiceService;
import com.example.a1555108.gestioncampdejour.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    ServiceMethods methodsService = new ServiceMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void signUp(View v){
        TextView tvFirstName = findViewById(R.id.signInFirstName);
        TextView tvLastName = findViewById(R.id.signInLastName);
        TextView tvCampName = findViewById(R.id.signInCampName);
        TextView tvPassword = findViewById(R.id.signInPassword);
        TextView tvConfPassword = findViewById(R.id.signInConfirmPassword);

        if (!tvPassword.getText().toString().equals(tvConfPassword.getText().toString())){
            Toast.makeText(getApplicationContext(),"mot de passe non identique", Toast.LENGTH_LONG).show();
        }else {
            User user = new User(tvFirstName.getText().toString(),tvLastName.getText().toString(),tvCampName.getText().toString(), tvPassword.getText().toString());
            methodsService.sendUserServer(this.getApplicationContext(), user);
        }
    }
    public void back(View v){
        finish();
    }
}
