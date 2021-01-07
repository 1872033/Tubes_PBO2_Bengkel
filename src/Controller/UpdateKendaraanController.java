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

public class UpdateKendaraanController implements Initializable {

    @FXML
    private TextField txtJenisKendaraan;
    @FXML
    private TextField txtNoSTNK;
    @FXML
    private TextField txtNoPlat;
    @FXML
    private ComboBox CmbBoxUser;
    @FXML
    private Button btnCancel;

    private MenuPageController controller;

    public Kendaraan kendaraan;

    public void setController(MenuPageController controller) {
        this.controller = controller;
        txtJenisKendaraan.setText(String.valueOf(controller.k.getJeniskendaraan()));
        txtNoPlat.setText(String.valueOf(controller.k.getNoPlat()));
        txtNoSTNK.setText(String.valueOf(controller.k.getNostnk()));
        UserDaoImpl uDao = new UserDaoImpl();
        ObservableList<User> uList = (ObservableList<User>) uDao.fetchAll();
        CmbBoxUser.setItems(uList);
        kendaraan = controller.k;
    }


    @FXML
    private void actionUpdateKendaraan(ActionEvent actionEvent) {

    }

    @FXML
    private void actionCancelKendaraan(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
