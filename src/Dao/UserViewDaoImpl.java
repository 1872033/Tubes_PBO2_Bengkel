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
            String query = "SELECT Kendaraan.NoPlat as Noplat, Kendaraan.JenisKendaraan as JenisKendaraan, User.Nama as nama, \n" +
                    "Reparasi.TglReparasi as tglRep, Reparasi.JenisReparasi as JenisRep \n" +
                    "FROM     SparePart INNER JOIN\n" +
                    "                  Reparasi ON SparePart.Reparasi_idReparasi = Reparasi.idReparasi INNER JOIN\n" +
                    "                  User ON Reparasi.User_idUser = User.idUser INNER JOIN\n" +
                    "                  Kendaraan ON User.idUser = Kendaraan.User_idUser";

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
