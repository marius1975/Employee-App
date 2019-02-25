package Employee.MainItems;

import Employee.Main;
import Employee.Mechanical.MechanicalDeptController;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonViewController implements Initializable {


private Person selectedPerson;
@FXML
private Label nameLabel;
@FXML
private ImageView imageView;

private FileChooser fileChooser;
private File  filePath;







    public void initData(Person person){
    selectedPerson = person;
    nameLabel.setText(selectedPerson.getName());
    imageView.setImage(selectedPerson.getPhoto());
    }

   @FXML
    public void returnToMechanicalDeptPage(ActionEvent event)throws IOException{

       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(Main.class.getResource("Mechanical/MechanicalDept.fxml"));
       BorderPane mechanical = loader.load();
       Scene scene = new Scene(mechanical);
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);

    }
    public void chooseImageButtonClicked(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        // Set to user's directory or if can't open go to the C drive
        String userdirectoryString = System.getProperty("user.home");
        File userdirectory = new File(userdirectoryString);
        if (!userdirectory.canRead())
            userdirectory = new File("C:/");
        //Try to update the image by loading the new image
        try{
            BufferedImage bufferedImage = ImageIO.read(filePath);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            selectedPerson.setPhoto(image);
            imageView.setImage(selectedPerson.getPhoto());

        }catch(Exception e){

        }
        fileChooser.setInitialDirectory(userdirectory);
        //
        this.filePath = fileChooser.showOpenDialog(stage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
