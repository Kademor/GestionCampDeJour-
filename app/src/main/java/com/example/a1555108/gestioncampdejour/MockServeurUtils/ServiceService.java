package com.example.a1555108.gestioncampdejour.MockServeurUtils;

import com.example.a1555108.gestioncampdejour.Classes.Camper;
import com.example.a1555108.gestioncampdejour.Classes.CamperList;
import com.example.a1555108.gestioncampdejour.Classes.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceService {
    @GET("/users/jorisdeguet/repos")
    Call<String> racine();

    @GET("/")
    Call<User> getUser();

    @GET("/")
    Call<Camper> getCamper();

    @GET("/")
    Call<ArrayList<CamperList>> getCamperList();



}