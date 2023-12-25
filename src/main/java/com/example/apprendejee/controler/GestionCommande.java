package com.example.apprendejee.controler;

import com.example.apprendejee.DAO.Commande.CommandeImpl;
import com.example.apprendejee.DAO.Commande.ICommande;
import com.example.apprendejee.DAO.Product.IProduct;
import com.example.apprendejee.DAO.Product.ProductImpl;
import com.example.apprendejee.LingneCommande.ILigne_Commande;
import com.example.apprendejee.LingneCommande.LigneCommandeImpl;
import com.example.apprendejee.Model.Commande;
import com.example.apprendejee.Model.LigneCommande;
import com.example.apprendejee.Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/Commande", urlPatterns = "*.Commande")
public class GestionCommande extends HttpServlet {
    List<Integer> CommandeSlected = new ArrayList<>();
    ICommande MetierCommande;
    IProduct MetierProduct;

    ILigne_Commande MetierLigneCommande;
    @Override
    public void init() throws ServletException {
        MetierCommande= new CommandeImpl();
        MetierProduct=new ProductImpl();
        MetierLigneCommande=new LigneCommandeImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getServletPath();
        HttpSession session = req.getSession();
        if(action.equals("/SelectProduct.Commande")){
           String[] list = req.getParameterValues("ProductsSlected");
            int qnt ;
            double amount=0;
            for(int i= 0 ; i< list.length;i++){
                IProduct MetierProduc =new ProductImpl();

                qnt = MetierProduc.GetProductById(Integer.parseInt (req.getParameter(list[i]))).getQnt()-Integer.parseInt(req.getParameter(list[i]));
                amount += (Integer.parseInt(req.getParameter(list[i]))* MetierProduc.GetProductById(Integer.parseInt (list[i])).getPrix());
                MetierProduc.ModQntProduct(Integer.parseInt(list[i]), qnt);
                MetierCommande.SetAmountOfCommande(Integer.parseInt(req.getParameter("commande")),amount);

                MetierLigneCommande.addLigneCommande( Integer.parseInt(list[i]),Integer.parseInt(req.getParameter("commande")) , Integer.parseInt(req.getParameter(list[i])));
            }

            resp.sendRedirect("Commande.Commande");
        }
        else if(action.equals("/AddCommande.Commande")){
          int id_client= Integer.parseInt(req.getParameter("ClienCommande"));
          MetierCommande.addCommande(id_client);
          resp.sendRedirect("Commande.Commande");
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getServletPath();
        HttpSession session = req.getSession();
        List<Commande> Commandes = MetierCommande.GetAllCommande();
        List<LigneCommande> commandesSelected= MetierLigneCommande.allCommandeLigne();
        for(LigneCommande c :commandesSelected){
            CommandeSlected.add(c.getCommande_id());
        }
        session.setAttribute("CommandeSelcted",CommandeSlected);
        session.setAttribute("Commandes", Commandes);
        if(action.equals("/SelectProduct.Commande")){
            session.setAttribute("id_commande", Integer.parseInt(req.getParameter("id")));

            resp.sendRedirect("SelectProduct.jsp");
        }
        else if (action.equals("/EditCommande.Commande")){

               int id_commande =Integer.parseInt(req.getParameter("id"));
               session.setAttribute("id_commande",id_commande);
               System.out.println(MetierLigneCommande.CommandeSlected(id_commande));
               session.setAttribute("productOfCommande",  MetierLigneCommande.CommandeSlected(id_commande));
               resp.sendRedirect("CommandeFinal.jsp");

        }
        else if (action.equals("/StatusFinal.Commande")){
            MetierLigneCommande.FinalserCommande(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("Commande.Commande");
        }
        else{
            resp.sendRedirect("Welcome.jsp");
        }
    }
}
