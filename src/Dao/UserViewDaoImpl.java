package Dao;

import Entity.UserView;
import Utility.DaoService;
import Utility.MySQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserViewDaoImpl implements DaoService {
    @Override
    public List<UserView> fetchAll() {
        ObservableList<UserView> userViews = FXCollections.observableArrayList();
        try  {
            String query = "SELECT Kendaraan.NoPlat as Noplat, Kendaraan.JenisKendaraan as JenisKendaraan, User.Nama as nama, Reparasi.TglReparasi as tglRep, Reparasi.JenisReparasi as JenisRep\n" +
                    "FROM     Kendaraan INNER JOIN\n" +
                    "                  Reparasi ON Kendaraan.idKendaraan = Reparasi.Kendaraan_idKendaraan INNER JOIN\n" +
                    "                  SparePart ON Reparasi.idReparasi = SparePart.Reparasi_idReparasi INNER JOIN\n" +
                    "                  User ON Kendaraan.User_idUser = User.idUser AND Reparasi.User_idUser = User.idUser";

            PreparedStatement ps;
            ps= MySQLConnection.createConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String NoPlat=rs.getString("Noplat");
                String jenisKendaraan=rs.getString("JenisKendaraan");
                String Nama=rs.getString("nama");
                String TglRep=rs.getString("tglRep");
                String JenRep=rs.getString("JenisRep");

                UserView s = new UserView(NoPlat,jenisKendaraan,Nama,TglRep,JenRep);
                userViews.add(s);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(userViews);
        return userViews;
    }

    @Override
    public int addData(Object object) {
        return 0;
    }

    @Override
    public int editData(Object object) {
        return 0;
    }

    @Override
    public int deleteData(Object object) {
        return 0;
    }
}
