package com.example.apprendejee.LingneCommande;

import com.example.apprendejee.Model.LigneCommande;
import com.example.apprendejee.Model.Product;

import java.util.List;

public interface ILigne_Commande {
    public List<Product> CommandeSlected(int id_commande);
    public List<LigneCommande> allCommandeLigne();
    public void  addLigneCommande(int id_product , int id_commande,int qnt);
    public void FinalserCommande(int id_commande);
}
