package com.example.apprendejee.DAO.Product;

import com.example.apprendejee.DAO.Connection.SIngletonConnection;
import com.example.apprendejee.Model.Client;
import com.example.apprendejee.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements IProduct {
    Connection connection= SIngletonConnection.getConnection();
    @Override
    public void AddProduct(Product Product) {
        String sql = "INSERT INTO produit (name, descrption, Qnt,prix) VALUES (?, ?, ?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, Product.getName());
            statement.setString(2, Product.getDescriotion());
            statement.setInt(3, Product.getQnt());
            statement.setDouble(4,Product.getPrix());
            int rowsAffected = statement.executeUpdate();


        } catch (SQLException e) {

            System.out.println(e);
        }
    }

    @Override
    public void DeleProduct(int idProduct) {
        try  {
            String sql = "DELETE FROM produit WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idProduct);
            statement.executeUpdate();


        } catch (SQLException e) {

            System.out.println(e);
        }
    }

    @Override
    public void ModProduct(Product product) throws SQLException {
        String sql ="UPDATE produit SET name = ?, descrption = ?, Qnt= ? ,prix=? WHERE id = ?  ";
        try  {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescriotion());
            statement.setInt(3, product.getQnt());
            statement.setDouble(4,product.getPrix());
            statement.setInt(5, product.getId());
            statement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e);
        }

    }

    @Override
    public Product GetProductById(int idProduct) {
        Product product = new Product();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM produit WHERE id=? ");
            ps.setInt(1,idProduct);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescriotion(rs.getString("descrption"));
                product.setQnt(rs.getInt("Qnt"));
                product.setPrix(rs.getDouble("prix"));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return product;
    }

    @Override
    public List<Product> GetAllProduct() {
        List<Product> Products = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM produit ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescriotion(rs.getString("descrption"));
                product.setQnt(rs.getInt("Qnt"));
                product.setPrix(rs.getDouble("prix"));
                Products.add(product);

            }

        }
        catch (SQLException e){

            System.out.println(e);
        }
        return Products;
    }

    @Override
    public void ModQntProduct(int id_product, int QntCommande) {
        String sql ="UPDATE produit SET  Qnt= ? WHERE id = ?  ";
        try  {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, QntCommande);
            statement.setInt(2,id_product);

            statement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e);
        }


    }
}
