package com.example.apprendejee.DAO.Clien;

import com.example.apprendejee.Model.User;
import com.example.apprendejee.Model.Client;

import java.sql.SQLException;
import java.util.List;

public interface IClient {
    public void AddClient(Client client);
    public void DeleClient(int idClient);
    public void ModClient(Client client) throws SQLException;
    public Client GetClientById(int  idUser );
    public List<Client> GetAllClient();
}
