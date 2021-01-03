package Dao;

import Entity.Kendaraan;
import Entity.Reparasi;
import Entity.User;
import Utility.DaoService;
import Utility.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReparasiDaoImpl implements DaoService<Reparasi> {
    @Override
    public List<Reparasi> fetchAll() {
        List<Reparasi> reparasis = new ArrayList<>();
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "SELECT * FROM reparasi";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Reparasi reparasi = new Reparasi();
                        reparasi.setIdReparasi(rs.getInt("idReparasi"));
                        reparasi.setTglreparasi(rs.getDate("TglReparasi"));
                        reparasi.setJenisreparasi(rs.getString("JenisReparasi"));
                        reparasis.add(reparasi);

                        Kendaraan kendaraan = new Kendaraan();
                        kendaraan.setIdKendaraan(rs.getInt("idKendaraan"));
                        reparasis.add(kendaraan);

                        User user = new User();
                        user.setIdUser(rs.getInt("idUser"));
                        reparasis.add(user);
                    }
                }
            }
        }
        System.out.println(reparasis);
        return reparasis;
    }

    @Override
    public int addData(Reparasi object) {
        int result =0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "INSERT INTO reparasi(tglreparasi,jenisreparasi) VALUES (?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setDate(1, object.getTglreparasi());
                ps.setString(2, object.getJenisreparasi());
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
    public int editData(Reparasi object) {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "UPDATE reparasi SET tglreparasi=? ,jenisreparasi=?  WHERE idReparasi=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setDate(1, object.getTglreparasi());
                ps.setString(2, object.getJenisreparasi());
                ps.setInt(3, object.getIdReparasi());
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
    public int deleteData(Reparasi object) {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            connection.setAutoCommit(false);
            String query = "DELETE FROM reparasi WHERE idReparasi=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(3, object.getIdReparasi());
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
