package Controller;

import Bengkel_Anthony_Ray_Ronaldo.Main;
import Utility.MySQLConnection;
import javafx.collections.transformation.TransformationList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label labelKeterangan;

    Scene scene;

    Connection connection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private TransformationList<Object, Object> event;
    @FXML
    private Button btnLogin;

    public LoginController() {
        connection = MySQLConnection.getConnection();
    }

    @FXML
    private void actionCancel(ActionEvent actionEvent) {
        txtPassword.clear();
        txtUsername.clear();
        txtUsername.requestFocus();
    }

    @FXML
    private void actionLogin(ActionEvent actionEvent) {
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        String sql = "SELECT * FROM user WHERE Username = ? and Password = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                labelKeterangan.setText("Login Failed");
            }else if(username.equals("Admin")){
                System.out.println("Login Successful");
                FXMLLoader Admin=new FXMLLoader();
                Admin.setLocation(Main.class.getResource("../View/MenuPage.fxml"));
                Stage dialogStage = new Stage();
                VBox x =Admin.load();
                dialogStage.setScene(new Scene(x));
                dialogStage.show();
            }else{
                System.out.println("Login Successful");
                FXMLLoader User=new FXMLLoader();
                User.setLocation(Main.class.getResource("../View/UserView.fxml"));
                Stage dialogStage = new Stage();
                VBox y =User.load();
                dialogStage.setScene(new Scene(y));
                dialogStage.show();
            }

        }catch(Exception e){
            e.printStackTrace();
    }
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.close();
}

    public static void infoBox(String enter_correct_email_and_password, String failed, Object o) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
