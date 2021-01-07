package Controller;

import Dao.KendaraanDaoImpl;
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

public class TambahReparasiCOntroller implements Initializable {

    @FXML
    private TextField txtTglReparasi;
    @FXML
    private TextField txtJenisReparasi;
    @FXML
    private ComboBox<User> CmbBoxIdUser;
    @FXML
    private Button btnCancel;
    private MenuPageController controller;

    public void setController(MenuPageController controller) {
        this.controller = controller;
    }

    @FXML
    private void actionTambahReparasi(ActionEvent actionEvent) {
        Reparasi reparasi = new Reparasi();
        reparasi.setJenisreparasi(txtJenisReparasi.getText());
        reparasi.setTglreparasi(txtTglReparasi.getText());
        User user = new User();
        user.setIdUser(CmbBoxIdUser.getValue().getIdUser());
        reparasi.setIdPemilik(user);
        controller.getReparasiDAO().addData(reparasi);
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
        KendaraanDaoImpl cDAO = new KendaraanDaoImpl();
        ObservableList<Kendaraan> kList = (ObservableList<Kendaraan>) cDAO.fetchAll();

        UserDaoImpl uDAO = new UserDaoImpl();
        ObservableList<User> uList = (ObservableList<User>) uDAO.fetchAll();
        CmbBoxIdUser.setItems(uList);

    }
}
