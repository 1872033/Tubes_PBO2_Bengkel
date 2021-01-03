package Dao;

import Entity.Jasa;
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

public class JasaDaoImpl implements DaoService<Jasa> {
    @Override
    public List<Jasa> fetchAll() {
        List<Jasa> jasas = new ArrayList<>();
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "SELECT * FROM jasa";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Jasa jasa = new Jasa();
                        jasa.setIdJasa(rs.getInt("idJasa"));
                        jasa.setNamaJasa(rs.getString("NamaJasa"));
                        jasa.setTarif(rs.getInt("Tarif"));
                        jasas.add(jasa);
                    }
                }
            }
        }
        System.out.println(jasas);
        return jasas;
    }

    @Override
    public int addData(Jasa object) {
        int result =0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "INSERT INTO jasa(namajasa,tarif) VALUES (?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getNamaJasa());
                ps.setInt(2, object.getTarif());
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
    public int editData(Jasa object) {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "UPDATE jasa SET namajasa=? ,tarif=?  WHERE idJasa=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getNamaJasa());
                ps.setInt(2, object.getTarif());
                ps.setInt(3, object.getIdJasa());
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
    public int deleteData(Jasa object) {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            connection.setAutoCommit(false);
            String query = "DELETE FROM jasa WHERE idJasa=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(3, object.getIdJasa());
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
