package Employee.MainItems;

import Employee.Main;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainViewController {
    protected Main main;
    @FXML
    public void goHome() throws IOException {
        main.showMainItems();
    }
    @FXML
    public void goToAddEmployee() throws IOException {
        main.showAddEmployeePage();
    }
}
