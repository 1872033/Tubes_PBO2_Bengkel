package Dao;

import Entity.SparePart;
import Utility.DaoService;
import Utility.MySQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SparepartDaoImpl implements DaoService<SparePart> {

    @Override
    public List<SparePart> fetchAll() {
        ObservableList<SparePart> spareParts = FXCollections.observableArrayList();
        try  {
            String query = "SELECT * FROM Sparepart";

            PreparedStatement ps;
            ps= MySQLConnection.createConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSparepart= rs.getInt("idSparePart");
                String nama=rs.getString("Nama");
                int hargabeli= rs.getInt("HargaBeli");
                int hargajual= rs.getInt("HargaJual");
                int stok= rs.getInt("Stok");
                SparePart sp = new SparePart(idSparepart,nama,hargabeli,hargajual,stok);
                spareParts.add(sp);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(spareParts);
        return spareParts;
    }

    @Override
    public int addData(SparePart object) {
        int result =0;
        try  {
            String query = "INSERT INTO sparepart(nama,hargabeli,hargajual,stok) VALUES (?, ?,?,?)";
            PreparedStatement ps;
            ps=MySQLConnection.createConnection().prepareStatement(query);
            ps.setString(1, object.getNamaSparepart());
            ps.setInt(2, object.getHargaBeli());
            ps.setInt(3, object.getHargaJual());
            ps.setInt(4, object.getStok());

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
    public int editData(SparePart object) {
        int result = 0;
        try {
            String query = "UPDATE sparepart SET nama=? ,hargabeli=?,hargajual=?,stok=? WHERE idSparepart=?";
            PreparedStatement ps=MySQLConnection.createConnection().prepareStatement(query);
            ps.setString(1, object.getNamaSparepart());
            ps.setInt(2, object.getHargaBeli());
            ps.setInt(3, object.getHargaJual());
            ps.setInt(4, object.getStok());
            ps.setInt(5, object.getIdSparepart());


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteData(SparePart object) {
        int result = 0;
        try  {
            String query = "DELETE FROM Sparepart WHERE idSparepart=?";
            Connection connection=MySQLConnection.createConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, object.getIdSparepart());
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
