package Dao;

import Entity.Jasa;
import Entity.SparePart;
import Utility.DaoService;
import Utility.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SparepartDaoImpl implements DaoService<SparePart> {

    @Override
    public List<SparePart> fetchAll() {
        List<SparePart> spareparts = new ArrayList<>();
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "SELECT * FROM sparepart";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        SparePart sparepart = new SparePart();
                        sparepart.setIdSparepart(rs.getInt("idSparepart"));
                        sparepart.setNamaSparepart(rs.getString("Nama"));
                        sparepart.setHargaBeli(rs.getInt("HargaBeli"));
                        sparepart.setHargaJual(rs.getInt("HargaJual"));
                        sparepart.setStok(rs.getInt("Stok"));
                        spareparts.add(sparepart);
                    }
                }
            }
        }
        System.out.println(spareparts);
        return spareparts;
    }

    @Override
    public int addData(SparePart object) {
        int result =0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "INSERT INTO sparepart(nama,hargabeli,hargajual,stok) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getNamaSparepart());
                ps.setInt(2, object.getHargaBeli());
                ps.setInt(3, object.getHargaJual());
                ps.setInt(4, object.getStok());

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
    public int editData(SparePart object) {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "UPDATE sparepart SET nama=? ,hargabeli=?,hargajual=?,stok=? WHERE idSparepart=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getNamaSparepart());
                ps.setInt(2, object.getHargaBeli());
                ps.setInt(3, object.getHargaJual());
                ps.setInt(4, object.getStok());
                ps.setInt(5, object.getIdSparepart());


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
    public int deleteData(SparePart object) {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            connection.setAutoCommit(false);
            String query = "DELETE FROM sparepart WHERE idSparepart=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(5, object.getIdSparepart());
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
