/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytimer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author FRANKCHUKY
 */
public class MyTimer{
    static RandomAccessFile fos=null;
    static int length1=0;
    static int length2=0;
    public static void main(String [] args)throws IOException{
       
    String path="check.txt";
     fos=new RandomAccessFile(path,"rw");
    String word1[]=new String[]{"onions","maggi","pepper","yipee"};
    String word2[]= new String[]{"crayfish","salt","peppr","aligator pepper"};
    
    File file=new File("ind.txt");
    PrintWriter pw=new PrintWriter(file);
    for(int i=0; i<word2.length; i++){
    if(!file.exists()){
    file.createNewFile();
    
    }else{  
    pw.println(word2[i]);
    
    
    }
    }
    pw.close();
   /** try{
    length1=writeToFile(word1,0);
    length2=writeToFile(word2,length1+1000);
    readFromFile(0,length1);
    readFromFile(length1+1000,length2);
    }catch(Exception e){
    
    }*/
    
  }
    public static int writeToFile(String[]input, int position) throws IOException, ClassNotFoundException{
        
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(input);
        byte[] bytes=bos.toByteArray();
        fos.seek(position);
        fos.write(bytes);
       return bytes.length;
    }
    
    
        public static void readFromFile(int position,int length) throws IOException, ClassNotFoundException{
            fos.seek(position);
            byte []first=new byte[length];
            fos.readFully(first);
            ByteArrayInputStream bis=new ByteArrayInputStream(first);
            ObjectInputStream ois=new ObjectInputStream(bis);
            ois.close();
            String create1[]=(String [])ois.readObject();
            System.out.println(Arrays.toString(create1));
            
    }
}

