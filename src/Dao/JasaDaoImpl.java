package Dao;

import Entity.Jasa;
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
import java.util.List;

public class JasaDaoImpl implements DaoService<Jasa> {
    @Override
    public List<Jasa> fetchAll() {
        ObservableList<Jasa> jasas = FXCollections.observableArrayList();
        try  {
            String query = "SELECT * FROM Jasa";

            PreparedStatement ps;
            ps= MySQLConnection.createConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idJasa= rs.getInt("idJasa");
                String namaJasa=rs.getString("NamaJasa");
                int tarif= rs.getInt("Tarif");
                Jasa j = new Jasa(idJasa,namaJasa,tarif);
                jasas.add(j);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(jasas);
        return jasas;
    }

    @Override
    public int addData(Jasa object) {
        int result =0;
        try  {
            String query = "INSERT INTO jasa(namaJasa,tarif) VALUES (?, ?)";
            PreparedStatement ps;
            ps=MySQLConnection.createConnection().prepareStatement(query);
            ps.setString(1, object.getNamaJasa());
            ps.setInt(2, object.getTarif());

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
    public int editData(Jasa object) {
        int result = 0;
        try {
            String query = "UPDATE jasa SET namajasa=? ,tarif=? WHERE idJasa=?";
            PreparedStatement ps=MySQLConnection.createConnection().prepareStatement(query);
            ps.setString(1, object.getNamaJasa());
            ps.setInt(2, object.getTarif());
            ps.setInt(3, object.getIdJasa());


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteData(Jasa object) {
        int result = 0;
        try  {
            String query = "DELETE FROM jasa WHERE idJasa=?";
            Connection connection=MySQLConnection.createConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, object.getIdJasa());
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
