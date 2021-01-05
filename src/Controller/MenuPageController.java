package Controller;

import Bengkel_Anthony_Ray_Ronaldo.Main;
import Dao.KendaraanDaoImpl;
import Dao.ReparasiDaoImpl;
import Dao.UserDaoImpl;
import Entity.Kendaraan;
import Entity.Reparasi;
import Entity.User;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuPageController implements Initializable {


    @FXML
    private TableView<Reparasi> TbRiwayatReparasi;
    @FXML
    private TableColumn<Reparasi,Integer> ColidReparasi;
    @FXML
    private TableColumn<Reparasi,Integer> ColidKendaraanR;
    @FXML
    private TableColumn<Reparasi,String> ColidNamaPemilikR;
    @FXML
    private TableColumn<Reparasi,String> ColTanggal;
    @FXML
    private TableColumn<Reparasi,String> ColJenisReparasi;
    @FXML
    private TableView<Kendaraan> TbDataKendaraan;
    @FXML
    private TableColumn<Kendaraan,Integer> ColidKendaraanDK;
    @FXML
    private TableColumn<Kendaraan,String> ColJenisKendaraan;
    @FXML
    private TableColumn<Kendaraan,String> ColNamaPemilikDK;
    @FXML
    private TableColumn<Kendaraan,String> ColNoPlat;
    @FXML
    private TableColumn<Kendaraan,String> ColNoSTNK;
    @FXML
    private TableView<User> TbDataUser;
    @FXML
    private TableColumn<User,String> ColNama;
    @FXML
    private TableColumn<User,String> ColUsername;
    @FXML
    private TableColumn<User,String> ColPasswd;
    @FXML
    private ListView ListUser;

    private Stage StagetoAdd;

    @FXML
    private Button LogOutButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StagetoAdd = new Stage();
        UserDaoImpl uDAO = new UserDaoImpl();
        ObservableList<User> dList = (ObservableList<User>) uDAO.fetchAll();
        TbDataUser.setItems(dList);
        ColNama.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getNama()));
        ColUsername.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getUsername()));
        ColPasswd.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getPassword()));

        ReparasiDaoImpl rDAO = new ReparasiDaoImpl();
        ObservableList<Reparasi> rList = (ObservableList<Reparasi>) rDAO.fetchAll();
        TbRiwayatReparasi.setItems(rList);
        ColidReparasi.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getIdReparasi()));
        ColidKendaraanR.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getIdKendaraan()));
        ColidNamaPemilikR.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getNamaPemilik()));
        ColTanggal.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getTglreparasi()));
        ColJenisReparasi.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getJenisreparasi()));

        KendaraanDaoImpl kDAO = new KendaraanDaoImpl();
        ObservableList<Kendaraan> kList = (ObservableList<Kendaraan>) kDAO.fetchAll();
        TbDataKendaraan.setItems(kList);
        ColidKendaraanDK.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getIdKendaraan()));
        ColJenisKendaraan.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getJeniskendaraan()));
        ColNamaPemilikDK.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getNamaUser()));
        ColNoPlat.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getNoPlat()));
        ColNoSTNK.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getNostnk()));






    }

    @FXML
    private void ActionTambahReparasi(ActionEvent actionEvent) {
    }

    @FXML
    private void ActionHapusReparasi(ActionEvent actionEvent) {

    }

    @FXML
    private void ActionUpdateReparasi(ActionEvent actionEvent) {
    }

    @FXML
    private void ActionTambahKendaraan(ActionEvent actionEvent) {
    }

    @FXML
    private void ActionHapusKendaraan(ActionEvent actionEvent) {
    }

    @FXML
    private void ActionUpdateKendaraan(ActionEvent actionEvent) {
    }

    @FXML
    private void ActionTambahUser(ActionEvent actionEvent) {
    }

    @FXML
    private void ActionHapusUser(ActionEvent actionEvent) {
    }

    @FXML
    private void ActionUpdateUser(ActionEvent actionEvent) {
    }

    @FXML
    private void ActionLihatDetailReparasi(ActionEvent actionEvent) {
    }

    public void actionlogout(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) LogOutButton.getScene().getWindow();
        stage.close();
        FXMLLoader Login=new FXMLLoader();
        Login.setLocation(Main.class.getResource("../View/LoginPage.fxml"));
        Stage dialogStage = new Stage();
        VBox l =Login.load();
        dialogStage.setScene(new Scene(l));
        dialogStage.show();
    }

    @FXML
    private void actionSparePart(ActionEvent actionEvent) {
    }


}
