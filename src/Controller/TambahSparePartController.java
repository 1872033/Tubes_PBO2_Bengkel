package Controller;

import Bengkel_Anthony_Ray_Ronaldo.Main;
import Dao.KendaraanDaoImpl;
import Dao.ReparasiDaoImpl;
import Entity.Kendaraan;
import Entity.Reparasi;
import Entity.SparePart;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TambahSparePartController implements Initializable {
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
    private ComboBox<Reparasi> cmbBoxIdRep;

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
        SparePart sparePart = new SparePart();
        sparePart.setIdSparepart(sparePart.getIdSparepart());
        sparePart.setNamaSparepart(sparePart.getNamaSparepart());
        sparePart.setHargaBeli(sparePart.getHargaBeli());
        sparePart.setHargaJual(sparePart.getHargaJual());
        sparePart.setStok(sparePart.getStok());

        Reparasi reparasi = new Reparasi();
        reparasi.setIdReparasi(cmbBoxIdRep.getValue().getIdReparasi());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ReparasiDaoImpl cDAO = new ReparasiDaoImpl();
        ObservableList<Reparasi> uList = (ObservableList<Reparasi>) cDAO.fetchAll();
        cmbBoxIdRep.setItems(uList);
    }
}
