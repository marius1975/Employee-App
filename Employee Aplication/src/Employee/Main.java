package Employee;


import Employee.MainItems.Person;
import Employee.MainItems.PersonViewController;
import Employee.Mechanical.MechanicalDeptController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;



import java.io.IOException;


public class Main extends Application {
 private static Stage primaryStage;
 private static BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("Employee.fxml"));
       // primaryStage.setTitle("Hello World");
       // primaryStage.setScene(new Scene(root, 600, 400));
       // primaryStage.show();
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("My App");
        showMainView();
        showMainItems();

    }

    public void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("MainItems/MainView.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showMainItems() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("MainItems/MainItems.fxml"));
        BorderPane mainItems = loader.load();
        mainLayout.setCenter(mainItems);
    }

    public static void showElectricalDeptPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Electrical/ElectricalDept.fxml"));
        BorderPane electrical = loader.load();
        mainLayout.setCenter(electrical);


    }
    public static void showMechanicalDeptPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Mechanical/MechanicalDept.fxml"));
        BorderPane mechanical = loader.load();
        mainLayout.setCenter(mechanical);
    }
    public static void showAddEmployeePage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("MainItems/AddEmployeePage.fxml"));
        BorderPane addPage = loader.load();

        Stage addStageDialogBox = new Stage();
        addStageDialogBox.setTitle("Add New Employee");
        addStageDialogBox.initModality(Modality.WINDOW_MODAL);
        addStageDialogBox.initOwner(primaryStage);
        Scene scene = new Scene(addPage);
        addStageDialogBox.setScene(scene);
        addStageDialogBox.showAndWait();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
