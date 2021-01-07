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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TambahKendaraanController implements Initializable {
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


    public void setController(MenuPageController controller) {
        this.controller = controller;
    }

    @FXML
    private void actionTambahKendaraan(ActionEvent actionEvent) {
        Kendaraan kendaraan = new Kendaraan();
        kendaraan.setJeniskendaraan(txtJenisKendaraan.getText());
        kendaraan.setNostnk(txtNoSTNK.getText());
        kendaraan.setNoPlat(txtNoPlat.getText());
        User user = new User();
        user.setIdUser(CmbBoxUser.getValue().getIdUser());
        kendaraan.setIdUser(user);
        controller.getKendaraanDAO().addData(kendaraan);
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
        UserDaoImpl uDao = new UserDaoImpl();
        ObservableList<User> uList = (ObservableList<User>) uDao.fetchAll();
        CmbBoxUser.setItems(uList);
    }
}
