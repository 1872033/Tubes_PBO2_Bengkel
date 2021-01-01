package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

//ketika record pada tabel view user pada menu page dipilih tombol update aktif
//jika hanya tombol + saja yang diklik pada menu tombol update tidak aktif

public class TambahUpdateUserController {
    @FXML
    private TextField txtIdUser;
    @FXML
    private TextField txtNamaUser;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private void actionTambahUser(ActionEvent actionEvent) {
    }

    @FXML
    private void actionUpdateUser(ActionEvent actionEvent) {
    }

    @FXML
    private void actionCancelUser(ActionEvent actionEvent) {
    }
}
