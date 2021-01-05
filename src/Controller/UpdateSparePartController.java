package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateSparePartController {


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
    private ComboBox cmbBoxIdRep;
    @FXML
    private Button btnCancel;


    @FXML
    private void actionUpdateSparePart(ActionEvent actionEvent) {
    }

    @FXML
    private void actionCancelSparePart(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
