package Controller;

import Dao.KendaraanDaoImpl;
import Dao.UserDaoImpl;
import Entity.Kendaraan;
import Entity.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TambahReparasiCOntroller implements Initializable {
    @FXML
    private TextField txtIdReparasi;
    @FXML
    private TextField txtTglReparasi;
    @FXML
    private TextField txtJenisReparasi;
    @FXML
    private ComboBox CmbBoxIdKendaraan;
    @FXML
    private ComboBox CmbBoxIdUser;
    @FXML
    private Button btnCancel;

    @FXML
    private void actionTambahReparasi(ActionEvent actionEvent) {
    }

    @FXML
    private void actionCancelReparasi(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        KendaraanDaoImpl cDAO = new KendaraanDaoImpl();
        ObservableList<Kendaraan> kList = (ObservableList<Kendaraan>) cDAO.fetchAll();
        CmbBoxIdKendaraan.setItems(kList);

        UserDaoImpl uDAO = new UserDaoImpl();
        ObservableList<User> uList = (ObservableList<User>) uDAO.fetchAll();
        CmbBoxIdUser.setItems(uList);

    }
}
