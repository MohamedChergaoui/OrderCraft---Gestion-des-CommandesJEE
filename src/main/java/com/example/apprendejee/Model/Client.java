package com.example.apprendejee.Model;

import com.example.apprendejee.DAO.Clien.IClient;

public class Client  {
    private int id;
    private String name;
    private String prenom;
    private String adresse;

    public String getTele() {
        return Tele;
    }

    public void setTele(String tele) {
        Tele = tele;
    }

    private String Tele;
    public Client (){

    }

    public Client(String name, String prenom, String adresse, String tele) {
        this.id = id;
        this.name = name;
        this.prenom = prenom;
        this.adresse = adresse;
        this.Tele=tele;

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
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


}
