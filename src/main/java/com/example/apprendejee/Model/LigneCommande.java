package com.example.apprendejee.Model;

public class LigneCommande {
    private int id;
    private int product_id;
    private int Commande_id;
    private int Qnt;

    public LigneCommande( int product_id, int commande_id, int qnt) {

        this.product_id = product_id;
        Commande_id = commande_id;
        Qnt = qnt;
    }
    public LigneCommande(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCommande_id() {
        return Commande_id;
    }

    public void setCommande_id(int commande_id) {
        Commande_id = commande_id;
    }

    public int getQnt() {
        return Qnt;
    }

    public void setQnt(int qnt) {
        Qnt = qnt;
    }
}
