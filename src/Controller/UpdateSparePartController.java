package Controller;

import Dao.KendaraanDaoImpl;
import Dao.ReparasiDaoImpl;
import Entity.Kendaraan;
import Entity.Reparasi;
import Entity.SparePart;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateSparePartController implements Initializable {


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
    private ComboBox cmbBoxIdRep;
    @FXML
    private Button btnCancel;

    public SparePartPageController controller;

    public SparePart sparePart;

    public void setController(SparePartPageController controller) {
        this.controller = controller;
        txtIdSparePart.setText(String.valueOf(controller.s.getIdSparepart()));
        txtNamaSparePart.setText(String.valueOf(controller.s.getNamaSparepart()));
        txtHargaJual.setText(String.valueOf(controller.s.getHargaJual()));
        txtHargaBeli.setText(String.valueOf(controller.s.getHargaBeli()));
        txtStok.setText(String.valueOf(controller.s.getStok()));
        ReparasiDaoImpl rDao = new ReparasiDaoImpl();
        ObservableList<Reparasi> kList = (ObservableList<Reparasi>) rDao.fetchAll();
        cmbBoxIdRep.setItems(kList);
        sparePart = controller.s;
    }


    @FXML
    private void actionUpdateSparePart(ActionEvent actionEvent) {
    }

    @FXML
    private void actionCancelSparePart(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtIdSparePart.setDisable(true);
    }
}
