package com.example.apprendejee.DAO.Commande;

import com.example.apprendejee.DAO.Connection.SIngletonConnection;
import com.example.apprendejee.Model.Commande;
import com.example.apprendejee.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeImpl implements ICommande{
    Connection connection= SIngletonConnection.getConnection();
    Commande commande=new Commande();
    @Override
    public Commande GetCommandeById(int id_commande) {
        return null;
    }

    @Override
    public List<Commande> GetAllCommande() {
        List<Commande> Commandes = new ArrayList<>();

        try{

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM commande ");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Commande commande = new Commande();
                commande.setId(rs.getInt("id"));
                commande.setId_client(rs.getInt("id_client"));
                commande.setOrder_date(rs.getDate("order_date"));
                commande.setAmount(rs.getDouble("total_amount"));
                commande.setSatusCommande(Status_Commande.valueOf(rs.getString("statuCommande")));

                Commandes.add(commande);

            }

        }
        catch (SQLException e){

            System.out.println(e);
        }
        return Commandes;
    }

    @Override
    public void SetAmountOfCommande(int id_commande, double amount) {

        String sql ="UPDATE commande  SET  total_amount = ? WHERE id = ?  ";
        try  {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, amount);
            statement.setInt(2,id_commande);

            statement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e);
        }


    }


    @Override
    public void addCommande(int id_client) {
        String sql = "INSERT INTO commande (id_client) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id_client);

            int rowsAffected = statement.executeUpdate();


        } catch (SQLException e) {

            System.out.println(e);
        }

    }
}
