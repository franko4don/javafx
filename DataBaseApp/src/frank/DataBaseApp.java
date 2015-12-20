/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frank;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author FRANKCHUKY
 */
public class DataBaseApp extends Application {
  
	Button create,query,editInfo;
         Stage mainStage;
         Stage resetStage;
         Scene mainScene;
         Form moveto;
         
	@Override 
	public void start(Stage primaryStage){
        
         mainStage=primaryStage;
          Scene scene=homePage();
          mainScene=scene;
        mainStage.setScene(scene);
        
        mainStage.show();
	}
	 
       
        
        
        public Scene homePage(){
                VBox allignButtons=new VBox();
		create=getButtonProperties("Create");
		query=getButtonProperties("Query");
		editInfo=getButtonProperties("Edit");
		allignButtons.setSpacing(40);
		allignButtons.setPadding(new Insets(100,0,0,100));
		allignButtons.getChildren().addAll(create,query,editInfo);
		Image backGround=new Image(getClass().getResourceAsStream("images/BackGround_MainFrame.jpg"));
		ImageView displayBackGroundImage=new ImageView();
		displayBackGroundImage.setImage(backGround);
		StackPane root=new StackPane();
		root.getChildren().addAll(displayBackGroundImage,allignButtons);
		Scene scene=new Scene(root,300,400);
                mainStage.setTitle("DataBase Management");
                mainStage.setMinHeight(400);
                mainStage.setMaxHeight(400);
               // mainStage
                //mainStage.setY(value);
               
		checkButtonActions();
                return scene;
        }
        
        
	//checks for button pressed on the mainframe and takes appropriate actions
	public void checkButtonActions(){
	create.setOnAction(e->triggerCreate(e));
	query.setOnAction(e->triggerQuery(e));
	editInfo.setOnAction(e->triggerEditInfo(e));	
	}
	
	
	public void triggerCreate(ActionEvent event){
		moveto=new Form(this);  
                mainStage.setTitle("Form");
                Scene get=moveto.start();
                Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
                mainStage.setY(primaryScreenBounds.getMinY());
              //  mainStage.setHeight(primaryScreenBounds.getMaxY()-100);
                mainStage.setResizable(false);
                mainStage.setMinHeight(700);
                mainStage.setScene(get);
                
	}
	
	
	public void triggerQuery(ActionEvent event){
		
		
	}
	

	public void triggerEditInfo(ActionEvent event){
	
	
	}
	
	
	private Button getButtonProperties(String title){
		Button props=new Button();
		props.setText(title);
		props.setMinWidth(100);
		return props;
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}
    
}
