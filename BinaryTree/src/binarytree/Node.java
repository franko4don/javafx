/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author FRANKCHUKY
 */
public class Node {
    Node left;
    Node right;
   int Key;
   String Value;
    
   public Node(int key, String name){
   Key=key;
   Value=name;
   }
   
    public Node(Node node){
   this.Key=node.Key;
   this.Value=node.Value;
   }
   
   public String ToString(int key,String name){
       this.Key=key;
       this.Value=name;
       return key+" "+name;
   }
}
