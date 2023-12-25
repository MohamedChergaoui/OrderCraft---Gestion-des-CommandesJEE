package com.example.apprendejee.DAO.User;

import com.example.apprendejee.DAO.Connection.SIngletonConnection;
import com.example.apprendejee.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserImp implements IUser {
    Connection connection= SIngletonConnection.getConnection();
    // methode retun user for login
    @Override
    public User login(String email, String motdepasse) {
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE email=? AND motdepasse=?");
            ps.setString(1,email);
            ps.setString(2,motdepasse);
            ResultSet rs = ps.executeQuery();
            User user = new User();
            if(rs.next()){

              user.setName(rs.getString("nom"));
              user.setPrenom(rs.getString("prenom"));
              user.setEmail(rs.getString("email"));
              user.setRole(rs.getString("role"));

              return user;

            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void AddUser(User user) {
        String sql = "INSERT INTO user (nom, prenom, email, motdepasse, role) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getModdepass());
            statement.setString(5, user.getRole());

            int rowsAffected = statement.executeUpdate();


        } catch (SQLException e) {

            System.out.println(e);
        }
    }

    @Override
    public void DeleUser(int idUser) {


        try  {
            String sql = "DELETE FROM user WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idUser);


             statement.executeUpdate();


        } catch (SQLException e) {

            System.out.println(e);
        }
    }

    @Override
    public void ModUser(User user)  {

        String sql ="UPDATE user SET nom = ?, prenom = ?, email= ?,motdepasse = ? , role= ? WHERE id = ?  ";
        try  {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getModdepass());
            statement.setString(5, user.getRole());
            statement.setInt(6, user.getId());

             statement.executeUpdate();


        } catch (SQLException e) {
            System.out.println("raja");
            System.out.println(e);
        }



    }
    @Override
    public User GetUserById(int  idUser ){
        User user = new User();
        try{

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE id=? ");
            ps.setInt(1,idUser);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setModdepass(rs.getString("motdepasse"));
                user.setRole(rs.getString("role"));




            }
        }
        catch (SQLException e){

            System.out.println(e);
        }
        return user;
    }

    @Override
    public List<User> GetAllUser(){
        List<User> userList = new ArrayList<>();
        try{

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user ");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                userList.add(user);



            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return userList;
    }
}
