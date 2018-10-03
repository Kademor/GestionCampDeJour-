package com.example.a1555108.gestioncampdejour.Classes;

public class CamperList {

    private int id;
    private String firstName;
    private String lastName;
    private boolean present;

    public CamperList(int _id, String _firstName, String _lastName){
        id= _id;
        firstName = _firstName;
        lastName = _lastName;
    }

    public int getId(){return id;}
    public void setId(int id) {
        this.id = id;
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

    public void setPresent(boolean present) {
        this.present = present;
    }
    public  boolean getPresent(){
        return present;
    }
}
