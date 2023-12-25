package com.example.apprendejee.controler;

import com.example.apprendejee.DAO.Product.IProduct;
import com.example.apprendejee.DAO.Product.ProductImpl;
import com.example.apprendejee.Model.Client;
import com.example.apprendejee.Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "/Product", urlPatterns = "*.Product")
public class CrudProduct extends HttpServlet {
    IProduct ProductMetier;
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action =req.getServletPath();
        String name= req.getParameter("name");
        String des= req.getParameter("descption");
        int qnt = Integer.parseInt(req.getParameter("Qnt"));
        double prix =Double.parseDouble(req.getParameter("prix"));

        if(action.equals("/AddProduct.Product")){

            Product prodouit = new Product(name,des,qnt,prix);
            ProductMetier.AddProduct(prodouit);

            resp.sendRedirect("Product.Product");

        }

        else if(action.equals("/SaveProduct.Product")){

            int id = Integer.parseInt(req.getParameter("id"));

            Product product =ProductMetier.GetProductById(id);
            product.setName(name);
            product.setDescriotion(des);
            product.setQnt(qnt);
            product.setPrix(prix);



            try {
                ProductMetier.ModProduct(product);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            resp.sendRedirect("Product.Product");


        }


    }

    @Override
    public void init() throws ServletException {
        ProductMetier=new ProductImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getServletPath();
        HttpSession session = req.getSession();

        List<Product> Products = ProductMetier.GetAllProduct();
        session.setAttribute("Products", Products);
        if(action.equals("/EditProduct.Product")){
            int id = Integer.parseInt( req.getParameter("id"));

            Product product =ProductMetier.GetProductById(id);

            session.setAttribute("Product",product);
            resp.sendRedirect("EditProduct.jsp");
        }
        else if(action.equals("/DeleteProduct.Product")){
            int id = Integer.parseInt( req.getParameter("id"));
            ProductMetier.DeleProduct(id);
            resp.sendRedirect("Products.Product");

        }
        else{

            resp.sendRedirect("Product.jsp");
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
