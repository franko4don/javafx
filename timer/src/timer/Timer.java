/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javax.swing.JOptionPane;
/**
 *
 * @author FRANKCHUKY
 */
public class Timer extends Application {
    TextField prescalershow;
    TextField xtalshow;
    TextField timeshow;
    TextArea answer;
   
    @Override 
    public void start(Stage primaryStage) {
      ImageView image=getImageViewProperties("vector.jpg");
      VBox first=getVerticalBoxProperties();
      VBox second=getVerticalBoxProperties();
      HBox adjust=getHorizontalBoxProperties();
      adjust.setMinWidth(150);
      Button generate=getButtonProperties("GENERATE");
      ImageView display1=getImageViewProperties("gen.jpg");
      ImageView display2=getImageViewProperties("about.jpg");
      Button about=getButtonProperties("ABOUT");
      about.setGraphic(display2);
      generate.setGraphic(display1);
      Label prescaler=getLabelProperties("PRE SCALER (2-256)");
      Label xtal=getLabelProperties("XTAL FREQUENCY (MHz)");
      Label time=getLabelProperties("TIME IN SECONDS");
      Label detail=getLabelProperties("                           ENTER THE REQUIRED INFORMATION");
      detail.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 13));
     
     prescalershow=getTextFieldProperties();
     xtalshow=getTextFieldProperties();
     timeshow=getTextFieldProperties();
     answer=getTextAreaProperties();
      second.getChildren().addAll(prescalershow,xtalshow,timeshow,answer);
      second.setSpacing(22);
      second.setPadding(new Insets(63,0,0,0));
      first.getChildren().add(detail);
      first.getChildren().addAll(prescaler,xtal,time);
      first.getChildren().addAll(generate,about);
      first.setPadding(new Insets(20)); 
      first.setSpacing(30);
      
      
    HBox root=new HBox(); 
    StackPane stack=new StackPane();
    root.getChildren().add(image);
  //  root.setCenter(second);
   // root.setLeft(first);
    
    root.getChildren().addAll(first,second);
    stack.getChildren().addAll(image,root);
    
    Scene scene=new Scene(stack,550,400);
    primaryStage.setTitle("TMER0 CODE GENERATOR");
    primaryStage.setScene(scene);
    primaryStage.show();
    primaryStage.setResizable(false);
    primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("icon.jpg")));
    generate.setOnAction(e-> CodeGenerate(e)); ///calls code genrator method
    about.setOnAction(e-> about(e));
    }

    /**
     * @param name
     * @return 
     */
    
    public ImageView getImageViewProperties(String name){
    Image background=new Image(this.getClass().getResourceAsStream(name));
     ImageView ShowImage=new ImageView();
     ShowImage.setImage(background);
     return ShowImage;
    }
    
    public HBox getHorizontalBoxProperties(){
    HBox horizontal=new HBox();
    return horizontal;
    }
    
    public VBox getVerticalBoxProperties(){
    VBox vertical=new VBox();
    return vertical;
    }
    
    public Label getLabelProperties(String text){
    Label name=new Label(text);
    name.setTextFill(Color.RED);
    name.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 13)); 
    return name;
    }
    
    public Text getTextProperties(String text){
    Text message=new Text(text);
    message.setFont(Font.font(14));
    message.setFill(Color.rgb(0, 0, 0));
    return message;
    }
    
    public Button getButtonProperties(String text){
    Button action=new Button(text);
    action.setTextFill(Color.BLACK);
    action.setMinWidth(150);
    
    return action;
    }
    
    public TextArea getTextAreaProperties(){
    TextArea input=new TextArea();
    input.setMaxHeight(190);
    input.setMinWidth(150);
    input.setMaxWidth(150);
    return input;
    }
    
    public TextField getTextFieldProperties(){
    TextField input=new TextField();
    input.setMaxWidth(150);
    input.setFont(Font.font(STYLESHEET_MODENA, FontWeight.LIGHT, 13));  
    return input;
    }
    
    
    
    public void CodeGenerate(ActionEvent event){
    double prescaler;
    double crystal;
    double time;
    try{
    prescaler=Double.parseDouble(prescalershow.getText()); 
    crystal=Double.parseDouble(xtalshow.getText());
    time=Double.parseDouble(timeshow.getText());
    Function calc=new Function();
    
    String obtain=calc.time(prescaler, crystal, time);
    answer.setText(obtain);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "ERROR WHILE PARSING VALUES\n PLEASE FILL THE TEXTFIELDS", "InputMismatchException", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public void about(ActionEvent event){
    String info="This software is meant to\n generate delay routines\n for timer0 register in PIC\n N:B For smaller time\n Use a smaller prescaler";
    JOptionPane.showMessageDialog(null, info, "ABOUT THE SOFTWARE", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public static void main(String[] args) {
       Application.launch(args);
    }

}
