package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TambahKendaraanController {
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
}
