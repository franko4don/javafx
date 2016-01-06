/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frank;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.Vector;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author FRANKCHUKY
 */
public class FileOperations {
       String filename="DataBase.ser";
    People people;
    Vector <String>positions;
    
    public FileOperations(People p){
       //  System.out.println("Entered constructor");
    this.people=p;
    }
    
    //handles the file which stores the positions and sizes of the bytes written to file
    public void fillVectorWithPositionsAndLength(){
    String positionPath=System.getProperty("user.home")+"/DataBase Storage/"+"index.v";
    String direc=System.getProperty("user.home")+"/DataBase Storage/";
    try{
    File check=new File(direc);
    if(!check.exists()){
        check.mkdir();
    }
    File checkIfExists=new File(positionPath);
    if(!checkIfExists.exists()){     
        checkIfExists.createNewFile();
        positions=new Vector<>();
    }else{
        positions=new Vector<>();
        Scanner sc=new Scanner(checkIfExists);
        while(sc.hasNextLine()){
            String temp=sc.nextLine();
            positions.addElement(temp);
            }
          }
        }catch(Exception e){
        System.out.println("Error at fill vector positions");
        }
    System.out.println("Done with fill shaa");
    }
    
    
    //writes the objects to file and stores the positions and size to the other file
    public void writeToFile(){
        String path=System.getProperty("user.home")+"/DataBase Storage";            
        File recheck=new File(path+"/"+filename);
        
     try{     
          if(!recheck.exists()){
             recheck.createNewFile();
             System.out.println("Database file created");
        }
            
          RandomAccessFile file=new RandomAccessFile(recheck,"rw");
          
          ByteArrayOutputStream bos=new ByteArrayOutputStream();
          ObjectOutputStream oos=new ObjectOutputStream(bos);
          oos.writeObject(people);
          byte []tempPeople=bos.toByteArray();
          System.out.println("Objects converted to bytes");
          if(positions.isEmpty()){
              System.out.println("Vector is empty");
                positions.addElement("0 "+tempPeople.length);
                file.seek(0);
                file.write(tempPeople);
          }else{
                String obtain[]=positions.elementAt(positions.size()-1).split(" "); 
                long position=Long.parseLong(obtain[0]);
                int size=Integer.parseInt(obtain[1]);
                file.seek(position);
                file.write(tempPeople); 
                long newPosition=size+position+10;
                positions.addElement(newPosition+" "+size);
          }
          oos.close();
          writePositionsToFile();
          System.out.println("Done Writing");
        }catch(IOException | NumberFormatException e){
            System.out.println("Not Written");
    }
    }
    
    
    public void writePositionsToFile()throws IOException{
        String positionPath=System.getProperty("user.home")+"/DataBase Storage/"+"index.v";
        File checkIfExists=new File(positionPath);
        checkIfExists.createNewFile();
        PrintWriter pw=new PrintWriter(checkIfExists);
        for(int i=0; i<positions.size(); i++){
            pw.println(positions.elementAt(i));
    }
         pw.close();
    }
    
    
    
    public void readFromFile()throws IOException{
        fillVectorWithPositionsAndLength();
        String path=System.getProperty("user.home")+"/DataBase Storage";            
        File recheck=new File(path+"/"+filename);
        RandomAccessFile rand=new RandomAccessFile(recheck,"rw");
        
        if(!recheck.exists()){
            System.out.println("Entry doesnt exist");
            return;
        }
        for(int i=0; i<positions.size(); i++){
    try{
        
            String obtain[]=positions.elementAt(i).split(" ");
            long position=Long.parseLong(obtain[0]);
            int size=Integer.parseInt(obtain[1]);
            byte []tempStorage=new byte[size];
            rand.seek(position);
            rand.readFully(tempStorage);
            ByteArrayInputStream bis=new ByteArrayInputStream(tempStorage);
            ObjectInputStream ois=new ObjectInputStream(bis);
            People retrieved=(People)ois.readObject();
            int [][]data=retrieved.getImage();
            int width=data.length;
            int height=data[0].length;
            WritableImage wr=new WritableImage(width,height);
            PixelWriter pw=wr.getPixelWriter();
            for(int j=0; j<width; j++){
                for(int k=0; k<height; k++){
                     pw.setArgb(j, k, data[j][k]);
                }
             }
     
            System.out.println(retrieved.getBirthdate());
            ois.close();
        
    }catch(IOException | ClassNotFoundException e){
       System.out.println("Not Found");
    }
   
   
        }
    }
}
