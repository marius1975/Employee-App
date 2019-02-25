package Employee.Mechanical;


import Employee.Main;
import Employee.MainItems.Person;

import Employee.MainItems.PersonViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MechanicalDeptController implements Initializable {

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person , String> tableColumn;

    @FXML
    private TextField nameField;
    @FXML
    private Button detailedViewButton;



    // can edit a cell in the column Table . [can enter a name in the cell ]
    public void changeNameCellEvent(CellEditEvent cellEditEvent){
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setName(cellEditEvent.getNewValue().toString());


    }
    //creates a new person and adds it to the table
    public void addNewNameWhenButtonPushed(){

        Person person = new Person(nameField.getText());
        tableView.getItems().add(person);
        nameField.clear();
    }
    // this method will remove the selected rows from the table View
    public void removeNameWhenButtonPushed(){
        ObservableList<Person> selectedRows, allPeople ;
        allPeople = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        for(Person person: selectedRows){
            allPeople.remove(person);
        }
    }

   @FXML
    public void showDetailedPersonView(ActionEvent event)throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("MainItems/PersonView.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        PersonViewController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }
    @FXML
    public void returnToMainItems(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("MainItems/MainItems.fxml"));
        BorderPane mainItems = loader.load();
        Scene scene = new Scene(mainItems);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    public void userClickedOnTable(){
        detailedViewButton.setDisable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView.setItems(getPeople());

        // this 2 lines below make the columns in the table column editable
        tableView.setEditable(true);
        tableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        detailedViewButton.setDisable(true);
        // this line of code will allow multiple rows selection
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    public ObservableList<Person>getPeople(){
        ObservableList<Person>people = FXCollections.observableArrayList();
        people.add(new Person("Marius", new Image("pic2.jpeg.jpg")));
        people.add(new Person("Florin"));
        return people;

    }


}
