package Controller;

import Bengkel_Anthony_Ray_Ronaldo.Main;
import Dao.KendaraanDaoImpl;
import Dao.ReparasiDaoImpl;
import Dao.SparepartDaoImpl;
import Dao.UserDaoImpl;
import Entity.Kendaraan;
import Entity.Reparasi;
import Entity.SparePart;
import Entity.User;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuPageController implements Initializable {


    @FXML
    public TableView<Reparasi> TbRiwayatReparasi;
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
    public TableView<Kendaraan> TbDataKendaraan;
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
    public TableView<User> TbDataUser;
    @FXML
    private TableColumn<User,String> ColNama;
    @FXML
    private TableColumn<User,String> ColUsername;
    @FXML
    private TableColumn<User,String> ColPasswd;
    @FXML
    private ListView ListUser;

    private Stage StagetoAdd;

    public Kendaraan k;

    public Reparasi r;

    public User u;
    public void refreshUpdate(){
        TbDataKendaraan.refresh();
        TbDataUser.refresh();
        TbRiwayatReparasi.refresh();
    }

    private KendaraanDaoImpl kDAO;
    public KendaraanDaoImpl getKendaraanDAO(){
        if (kDAO==null) {
            kDAO=new KendaraanDaoImpl();
        }
        return kDAO;
    }

    public ObservableList<Kendaraan> kList;
    public ObservableList<Kendaraan> getKendaraan(){
        if (kList==null) {
            kList=FXCollections.observableArrayList();
            kList.addAll(getKendaraanDAO().fetchAll());
        }
        return kList;
    }

    public UserDaoImpl uDAO;
    public ObservableList<User> uList ;
    public ObservableList<User> getUser(){
        if (uList==null) {
            uList=FXCollections.observableArrayList();
            uList.addAll(getUserDAO().fetchAll());
        }
        return uList;
    }
    public UserDaoImpl getUserDAO(){
        if (uDAO==null) {
            uDAO=new UserDaoImpl();
        }
        return uDAO;
    }

    public ReparasiDaoImpl rDAO;
    public ObservableList<Reparasi> rList;
    public ObservableList<Reparasi> getReparasi(){
        if (rList==null) {
            rList=FXCollections.observableArrayList();
            rList.addAll(getReparasiDAO().fetchAll());
        }
        return rList;
    }
    public ReparasiDaoImpl getReparasiDAO(){
        if (rDAO==null) {
            rDAO=new ReparasiDaoImpl();
        }
        return rDAO;
    }


    @FXML
    private Button LogOutButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StagetoAdd = new Stage();

        TbDataUser.setItems(getUser());
        ColNama.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getNama()));
        ColUsername.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getUsername()));
        ColPasswd.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getPassword()));

        TbRiwayatReparasi.setItems(getReparasi());
        ColidReparasi.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getIdReparasi()));
        ColidKendaraanR.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getIdKendaraan()));
        ColidNamaPemilikR.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getIdPemilik()));
        ColTanggal.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getTglreparasi()));
        ColJenisReparasi.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getJenisreparasi()));

        TbDataKendaraan.setItems(getKendaraan());
        ColidKendaraanDK.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getIdKendaraan()));
        ColJenisKendaraan.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getJeniskendaraan()));
        ColNamaPemilikDK.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getIdUser()));
        ColNoPlat.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getNoPlat()));
        ColNoSTNK.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getNostnk()));

    }

    @FXML
    private void ActionTambahReparasi(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../View/TambahReparasi.fxml"));
        Parent root = loader.load();
        TambahReparasiCOntroller tambahReparasiCOntroller= loader.getController();
        tambahReparasiCOntroller.setController(this);

        Scene new_scene = new Scene(root);
        StagetoAdd.setScene(new_scene);
        StagetoAdd.setTitle("Tambah Reparasi");
        StagetoAdd.show();

    }

    @FXML
    private void ActionHapusReparasi(ActionEvent actionEvent) {
        Reparasi selected;
        selected = (Reparasi) TbRiwayatReparasi.getSelectionModel().getSelectedItem();
        System.out.println(selected);

        ReparasiDaoImpl rdao = new ReparasiDaoImpl();
        int result = rdao.deleteData(selected);
        if(result!=0){
            System.out.println("Delete Berhasil");
        }
        ObservableList<Reparasi> uList = (ObservableList<Reparasi>) rdao.fetchAll();
        TbRiwayatReparasi.setItems(uList);

    }

    @FXML
    private void ActionUpdateReparasi(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(Main.class.getResource("../View/UpdateReparasi.fxml"));
        VBox root = loader1.load();

        UpdateReparasiController UptCont = loader1.getController();
        UptCont.setController(this);
        Scene new_scene = new Scene(root);
        StagetoAdd.setScene(new_scene);
        StagetoAdd.setTitle("Update Reparasi");
        StagetoAdd.show();
    }

    @FXML
    private void ActionTambahKendaraan(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../View/TambahKendaraan.fxml"));
        Parent root = loader.load();
        TambahKendaraanController tambahKendaraanController= loader.getController();
        tambahKendaraanController.setController(this);
        Scene new_scene = new Scene(root);
        StagetoAdd.setScene(new_scene);
        StagetoAdd.setTitle("Tambah Kendaraan");
        StagetoAdd.show();

    }

    @FXML
    private void ActionHapusKendaraan(ActionEvent actionEvent) {
        Kendaraan selected;
        selected = (Kendaraan) TbDataKendaraan.getSelectionModel().getSelectedItem();
        System.out.println(selected);

        KendaraanDaoImpl dao = new KendaraanDaoImpl();
        int result = dao.deleteData(selected);
        if(result!=0){
            System.out.println("Delete Berhasil");
        }
        ObservableList<Kendaraan> uList = (ObservableList<Kendaraan>) dao.fetchAll();
        TbDataKendaraan.setItems(uList);

    }

    @FXML
    private void ActionUpdateKendaraan(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(Main.class.getResource("../View/UpdateKendaraan.fxml"));
        VBox root = loader1.load();

        UpdateKendaraanController UptCont = loader1.getController();
        UptCont.setController(this);
        Scene new_scene = new Scene(root);
        StagetoAdd.setScene(new_scene);
        StagetoAdd.setTitle("Update Kendaraan ");
        StagetoAdd.show();
    }

    @FXML
    private void ActionTambahUser(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../View/TambahUser.fxml"));
        Parent root = loader.load();

        Scene new_scene = new Scene(root);
        StagetoAdd.setScene(new_scene);
        StagetoAdd.setTitle("Tambah User");
        StagetoAdd.show();
    }


    @FXML
    private void ActionUpdateUser(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(Main.class.getResource("../View/UpdateUser.fxml"));
        VBox root = loader1.load();

        UpdateUserController UptCont = loader1.getController();
        UptCont.setController(this);
        Scene new_scene = new Scene(root);
        StagetoAdd.setScene(new_scene);
        StagetoAdd.setTitle("Update User ");
        StagetoAdd.show();

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
        Stage stage1 = (Stage) LogOutButton.getScene().getWindow();
        stage1.close();
    }

    @FXML
    private void actionSparePart(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../View/SparePartPage.fxml"));
        Parent root = loader.load();

        Scene new_scene = new Scene(root);
        StagetoAdd.setScene(new_scene);
        StagetoAdd.setTitle(" SparePart ");
        StagetoAdd.show();

    }


    @FXML
    private void actionSelectedUser(MouseEvent mouseEvent) {
        u=TbDataUser.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void actionSelectedKendaraan(MouseEvent mouseEvent) {
        k= TbDataKendaraan.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void actionSelectedReparasi(MouseEvent mouseEvent) {
        r= TbRiwayatReparasi.getSelectionModel().getSelectedItem();

    }
}
