package com.example.apprendejee.DAO.Clien;

import com.example.apprendejee.DAO.Connection.SIngletonConnection;
import com.example.apprendejee.Model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientImpl implements IClient {

    Connection connection= SIngletonConnection.getConnection();
    @Override
    public void AddClient(Client client) {
        String sql = "INSERT INTO client (name, prenom, adresse, tele) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getPrenom());
            statement.setString(3, client.getAdresse());
            statement.setString(4, client.getTele());


            int rowsAffected = statement.executeUpdate();


        } catch (SQLException e) {

            System.out.println(e);
        }
    }

    @Override
    public void DeleClient(int idClient) {
        try  {
            String sql = "DELETE FROM client WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idClient);


            statement.executeUpdate();


        } catch (SQLException e) {

            System.out.println(e);
        }

    }

    @Override
    public void ModClient(Client client) throws SQLException {
        String sql ="UPDATE client SET name = ?, prenom = ?, adresse= ?,tele = ?  WHERE id = ?  ";
        try  {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, client.getName());
            statement.setString(2, client.getPrenom());
            statement.setString(3, client.getAdresse());
            statement.setString(4, client.getTele());
            statement.setInt(5,client.getId());

            statement.executeUpdate();


        } catch (SQLException e) {

            System.out.println(e);
        }

    }

    @Override
    public Client GetClientById(int idClinet) {
        Client client = new Client();

        try{

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM client WHERE id=? ");
            ps.setInt(1,idClinet);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setPrenom(rs.getString("prenom"));
                client.setAdresse(rs.getString("adresse"));
                client.setTele(rs.getString("tele"));


            }

        }
        catch (SQLException e){

            System.out.println(e);
        }
        return client;
    }

    @Override
    public List<Client> GetAllClient() {
        List<Client> Clients = new ArrayList<>();

        try{

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM client ");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setPrenom(rs.getString("prenom"));
                client.setAdresse(rs.getString("adresse"));
                client.setTele(rs.getString("tele"));
                Clients.add(client);

            }
        }
        catch (SQLException e){

            System.out.println(e);
        }
        return Clients;
    }
}
