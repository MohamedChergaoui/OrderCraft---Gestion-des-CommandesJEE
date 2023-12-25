package com.example.apprendejee.LingneCommande;

import com.example.apprendejee.DAO.Connection.SIngletonConnection;
import com.example.apprendejee.DAO.Product.IProduct;
import com.example.apprendejee.DAO.Product.ProductImpl;
import com.example.apprendejee.Model.LigneCommande;
import com.example.apprendejee.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LigneCommandeImpl implements ILigne_Commande{
    Connection connection= SIngletonConnection.getConnection();
    @Override
    public List<Product> CommandeSlected(int id_commande) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.* FROM produit p " +
                "JOIN product_commande cp ON p.id = cp.productId" +
                " Where  cp.commande_id  = ?";



        try ( PreparedStatement statement = connection.prepareStatement(sql) )
              {
                  statement.setInt(1, id_commande);
                  ResultSet resultSet = statement.executeQuery() ;
                while (resultSet.next()) {
                    int productId = resultSet.getInt("id");
                    IProduct MetierProduct = new ProductImpl();
                    System.out.println("raja");
                    Product product =  MetierProduct.GetProductById(productId);
                    products.add(product);
                }
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        return products;
    }

    @Override
    public void addLigneCommande(int id_product , int id_commande,int qnt) {
        String sql = "INSERT INTO product_commande (productId,commande_id,quantity) VALUES (?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_product);
            statement.setInt(2, id_commande);
            statement.setInt(3,qnt);
            int rowsAffected = statement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public List<LigneCommande>  allCommandeLigne() {
        List<LigneCommande> CommandeSlected = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM product_commande ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LigneCommande lgnCommande = new LigneCommande();
                lgnCommande.setId(rs.getInt("product_commande_id"));
                lgnCommande.setCommande_id(rs.getInt("commande_id"));
                lgnCommande.setProduct_id(rs.getInt("productId"));
                lgnCommande.setQnt(rs.getInt("quantity"));
                CommandeSlected.add(lgnCommande);

            }

        }
        catch (SQLException e){

            System.out.println(e);
        }
        return CommandeSlected;
    }

    @Override
    public void FinalserCommande(int id_commande) {
        String sql ="UPDATE commande  SET  statuCommande = ? WHERE id = ?  ";
        try  {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "Complet");
            statement.setInt(2,id_commande);

            statement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e);
        }
    }
}
