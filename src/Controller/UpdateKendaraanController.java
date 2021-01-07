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
    private ComboBox<User> CmbBoxUser;
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
        KendaraanDaoImpl kDAO = new KendaraanDaoImpl();
        kendaraan.setJeniskendaraan(txtJenisKendaraan.getText().trim());
        kendaraan.setNostnk(txtNoSTNK.getText().trim());
        kendaraan.setNoPlat(txtNoPlat.getText().trim());
        User user = new User();
        user.setIdUser(CmbBoxUser.getValue().getIdUser());
        kendaraan.setIdUser(user);

        controller.getKendaraanDAO().editData(kendaraan);
        controller.kList.clear();
        controller.kList.addAll(controller.getKendaraanDAO().fetchAll());

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
