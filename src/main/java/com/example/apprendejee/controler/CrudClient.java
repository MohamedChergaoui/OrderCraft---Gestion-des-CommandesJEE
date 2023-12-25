package com.example.apprendejee.controler;

import com.example.apprendejee.DAO.Clien.ClientImpl;
import com.example.apprendejee.DAO.Clien.IClient;
import com.example.apprendejee.Model.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "/Client", urlPatterns = "*.Client")
public class CrudClient extends HttpServlet {
    IClient MetierClient;
    @Override
    public void init() {
        MetierClient=new ClientImpl();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action =req.getServletPath();
        String name= req.getParameter("nom");
        String prenom= req.getParameter("Prenom");
        String adresse= req.getParameter("adresse");
        String tele= req.getParameter("tele");

        if(action.equals("/AddClient.Client")){

             Client cli = new Client(name,  prenom,  adresse, tele);
            MetierClient.AddClient(cli);

            resp.sendRedirect("Client.Client");

        }

        else if(action.equals("/SaveClient.Client")){

            int id = Integer.parseInt(req.getParameter("id"));

            Client client =MetierClient.GetClientById(id);
            client.setName(name);
            client.setPrenom(prenom);
            client.setAdresse(adresse);
            client.setTele(tele);


            try {
                MetierClient.ModClient(client);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            resp.sendRedirect("Client.Client");


        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getServletPath();
        HttpSession session = req.getSession();

        List<Client> Clients = MetierClient.GetAllClient();
        session.setAttribute("Clients", Clients);
        if(action.equals("/EditClient.Client")){
            int id = Integer.parseInt( req.getParameter("id"));

            Client client =MetierClient.GetClientById(id);
            System.out.println(client .getId());
            session.setAttribute("Client",client);
            resp.sendRedirect("EditClient.jsp");
        }
        else if(action.equals("/DeleteClient.Client")){
            int id = Integer.parseInt( req.getParameter("id"));
            MetierClient.DeleClient(id);
            resp.sendRedirect("Clients.Client");

        }
        else{
            System.out.println(Clients.toString());
            resp.sendRedirect("Clients.jsp");
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
