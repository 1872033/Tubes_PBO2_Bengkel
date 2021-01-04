package Dao;

import Entity.*;
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

public class DetailreparasiDaoImpl implements DaoService<DetailReparasi> {
    @Override
    public List<DetailReparasi> fetchAll() {
        ObservableList<DetailReparasi> detailreparasis = FXCollections.observableArrayList();
        try  {
            String query = "SELECT * FROM DetailReparasi " +
                    "FULL OUTER JOIN User ON DetailReparasi.Reparasi_idReparasi= Reparasi.idReparasi" +
                    "FULL OUTER JOIN User ON DetailReparasi.SparePart_idSparepart= SparePart.idSparePart"+
                    "FULL OUTER JOIN User ON DetailReparasi.Jasa_idJasa= Jasa.idJasa";

            PreparedStatement ps;
            ps= MySQLConnection.createConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int jumlah=rs.getInt("Jumlah");
                int hargacustomer=rs.getInt("HargaCustomer");

                int idReparasi= rs.getInt("idReparasi");

                int idSparePart=rs.getInt("idSparePart");
                SparePart sp1=new SparePart(idSparePart,"","","");

                int idjasa=rs.getInt("idJasa");
                Jasa j1=new Jasa(idjasa,"","","");

                DetailReparasi dr = new DetailReparasi(idReparasi,jumlah,hargacustomer,j1,sp1);
                detailreparasis.add(dr);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(detailreparasis);
        return detailreparasis;
    }

    @Override
    public int addData(DetailReparasi object) {
        int result =0;
        try  {
            String query = "INSERT INTO detailreparasi(jumlah,hargacustomer) VALUES (?, ?)";
            PreparedStatement ps;
            ps=MySQLConnection.createConnection().prepareStatement(query);
            ps.setInt(1, object.getJumlah());
            ps.setInt(2, object.getHargaCustomer());

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
    public int editData(DetailReparasi object) {
        int result = 0;
        try {
            String query = "UPDATE detailreparasi SET jumlah=? ,hargacustomer=?  WHERE idReparasi=?";
            PreparedStatement ps=MySQLConnection.createConnection().prepareStatement(query);
            ps.setInt(1, object.getJumlah());
            ps.setInt(2, object.getHargaCustomer());
            ps.setInt(3, object.getIdReparasi());


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteData(DetailReparasi object) {
        int result = 0;
        try  {
            String query = "DELETE FROM detailreparasi WHERE idReparasi=?";
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
