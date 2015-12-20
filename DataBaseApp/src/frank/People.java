/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frank;

import java.io.Serializable;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

/**
 *
 * @author FRANKCHUKY
 */
public class People implements Serializable{
    private String surname;
    private String firstname;
    private String othername;
    private String address;
    private String town;
    private String lga;
    private String state;
    private String country;
    private String birthdate;
    private String phonenumber1;
    private String phonenumber2;
    private String email;
    private String sex;
    private int[][]data;
    
    public String getSurname() {
        return surname;
    }

   
    public void setSurname(String surname) {
        this.surname = surname;
    }

    
    public String getFirstname() {
        return firstname;
    }

   
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

   
    public String getOthername() {
        return othername;
    }

   
    public void setOthername(String othername) {
        this.othername = othername;
    }

  
    public String getAddress() {
        return address;
    }

   
    public void setAddress(String address) {
        this.address = address;
    }

   
    public String getTown() {
        return town;
    }

   
    public void setTown(String town) {
        this.town = town;
    }

    
    public String getLga() {
        return lga;
    }

   
    public void setLga(String lga) {
        this.lga = lga;
    }

    
    public String getState() {
        return state;
    }

   
    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    public String getBirthdate() {
        return birthdate;
    }


    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }


    public String getPhonenumber1() {
        return phonenumber1;
    }


    public void setPhonenumber1(String phonenumber1) {
        this.phonenumber1 = phonenumber1;
    }


    public String getPhonenumber2() {
        return phonenumber2;
    }


    public void setPhonenumber2(String phonenumber2) {
        this.phonenumber2 = phonenumber2;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
  public void setImage(Image im){
      
  int width=(int)im.getWidth();
  int height=(int)im.getHeight();
  int pixel[][]=new int[width][height];
  PixelReader pr=im.getPixelReader();
  for(int i=0; i<width; i++){
      for(int j=0; j<height; j++){
          pixel[i][j]=pr.getArgb(i, j);
      }
  }
  data=pixel;
  }
  
  
  public int[][] getImage(){
  return data;
  }
  
  public void setSex(String gender){
  this.sex=gender;
  }
  
  public String getSex(){
  return sex;
  }
}
