package com.example.apprendejee.DAO.Commande;

import com.example.apprendejee.Model.Commande;

import java.util.List;

public interface ICommande {
    public Commande GetCommandeById(int id_commande);
    public List<Commande> GetAllCommande();
    public void addCommande(int id_client);
    public void SetAmountOfCommande(int id_commande,double amount);

}
