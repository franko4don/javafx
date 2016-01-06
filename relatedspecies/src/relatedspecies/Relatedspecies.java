/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatedspecies;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author FRANKCHUKY
 */
public class Relatedspecies {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char one='a';
       for(int i=0; i<26; i++){
       System.out.println((int)one+" "+one);
       one+=1;
       }
	}
    
     public static long modpower(long number,long pow, long mod){
       long temp=1;
       String get=Long.toBinaryString(pow);
       char[]op=get.toCharArray();      
       Vector<Long> v=new Vector<>();
       long times=number;
       v.addElement(times);
       for(int j=0; j<op.length-1; j++){       
       times*=times;
       times%=mod;
       v.addElement(times);
       }
       for(int k=0; k<op.length; k++){
       if(op[k]=='1'){      
       temp*=v.elementAt(v.size()-1-k);
       temp%=mod;
       System.out.println(temp);
       }
       }
       System.out.println(v);
       double f=5665.54;
       int dec=(int)f;
       return temp%mod;
       }
     
    
}
