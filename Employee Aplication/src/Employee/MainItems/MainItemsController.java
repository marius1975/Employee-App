package Employee.MainItems;

import Employee.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainItemsController  {

protected Main main;




@FXML
    private void goToElectricalDept() throws IOException {
        main.showElectricalDeptPage();
    }
@FXML
    private void goToMechanicalDept() throws IOException {
    main.showMechanicalDeptPage();

    }



}
