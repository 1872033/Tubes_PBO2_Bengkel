package Controller;

import Bengkel_Anthony_Ray_Ronaldo.Main;
import Dao.KendaraanDaoImpl;
import Dao.SparepartDaoImpl;
import Entity.Kendaraan;
import Entity.Reparasi;
import Entity.SparePart;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SparePartPageController implements Initializable {
    @FXML
    private TableView<SparePart> TbSparePart;
    @FXML
    private TableColumn<SparePart,Integer> ColidSparePart;
    @FXML
    private TableColumn<SparePart,String> ColNamaSparePart;
    @FXML
    private TableColumn<SparePart,Integer> ColHargaBeli;
    @FXML
    private TableColumn<SparePart,Integer> ColHargaJual;
    @FXML
    private TableColumn<SparePart,Integer> ColStok;
    @FXML
    private TableColumn<SparePart,Integer> ColIdRep;
    private Stage StagetoAdd;
    @FXML
    private Button btnExit;

    public SparePart s;

    SparepartDaoImpl uDAO ;
    public SparepartDaoImpl getSparePartDAO(){
        if (uDAO==null) {
            uDAO=new SparepartDaoImpl();
        }
        return uDAO;
    }

    ObservableList<SparePart> spList;
    public ObservableList<SparePart> getSparePart(){
        if (spList==null) {
            spList= FXCollections.observableArrayList();
            spList.addAll(getSparePartDAO().fetchAll());
        }
        return spList;
    }


    @FXML
    private void ActionTambahSparePart(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../View/TambahSparePart.fxml"));
        Parent root = loader.load();

        TambahSparePartController tambahSparePartController= loader.getController();
        tambahSparePartController.setController(this);

        Scene new_scene = new Scene(root);
        StagetoAdd.setScene(new_scene);
        StagetoAdd.setTitle("Tambah SparePart");
        StagetoAdd.show();
    }


    @FXML
    private void ActionUpdateSparePart(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(Main.class.getResource("../View/UpdateSparePart.fxml"));
        VBox root = loader1.load();

        UpdateSparePartController UptCont = loader1.getController();
        UptCont.setController(this);
        Scene new_scene = new Scene(root);
        StagetoAdd.setScene(new_scene);
        StagetoAdd.setTitle("Update Reparasi");
        StagetoAdd.show();
    }

    public void exitaction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
        FXMLLoader Login=new FXMLLoader();
        Login.setLocation(Main.class.getResource("../View/MenuPage.fxml"));
        Stage dialogStage = new Stage();
        VBox s = null;
        try {
            s = Login.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialogStage.setScene(new Scene(s));
        dialogStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StagetoAdd = new Stage();

        TbSparePart.setItems(getSparePart());
        ColidSparePart.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getIdSparepart()));
        ColNamaSparePart.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getNamaSparepart()));
        ColHargaBeli.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getHargaBeli()));
        ColHargaJual.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getHargaJual()));
        ColStok.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getStok()));
        ColIdRep.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getIdRep()));
    }

    @FXML
    private void actionSelectedSparePart(MouseEvent mouseEvent) {
        s= TbSparePart.getSelectionModel().getSelectedItem();
    }
}
