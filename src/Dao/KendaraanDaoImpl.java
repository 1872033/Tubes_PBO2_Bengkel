package Dao;

import Entity.Kendaraan;
import Entity.User;
import Utility.DaoService;
import Utility.MySQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KendaraanDaoImpl implements DaoService<Kendaraan> {
    @Override
    public List<Kendaraan> fetchAll() {
        ObservableList<Kendaraan> kendaraans = FXCollections.observableArrayList();
        try  {
            String query = "SELECT Kendaraan.idKendaraan, Kendaraan.JenisKendaraan, User.Nama as nama, Kendaraan.NoPlat, Kendaraan.NoSTNK\n" +
                    "FROM     Kendaraan INNER JOIN\n" +
                    "                  Reparasi ON Kendaraan.idKendaraan = Reparasi.Kendaraan_idKendaraan INNER JOIN\n" +
                    "                  SparePart ON Reparasi.idReparasi = SparePart.Reparasi_idReparasi INNER JOIN\n" +
                    "                  User ON Kendaraan.User_idUser = User.idUser AND Reparasi.User_idUser = User.idUser";

            PreparedStatement ps;
            ps= MySQLConnection.createConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idKendaraan= rs.getInt("idKendaraan");
                String jenisKendaraan=rs.getString("JenisKendaraan");
                String NoSTNK=rs.getString("Nostnk");
                String NoPlat=rs.getString("Noplat");
                String Nama=rs.getString("nama");
                Kendaraan k = new Kendaraan(idKendaraan,jenisKendaraan,NoSTNK,NoPlat,Nama);
                kendaraans.add(k);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(kendaraans);
        return kendaraans;
    }

    @Override
    public int addData(Kendaraan object)  {
        int result =0;
        try  {
            String query = "INSERT INTO kendaraan(jeniskendaraan,nostnk,noplat) VALUES (?, ?, ?)";
            PreparedStatement ps;
            ps=MySQLConnection.createConnection().prepareStatement(query);
            ps.setString(1, object.getJeniskendaraan());
            ps.setString(2, object.getNostnk());
            ps.setString(3, object.getNoPlat());
            result=ps.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int editData(Kendaraan object) {
        int result = 0;
        try {
            String query = "UPDATE kendaraan SET jeniskendaraan=? ,nostnk=? ,noplat=? WHERE idKendaraan=?";
            PreparedStatement ps=MySQLConnection.createConnection().prepareStatement(query);
            ps.setString(1, object.getJeniskendaraan());
            ps.setString(2, object.getNostnk());
            ps.setString(3, object.getNoPlat());
            ps.setInt(4, object.getIdKendaraan());


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }


        @Override
    public int deleteData(Kendaraan object)  {
        int result = 0;
        try  {
            String query = "DELETE FROM kendaraan WHERE idKendaraan=?";
            Connection connection=MySQLConnection.createConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdKendaraan());
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
