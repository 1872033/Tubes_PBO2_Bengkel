package Dao;

import Entity.*;
import Utility.DaoService;
import Utility.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetailreparasiDaoImpl implements DaoService<DetailReparasi> {
    @Override
    public List<DetailReparasi> fetchAll() {
        List<DetailReparasi> detailReparasis = new ArrayList<>();
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "SELECT * FROM detailreparasi";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        DetailReparasi detailreparasi = new DetailReparasi();
                        detailreparasi.setJumlah(rs.getInt("Jumlah"));
                        detailreparasi.setHargaUCustomer(rs.getInt("HargaCustomer"));
                        detailReparasis.add(detailreparasi);

                        Reparasi reparasi = new Reparasi();
                        reparasi.setIdReparasi(rs.getInt("idReparasi"));
                        detailReparasis.add(reparasi);

                        Jasa jasa = new Jasa();
                        jasa.setIdJasa(rs.getInt("idJasa"));
                        detailReparasis.add(jasa);

                        SparePart sparePart = new SparePart();
                        sparePart.setIdSparepart(rs.getInt("idSparepart"));
                        detailReparasis.add(sparePart);
                    }
                }
            }
        }
        System.out.println(detailReparasis);
        return detailReparasis;
    }

    @Override
    public int addData(DetailReparasi object) {
        int result =0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "INSERT INTO detailreparasi(jumlah,hargacustomer) VALUES (?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getJumlah());
                ps.setInt(2, object.getHargaUCustomer());

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
    public int editData(DetailReparasi object) {
        return 0;
    }

    @Override
    public int deleteData(DetailReparasi object) {
        return 0;
    }
}
