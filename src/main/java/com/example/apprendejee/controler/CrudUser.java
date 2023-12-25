package com.example.apprendejee.controler;

import com.example.apprendejee.DAO.User.IUser;
import com.example.apprendejee.DAO.User.UserImp;
import com.example.apprendejee.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "/logout", urlPatterns = "*.java")
public class CrudUser extends HttpServlet {
    private IUser MetierUser;;
    @Override
    public void init() throws ServletException {
         MetierUser = new UserImp();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getServletPath();

        if(action.equals("/AddUser.java")){
            String name= req.getParameter("nom");
            String Prenom= req.getParameter("Prenom");
            String email= req.getParameter("email");
            String password= req.getParameter("password");
            String rolle=req.getParameter("role");
            User user = new User(name,Prenom,email,password,rolle);
            MetierUser.AddUser(user);
            System.out.println("raja");
            resp.sendRedirect("user.java");

        }

        else if(action.equals("/SaveUser.java")){

            int id = Integer.parseInt(req.getParameter("id"));

            User user =MetierUser.GetUserById(id);
              user.setName(req.getParameter("nom"));
              user.setPrenom(req.getParameter("Prenom"));
              user.setEmail(req.getParameter("email"));
              user.setModdepass(req.getParameter("password"));
              user.setRole(req.getParameter("role"));
            try {
                MetierUser.ModUser(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            resp.sendRedirect("user.java");


        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getServletPath();
        HttpSession session = req.getSession();

        List<User> Users = MetierUser.GetAllUser();
        session.setAttribute("Users", Users);
         if(action.equals("/EditUser.java")){
          int id = Integer.parseInt( req.getParameter("id"));

          User user =MetierUser.GetUserById(id);
          session.setAttribute("user",user);
          resp.sendRedirect("EditUser.jsp");
      }
         else if(action.equals("/DeleteUser.java")){
             int id = Integer.parseInt( req.getParameter("id"));

             MetierUser.DeleUser(id);
             resp.sendRedirect("Users.java");

         }
         else{
        resp.sendRedirect("Users.jsp");
         }


    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
