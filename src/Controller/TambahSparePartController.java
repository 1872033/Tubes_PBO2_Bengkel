package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TambahSparePartController {
    @FXML
    private TextField txtIdSparePart;
    @FXML
    private TextField txtNamaSparePart;
    @FXML
    private TextField txtHargaBeli;
    @FXML
    private TextField txtHargaJual;
    @FXML
    private TextField txtStok;
    @FXML
    private Button btnCancel;

    @FXML
    private void actionCancelSparePart(ActionEvent actionEvent) {
    }

    @FXML
    private void actionTambahSparePart(ActionEvent actionEvent) {
        Stage stage1 = (Stage) btnCancel.getScene().getWindow();
        stage1.close();
    }
}
