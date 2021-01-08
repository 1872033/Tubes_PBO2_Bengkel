package Dao;

import Entity.User;
import Utility.DaoService;
import Utility.MySQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements DaoService <User> {
    @Override
    public List<User> fetchAll() {
        ObservableList<User> users = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM `User`";

            PreparedStatement ps;
            ps = MySQLConnection.createConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("idUser");
                String nama = rs.getString("Nama");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                User u = new User(idUser, nama, username, password);
                users.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(users);
        return users;
    }

    @Override
    public int addData(User object) {
        int result = 0;
        try {
            String query = "INSERT INTO `user` (Nama,Username,Password) VALUES (?, ?, ?)";
            PreparedStatement ps;
            ps = MySQLConnection.createConnection().prepareStatement(query);
            ps.setString(1, object.getNama());
            ps.setString(2, object.getUsername());
            ps.setString(3, object.getPassword());

            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int editData(User object) {
        int result = 0;
        try {
            String query = "UPDATE user SET Nama=? ,Username=?, Password=? WHERE idUser=?";
            PreparedStatement ps = MySQLConnection.createConnection().prepareStatement(query);
            ps.setString(1, object.getNama());
            ps.setString(2, object.getUsername());
            ps.setString(3, object.getPassword());
            ps.setInt(4, object.getIdUser());
            result=ps.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteData(User object) {
        int result = 0;
        try {
            String query = "DELETE FROM user WHERE idUser=?";
            Connection connection = MySQLConnection.createConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, object.getIdUser());
            if (ps.executeUpdate() != 0) {
                connection.commit();
                result = 1;
            } else {
                connection.rollback();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
