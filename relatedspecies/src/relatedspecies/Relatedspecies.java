/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatedspecies;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author FRANKCHUKY
 */
public class Relatedspecies {
        
        public static void main(String[]args){
  	Scanner sc=new Scanner(System.in);
	   int l=10000001;
        int number[]=new int[l];
        
        for(int i=1; i<l; i++){
           for(int j=i; j<l; j+=i){
           number[j]+=1;
           }
            
        }
        System.out.println(number[5]);
	    sc.close();
	}
    
}
