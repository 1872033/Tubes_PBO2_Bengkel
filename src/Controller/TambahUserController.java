package Controller;

import Entity.SparePart;
import Entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TambahUserController {

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
    private MenuPageController controller;


    @FXML
    private void actionTambahUser(ActionEvent actionEvent) {
        User user= new User();
        user.setNama(txtNamaUser.getText());
        user.setUsername(txtUsername.getText());
        user.setPassword(txtPassword.getText());

        controller.getUserDAO().addData(user);
        controller.uList.clear();
        controller.uList.addAll(controller.getUserDAO().fetchAll());
    }

    @FXML
    private void actionCancelUser(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
