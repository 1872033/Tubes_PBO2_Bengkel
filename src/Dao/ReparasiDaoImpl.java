package Dao;

import Entity.Kendaraan;
import Entity.Reparasi;
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
import java.util.Date;
import java.util.List;

public class ReparasiDaoImpl implements DaoService<Reparasi> {
    @Override
    public List<Reparasi> fetchAll() {
        ObservableList<Reparasi> reparasis = FXCollections.observableArrayList();
        try  {
            String query = "SELECT * FROM Reparasi " +
                    "FULL OUTER JOIN User ON Reparasi.User_idUser= User.idUser" +
                    "FULL OUTER JOIN User ON Reparasi.Kendaraan_idKendaraan= User.idKendaraan";

            PreparedStatement ps;
            ps= MySQLConnection.createConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idReparasi= rs.getInt("idReparasi");
                Date tglreparasi=rs.getDate("tglreparasi");
                String jenisreparasi=rs.getString("jenisReparasi");

                int idUser=rs.getInt("idUser");
                User u1=new User(idUser,"","","");

                int idKendaraan=rs.getInt("idKendaraan");
                Kendaraan k1=new Kendaraan(idKendaraan,"","","");

                Reparasi r = new Reparasi(idReparasi,tglreparasi,jenisreparasi,u1,k1);
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
            ps.setDate(1, object.getTglreparasi());
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
            ps.setDate(1, object.getTglreparasi());
            ps.setString(2, object.getJenisreparasi());
            ps.setInt(4, object.getIdReparasi());


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
