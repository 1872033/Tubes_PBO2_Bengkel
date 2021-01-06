package Controller;

import Dao.UserDaoImpl;
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

public class TambahKendaraanController implements Initializable {
    @FXML
    private TextField txtIdKendaraan;
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

    @FXML
    private void actionTambahKendaraan(ActionEvent actionEvent) {
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
