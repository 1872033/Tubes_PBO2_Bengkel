package Dao;

import Entity.User;
import Utility.DaoService;
import Utility.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements DaoService <User> {
    @Override
    public List<User> fetchAll()  {
        List<User> users = new ArrayList<>();
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "SELECT * FROM user";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        User user = new User();
                        user.setIdUser(rs.getInt("idUser"));
                        user.setNama(rs.getString("Nama"));
                        user.setUsername(rs.getString("Username"));
                        user.setPassword(rs.getString("Password"));
                        users.add(user);
                    }
                }
            }
        }
        System.out.println(users);
        return users;
    }

    @Override
    public int addData(User object)  {
        int result =0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "INSERT INTO user(nama) VALUES (?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getNama());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            }
        }
        return result;
    }

    @Override
    public int editData(User object)  {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "UPDATE user SET nama=? ,password=? WHERE idUser=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getNama());
                ps.setString(2, object.getPassword());
                ps.setInt(3, object.getIdUser());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            }
        }
        return result;
    }

    @Override
    public int deleteData(User object)  {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            connection.setAutoCommit(false);
            String query = "DELETE FROM user WHERE idUser=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(3, object.getIdUser());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            }
        }
        return result;
}
