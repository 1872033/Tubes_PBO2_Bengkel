package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateReparasiController {
    @FXML
    private TextField txtIdReparasi;
    @FXML
    private TextField txtJenisReparasi;
    @FXML
    private ComboBox CmbBoxIdKendaraan;
    @FXML
    private ComboBox CmbBoxIdUser;
    @FXML
    private TextField txtTglReparasi;
    @FXML
    private Button btnCancel;


    @FXML
    private void actionUpdateReparasi(ActionEvent actionEvent) {
    }

    @FXML
    private void actionCancelReparasi(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
