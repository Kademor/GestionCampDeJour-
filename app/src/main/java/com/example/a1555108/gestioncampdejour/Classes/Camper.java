package com.example.a1555108.gestioncampdejour.Classes;

import java.util.List;

public class Camper {
    private int id;
    private int AnimId;
    private String firstName;
    private String lastName;
    private List<String> alergies;
    private String emergencyNumber;
    private String specialCase;

    public Camper( int _id, String _firstName, String _lastName, List<String> _alergies, String _emergencyNumber, String _specialCase){
        this.id  = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.alergies = _alergies;
        this.emergencyNumber = _emergencyNumber;
        this.specialCase = _specialCase;
    }

    public int getId(){return id;}
    public void setId(int id) {
        this.id = id;
    }

    public int getAnimId() {
        return AnimId;
    }
    public void setAnimId(int animId) {
        AnimId = animId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }
    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getSpecialCase() {
        return specialCase;
    }
    public void setSpecialCase(String specialCase) {
        this.specialCase = specialCase;
    }

    public List<String> getAlergies() {
        return alergies;
    }
    public void setAlergies(List<String> alergies) {
        this.alergies = alergies;
    }
}

