package com.example.a1555108.gestioncampdejour.MockServeurUtils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.a1555108.gestioncampdejour.Classes.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceMethods {
    ServiceService service = RetroFitUtils.getMock();

    public User getUserService(){
        final User[] user = new User[1];
        service.getUser().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    user[0] = response.body();
                }
                else{
                    Log.i("ERREURMOCK", String.valueOf(response.code()));
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //Toast.makeText(c.getApplicationContext(),"Failed to connect",Toast.LENGTH_SHORT).show();
                Log.i("ERREURMOCKFAILURE", "Failed to connect");
            }
        });
        return user[0];
    }

}
