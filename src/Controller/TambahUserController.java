package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TambahUserController {
    @FXML
    private TextField txtIdUser;
    @FXML
    private TextField txtNamaUser;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConfirmPassword;
    @FXML
    private Button btnCancel;

    @FXML
    private void actionTambahUser(ActionEvent actionEvent) {

    }

    @FXML
    private void actionCancelUser(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
