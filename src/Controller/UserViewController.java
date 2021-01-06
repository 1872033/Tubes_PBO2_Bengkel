package Controller;

import Bengkel_Anthony_Ray_Ronaldo.Main;
import Dao.KendaraanDaoImpl;
import Dao.UserDaoImpl;
import Dao.UserViewDaoImpl;
import Entity.Kendaraan;
import Entity.User;
import Entity.UserView;
import Utility.MySQLConnection;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class UserViewController implements Initializable {
    @FXML
    private TableView<UserView> TbRiwayatReparasi;
    @FXML
    private TableColumn<UserView,String> ColNoPlat;
    @FXML
    private TableColumn<UserView,String> ColNamaPemilik;
    @FXML
    private TableColumn<UserView,String> ColTanggal;
    @FXML
    private TableColumn<UserView,String> ColJenisReparasi;
    @FXML
    private TableColumn<UserView,String> ColJenisKendaraan;
    @FXML
    private Button exitbutton;
    private Stage StagetoAdd;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StagetoAdd = new Stage();
        UserViewDaoImpl uDAO = new UserViewDaoImpl();
        ObservableList<UserView> uvList = (ObservableList<UserView>) uDAO.fetchAll();
        TbRiwayatReparasi.setItems(uvList);
        ColNoPlat.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getNoPlat()));
        ColNamaPemilik.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getNamaPemilik()));
        ColTanggal.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getTanggal()));
        ColJenisKendaraan.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getJenisKendaraan()));
        ColJenisReparasi.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getJenisReparasi()));


    }

    @FXML
    private void actionCetak(ActionEvent actionEvent) {
        JasperPrint jp;
        Map param = new HashMap();

        try {
            jp = JasperFillManager.fillReport("report/Reparasi.jasper",
                    param, MySQLConnection.getConnection());
            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setTitle("Summary");
            viewer.setVisible(true);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void ActionExit(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) exitbutton.getScene().getWindow();
        stage.close();
        FXMLLoader Login=new FXMLLoader();
        Login.setLocation(Main.class.getResource("../View/LoginPage.fxml"));
        Stage dialogStage = new Stage();
        VBox u =Login.load();
        dialogStage.setScene(new Scene(u));
        dialogStage.show();
    }


}
