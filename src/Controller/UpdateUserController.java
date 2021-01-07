package Controller;

import Dao.UserDaoImpl;
import Entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateUserController implements Initializable {

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

    public MenuPageController controller;

    public User user;

    public void setController(MenuPageController controller){
        this.controller=controller;
        txtNamaUser.setText(String.valueOf(controller.u.getNama()));
        txtUsername.setText(String.valueOf(controller.u.getUsername()));
        txtPassword.setText(String.valueOf(controller.u.getPassword()));
        txtConfirmPassword.setText(String.valueOf(controller.u.getPassword()));
        user=controller.u;


    }

    @FXML
    private void actionUpdateUser(ActionEvent actionEvent) {
        UserDaoImpl uDAO = new UserDaoImpl();
        user.setNama(txtNamaUser.getText().trim());
        user.setUsername(txtUsername.getText().trim());
        user.setPassword(txtPassword.getText().trim());
        uDAO.editData(user);
        controller.getUserDAO().editData(user);
        controller.uList.clear();
        controller.uList.addAll(controller.getUserDAO().fetchAll());    }

    @FXML
    private void actionCancelUser(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
