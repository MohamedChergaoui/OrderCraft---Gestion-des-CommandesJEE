package com.example.apprendejee.DAO.User;

import com.example.apprendejee.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUser {
    public User login(String email , String motdepasse);
    public void AddUser(User user);
    public void DeleUser(int idUser);
    public void ModUser(User user) throws SQLException;
    public User GetUserById(int  idUser );
    public List<User> GetAllUser();



}
