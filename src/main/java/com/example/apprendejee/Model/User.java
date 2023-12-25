package com.example.apprendejee.Model;

public class User {
    private int id ;
    private String name;
    private String prenom;
    private String email;
    private String moddepass;
    private String role;

    public User (){

    }

    public User( String name, String prenom, String email, String moddepass, String role) {

        this.name = name;
        this.prenom = prenom;
        this.email = email;
        this.moddepass = moddepass;
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getModdepass() {
        return this.moddepass;
    }

    public void setModdepass(String moddepass) {
        this.moddepass = moddepass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
