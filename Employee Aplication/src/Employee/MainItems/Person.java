package Employee.MainItems;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.Period;

public class Person {

private SimpleStringProperty name;
protected Image photo;

public Person(String name){

    this.name = new SimpleStringProperty(name);
    photo = new Image("pic1.jpeg.jpg");

}
    public Person(String name ,Image newPhoto){

        this.name = new SimpleStringProperty(name);
        this.photo = newPhoto;

    }
    public Image getPhoto(){
    return photo;
    }
    public void setPhoto(Image newPhoto){
    this.photo = newPhoto;
    }

    public String getName() {
        return name.get();
    }




    public void setName(String name) {
        this.name = new SimpleStringProperty(name) ;
    }




}
