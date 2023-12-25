package com.example.apprendejee.Model;

import com.example.apprendejee.DAO.Commande.Status_Commande;

import java.util.Date;

public class Commande {
    private int id;
    private  int id_client;
    private Date  order_date;
    private Double amount;
    private Status_Commande SatusCommande;

    public Status_Commande getSatusCommande() {
        return SatusCommande;
    }

    public void setSatusCommande(Status_Commande satusCommande) {
        SatusCommande = satusCommande;
    }


    public Commande (){};

    public Commande( int id_client, Date order_date, Double amount) {

        this.id_client = id_client;
        this.order_date = order_date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }




}
