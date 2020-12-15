package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class UserViewController {
    @FXML
    private TableView TbRiwayatReparasi;
    @FXML
    private TableColumn ColNoPlat;
    @FXML
    private TableColumn ColNamaPemilik;
    @FXML
    private TableColumn ColTanggal;
    @FXML
    private TableColumn ColJenisReparasi;

    @FXML
    private void actionCetak(ActionEvent actionEvent) {
    }

    @FXML
    private void ActionExit(ActionEvent actionEvent) {
    }
}
