package Controller;

import Dao.KendaraanDaoImpl;
import Dao.ReparasiDaoImpl;
import Dao.UserDaoImpl;
import Entity.Kendaraan;
import Entity.Reparasi;
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

public class UpdateReparasiController implements Initializable {

    @FXML
    private TextField txtJenisReparasi;
    @FXML
    private ComboBox<Kendaraan> CmbBoxIdKendaraan;
    @FXML
    private ComboBox<User> CmbBoxIdUser;
    @FXML
    private TextField txtTglReparasi;
    @FXML
    private Button btnCancel;

    public MenuPageController controller;

    public Reparasi reparasi;

    public void setController(MenuPageController controller){
        this.controller=controller;
        txtJenisReparasi.setText(String.valueOf(controller.r.getJenisreparasi()));
        txtTglReparasi.setText(String.valueOf(controller.r.getTglreparasi()));
        UserDaoImpl uDao = new UserDaoImpl();
        ObservableList<User> uList = (ObservableList<User>) uDao.fetchAll();
        CmbBoxIdUser.setItems(uList);
        KendaraanDaoImpl kDao = new KendaraanDaoImpl();
        ObservableList<Kendaraan> kList = (ObservableList<Kendaraan>) kDao.fetchAll();
        CmbBoxIdKendaraan.setItems(kList);
        reparasi=controller.r;
    }


    @FXML
    private void actionUpdateReparasi(ActionEvent actionEvent) {
        reparasi.setTglreparasi(txtTglReparasi.getText().trim());
        reparasi.setJenisreparasi(txtJenisReparasi.getText().trim());

        User user = new User();
        user.setIdUser(CmbBoxIdUser.getValue().getIdUser());
        reparasi.setIdPemilik(user);

        Kendaraan kendaraan = new Kendaraan();
        kendaraan.setIdKendaraan(CmbBoxIdKendaraan.getValue().getIdKendaraan());
        reparasi.setIdKendaraan(kendaraan);

        controller.getReparasiDAO().editData(reparasi);
        controller.rList.clear();
        controller.rList.addAll(controller.getReparasiDAO().fetchAll());
    }

    @FXML
    private void actionCancelReparasi(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
