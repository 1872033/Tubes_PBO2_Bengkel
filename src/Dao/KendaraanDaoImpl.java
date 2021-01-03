package Dao;

import Entity.Kendaraan;
import Entity.User;
import Utility.DaoService;
import Utility.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KendaraanDaoImpl implements DaoService<Kendaraan> {
    @Override
    public List<Kendaraan> fetchAll() {
        List<Kendaraan> kendaraans = new ArrayList<>();
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "SELECT * FROM kendaraan";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Kendaraan kendaraan = new Kendaraan();
                        kendaraan.setIdKendaraan(rs.getInt("idKendaraan"));
                        kendaraan.setJeniskendaraan(rs.getString("JenisKendaraan"));
                        kendaraan.setNostnk(rs.getInt("Nostnk"));
                        kendaraan.setNoPlat(rs.getInt("Noplat"));
                        kendaraans.add(kendaraan);

                        User user = new User();
                        user.setIdUser(rs.getInt("idUser"));
                        kendaraans.add(user);
                    }
                }
            }
        }
        System.out.println(kendaraans);
        return kendaraans;
    }

    @Override
    public int addData(Kendaraan object)  {
        int result =0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "INSERT INTO kendaraan(jeniskendaraan,nostnk,noplat) VALUES (?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getJeniskendaraan());
                ps.setInt(2, object.getNostnk());
                ps.setInt(3, object.getNoPlat());

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
    public int editData(Kendaraan object)  {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "UPDATE kendaraan SET jeniskendaraan=? ,nostnk=? ,noplat=? WHERE idKendaraan=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getJeniskendaraan());
                ps.setInt(2, object.getNostnk());
                ps.setInt(3, object.getNoPlat());
                ps.setInt(4, object.getIdKendaraan());
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
    public int deleteData(Kendaraan object)  {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            connection.setAutoCommit(false);
            String query = "DELETE FROM kendaraan WHERE idKendaraan=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(4, object.getIdKendaraan());
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
}
