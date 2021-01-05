package Controller;

import Bengkel_Anthony_Ray_Ronaldo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

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
    private void actionCancelSparePart(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
        FXMLLoader Login=new FXMLLoader();
        Login.setLocation(Main.class.getResource("../View/SparePartPage.fxml"));
        Stage dialogStage = new Stage();
        VBox l =Login.load();
        dialogStage.setScene(new Scene(l));
        dialogStage.show();
    }

    @FXML
    private void actionTambahSparePart(ActionEvent actionEvent) {

    }
}
