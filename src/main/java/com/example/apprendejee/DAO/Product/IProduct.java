package com.example.apprendejee.DAO.Product;

import com.example.apprendejee.Model.Client;
import com.example.apprendejee.Model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    public void AddProduct(Product Product);
    public void DeleProduct(int idProduct);
    public void ModProduct(Product product) throws SQLException;
    public Product GetProductById(int  idProduct );
    public List<Product> GetAllProduct();
    public void ModQntProduct(int id_product , int QntCommande);
}
