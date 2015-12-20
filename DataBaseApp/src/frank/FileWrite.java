/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author FRANKCHUKY
 */
public class FileWrite extends Application{
    Scene scene;
    People main;
    
    public FileWrite(People p){
    main=p;
    }
   @Override
           public void start(Stage st){
           st.setScene(scene);
           st.show();
           }
    String filename="DataBase.ser";
    FileOutputStream fos=null;
    ObjectOutputStream oos=null;
    FileInputStream fis=null;
    ObjectInputStream ois=null;
    Vector <People> v=new Vector<>();
    Vector<People> get=new Vector<>();
    File recheck;
    public void writeToFile(People p){
        String path=System.getProperty("user.home")+"/DataBase Storage";       
        v.addElement(p);
        File check=new File(path);
        if(check.exists()){
        System.out.println("Am Existing");
        }else{
        check.mkdir();
        System.out.println("directory made");
        }
        recheck=new File(check.getAbsolutePath()+"/"+filename);
        
    try{     
         if(recheck.exists()){
        System.out.println("Copy Vector");
        }
            fos=new FileOutputStream(recheck.getAbsolutePath());        
            oos=new ObjectOutputStream(fos);
            oos.writeObject(v);
            oos.close();
        System.out.println("Done Writing");
    }catch(Exception e){
       System.out.println("Not Written");
    }
    }
    
    
    
    public void readFromFile(){
    try{
        
            fis=new FileInputStream(recheck.getAbsolutePath());
            ois=new ObjectInputStream(fis);
            get=(Vector<People>)ois.readObject();
            ois.close();
        
    }catch(IOException | ClassNotFoundException e){
       System.out.println("Not Found");
    }
    People temp=get.elementAt(0);
   
    int [][]data=main.getImage();
    int width=data.length;
    int height=data[0].length;
    //int width=
    WritableImage wr=new WritableImage(width,height);
  PixelWriter pw=wr.getPixelWriter();
   for(int i=0; i<width; i++){
      for(int j=0; j<height; j++){
          pw.setArgb(i, j, data[i][j]);
      }
  }
      ImageView display=new ImageView();
      display.setImage(wr);
      StackPane stack=new StackPane();
      stack.getChildren().add(display);
       scene = new Scene(stack,400,400);
      start(new Stage());
    
    System.out.println(temp.getBirthdate());
    }
}
