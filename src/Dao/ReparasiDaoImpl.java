package Dao;

import Entity.Reparasi;
import Utility.DaoService;
import Utility.MySQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReparasiDaoImpl implements DaoService<Reparasi> {
    @Override
    public List<Reparasi> fetchAll() {
        ObservableList<Reparasi> reparasis = FXCollections.observableArrayList();
        try  {
            String query = "SELECT \n" +
                    "Reparasi.idReparasi, Kendaraan.idKendaraan as idKen, \n" +
                    "User.Nama as namaPemilik, Reparasi.TglReparasi, Reparasi.JenisReparasi\n" +
                    "FROM   Kendaraan INNER JOIN\n" +
                    "\tReparasi ON Kendaraan.idKendaraan = Reparasi.Kendaraan_idKendaraan INNER JOIN\n" +
                    "\tSparePart ON Reparasi.idReparasi = SparePart.Reparasi_idReparasi INNER JOIN User ON Kendaraan.User_idUser = User.idUser AND Reparasi.User_idUser = User.idUser";

            PreparedStatement ps;
            ps= MySQLConnection.createConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idReparasi= rs.getInt("idReparasi");
                String tglreparasi=rs.getString("tglreparasi");
                String jenisreparasi=rs.getString("jenisReparasi");
                String idKendaraan=rs.getString("idKen");
                String namaPem=rs.getString("namaPemilik");

                Reparasi r = new Reparasi(idReparasi,tglreparasi,jenisreparasi,idKendaraan,namaPem);
                reparasis.add(r);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(reparasis);
        return reparasis;
    }

    @Override
    public int addData(Reparasi object) {
        int result =0;
        try  {
            String query = "INSERT INTO reparasi(tglreparasi,jenisreparasi) VALUES (?, ?)";
            PreparedStatement ps;
            ps=MySQLConnection.createConnection().prepareStatement(query);
            ps.setString(1, object.getTglreparasi());
            ps.setString(2, object.getJenisreparasi());

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
    public int editData(Reparasi object) {
        int result = 0;
        try {
            String query = "UPDATE reparasi SET tglreparasi=? ,jenisreparasi=?  WHERE idReparasi=?";
            PreparedStatement ps=MySQLConnection.createConnection().prepareStatement(query);
            ps.setString(1,  object.getTglreparasi());
            ps.setString(2, object.getJenisreparasi());
            ps.setInt(3, object.getIdReparasi());


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteData(Reparasi object) {
        int result = 0;
        try  {
            String query = "DELETE FROM reparasi WHERE idReparasi=?";
            Connection connection=MySQLConnection.createConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, object.getIdReparasi());
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
