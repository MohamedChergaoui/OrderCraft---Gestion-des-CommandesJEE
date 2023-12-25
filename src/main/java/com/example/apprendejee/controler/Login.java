package com.example.apprendejee.controler;

import java.io.*;

import com.example.apprendejee.DAO.User.IUser;
import com.example.apprendejee.DAO.User.UserImp;
import com.example.apprendejee.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "/login", urlPatterns = "*.do")
public class Login extends HttpServlet {
    private IUser MetierUser;;

    public void init() {

        MetierUser=  new UserImp ();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String action =request.getServletPath();

       String email = request.getParameter("email");
       String password=request.getParameter("motdepasse");
       HttpSession session = request.getSession();
       User user = MetierUser.login(email,password);
       if(action.equals("/login.do")) {
           if (user != null) {
               String name = user.getName();
               String role = user.getRole();
               session.setAttribute("name", name);
               session.setAttribute("role", role);
               response.sendRedirect("Commande.Commande");
           } else {

               response.sendRedirect("Login.jsp");
           }
       }
       else if (action.equals("/logout.do")){
           session.removeAttribute("name");
           session.removeAttribute("role");

           response.sendRedirect("Login.jsp");


       }
       System.out.println(action);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    public void destroy() {
    }
}