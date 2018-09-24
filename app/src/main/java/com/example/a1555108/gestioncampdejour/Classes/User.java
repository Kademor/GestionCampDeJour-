package com.example.a1555108.gestioncampdejour.Classes;

public class User {

    private String firstName;
    private String lastName;
    private String campName;
    private String password;

    public User(String _firstname, String _lastName, String _campName, String _password){
        this.firstName = _firstname;
        this.lastName = _lastName;
        this.campName = _campName;
        this.password = _password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCampName() {
        return campName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }
}
