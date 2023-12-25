package com.example.apprendejee.Model;

public class Product {
    private int id;
    private String name;
    private String Descriotion;
    private int Qnt ;
    private double prix;

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Product(String name, String descriotion, int qnt, double prix) {
        this.name = name;
        this.Descriotion = descriotion;
        this.Qnt = qnt;
        this.prix=prix;
    }
    public Product (){

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

    public String getDescriotion() {
        return Descriotion;
    }

    public void setDescriotion(String descriotion) {
        Descriotion = descriotion;
    }

    public int getQnt() {
        return Qnt;
    }

    public void setQnt(int qnt) {
        Qnt = qnt;
    }
}

