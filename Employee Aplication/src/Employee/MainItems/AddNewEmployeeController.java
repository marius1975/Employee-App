package Employee.MainItems;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddNewEmployeeController  {

   ObservableList<String>maritalStatusItems = FXCollections.observableArrayList("Single", "Married" , "Divorced");
   ObservableList<String>comboBoxItems = FXCollections.observableArrayList("Electrical" , "Mechanical");
   ObservableList<String> electricalList = FXCollections.observableArrayList("Sales","Service");
   ObservableList<Object> mechanicalList = FXCollections.observableArrayList("Products" , "Quality");
    //Contact Information
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    //Personal Information
    @FXML
    private DatePicker birthDate;
    @FXML
    private TextField ageField;
    @FXML
    private ChoiceBox maritalStatusBox;
    @FXML
    private RadioButton maleButton;
    @FXML
    private RadioButton femaleButton;
    @FXML
    private TextField  idField;
    @FXML
    private ComboBox comboBox;
    @FXML
    private ComboBox  comboBox2;
    @FXML
    private CheckBox yesBox;
    @FXML
    private CheckBox noBox;


    @FXML
    private void calculateAge(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int birthYear = (birthDate.getValue().getYear());
        int age = year - birthYear;
        ageField.setText(age + " years");

    }

    @FXML
    private void initialize(){
        maritalStatusBox.setValue("Single");
        maritalStatusBox.setItems(maritalStatusItems);

        comboBox.setValue("Electrical");
        comboBox.setItems(comboBoxItems);

        comboBox2.setValue("Sales");
        comboBox2.setItems(electricalList);
    }
    //it changes the selected item in the departmentBox depending on the selected item in the main department box
     public void mainDepartmentChoice(){
        if(comboBox.getValue().equals("Electrical")){
            comboBox2.setValue("Sales");
            comboBox2.setItems(electricalList);
        }else{
            comboBox2.setValue("Products");
            comboBox2.setItems(mechanicalList);
        }
     }
     public void handleYesChoice(){
        if(yesBox.isSelected()){
            noBox.setSelected(false);
        }
     }
     public void handleNoChoice(){
        if(noBox.isSelected()){
            yesBox.setSelected(false);
        }
     }



}
