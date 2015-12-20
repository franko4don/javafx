/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explore;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.text.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.*;
import javafx.stage.FileChooser;

/**
 *
 * @author FRANKCHUKY
 */
public class Explore extends Application {
    Scene inherit;
    Stage one;
    DatePicker get;
    @Override
    public void start(Stage stage) {
    HBox hold=new HBox();
    for(int i=0; i<10; i++){
    VBox create=new VBox();
    for(int j=i; j<10; j++){
    Button number=new Button(""+j);
    number.setMinSize(70, 70);
    create.getChildren().add(number);
    }
    create.setSpacing(10);
   // create.setRotate(5);
    
    hold.getChildren().add(create);
    }
   //   VBox allign=new VBox();
        StackPane root = new StackPane();
        /**this.one=stage;
        RadioButton radioButton1=getRadioButtonProperties("Married");
        RadioButton radioButton2=getRadioButtonProperties("Single");
         RadioButton radioButton3=getRadioButtonProperties("Married");
        RadioButton radioButton4=getRadioButtonProperties("Single");
        ToggleGroup bind=new ToggleGroup();
        radioButton1.setToggleGroup(bind);
        radioButton2.setToggleGroup(bind);
        radioButton3.setToggleGroup(bind);
        radioButton4.setToggleGroup(bind);
         allign.setSpacing(50);
        allign.getChildren().addAll(radioButton3,radioButton4);
        Button btn=new Button("Switch");
        hold.getChildren().addAll(radioButton1,radioButton2,btn);
        hold.setSpacing(100);
       
        hold.setPadding(new Insets(50)); 
        root.getChildren().add(hold);
        Scene scene = new Scene(root,500,300);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
        btn.setOnAction(e-> switchscene(e));*/
        hold.setSpacing(20);
        root.getChildren().add(hold);
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

   public void switchscene(ActionEvent event){
   Image image=new Image(this.getClass().getResourceAsStream("vector.jpg"));
   ImageView show=new ImageView(image);
 //  ComboBox cb=new ComboBox();
  // List<String> list=FXCollections.observableArrayList("Mr","Mrs","Engr","Doc");
  // cb.getItems().addAll(list);
   Button btnn=new Button("Back");
   Button getDate=new Button("Submit");
   StackPane sp=new StackPane();
   DatePicker check=new DatePicker();
   this.get=check;
   HBox hori=new HBox(btnn,check,getDate);
   hori.setSpacing(100);
   sp.getChildren().addAll(show,hori);
   Scene ovr=new Scene(sp);
   check.setValue(LocalDate.of(1993,8, 4));
   check.setShowWeekNumbers(true);
   one.setScene(ovr);
   one.show();
   btnn.setOnAction(e->goback(e));

   }
   
   
 
   public void goback(ActionEvent event){
   start(one);
   }
   
    public static void main(String[] args) {
        launch(args);
    }
    
    public RadioButton getRadioButtonProperties(String title){
    RadioButton option=new RadioButton();
    option.setText(title);
    option.setTextFill(Color.GREEN);
    option.setFocusTraversable(true);
    option.setSelected(false);
    return option;
    }
    
    
    	
	private FileChooser setInitialDirectory(String text){
	FileChooser temp=new FileChooser();
	temp.setTitle(text);
	temp.setInitialDirectory(new File(System.getProperty("user.home"))); 
	temp.getExtensionFilters().addAll(
			new FileChooser.ExtensionFilter("All Files", "*.*"),
			new FileChooser.ExtensionFilter("JPG", "*.jpg"),
			new FileChooser.ExtensionFilter("PNG", "*.png")
			);
	return temp;	
	}
	
	
	public void ChooseImage(ActionEvent event){
		FileChooser choose=setInitialDirectory("Select a Picture");
		File file=choose.showOpenDialog(stage);
		if(file!=null){		
			openFile(file);
		}
		
	}
	
	
	
	public void openFile(File file){
		Image image=new Image("file:"+file.getAbsolutePath());
		System.out.println(file.getAbsolutePath());
		ImageView display=new ImageView();	
		
		display.setImage(image);
		display.setFitHeight(150);
		display.setFitWidth(150);
		display.setPreserveRatio(true);
		Pane pane=new Pane();
		pane.getChildren().add(display);
		stage.setScene(new Scene(pane,400,400));
		
		
	}
    
    
}