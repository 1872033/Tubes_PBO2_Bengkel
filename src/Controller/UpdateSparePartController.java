package Controller;

import Dao.KendaraanDaoImpl;
import Dao.ReparasiDaoImpl;
import Dao.SparepartDaoImpl;
import Entity.Kendaraan;
import Entity.Reparasi;
import Entity.SparePart;
import Entity.User;
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
    private TextField txtNamaSparePart;
    @FXML
    private TextField txtHargaBeli;
    @FXML
    private TextField txtHargaJual;
    @FXML
    private TextField txtStok;
    @FXML
    private ComboBox<Reparasi> cmbBoxIdRep;
    @FXML
    private Button btnCancel;

    public SparePartPageController controller;

    public SparePart sparePart;

    public void setController(SparePartPageController controller) {
        this.controller = controller;
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
        SparepartDaoImpl sDAO = new SparepartDaoImpl();
        sparePart.setNamaSparepart(txtNamaSparePart.getText().trim());
        sparePart.setHargaBeli(Integer.parseInt(txtHargaBeli.getText().trim()));
        sparePart.setHargaJual(Integer.parseInt(txtHargaJual.getText().trim()));
        sparePart.setStok(Integer.parseInt(txtStok.getText().trim()));

        Reparasi reparasi = new Reparasi();
        reparasi.setIdReparasi(cmbBoxIdRep.getValue().getIdReparasi());

        sDAO.editData(sparePart);
        controller.getSparePartDAO().editData(sparePart);
        controller.dList.clear();
        controller.dList.addAll(controller.getSparePartDAO().fetchAll());
    }

    @FXML
    private void actionCancelSparePart(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
