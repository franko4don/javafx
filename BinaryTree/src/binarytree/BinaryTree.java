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
public class BinaryTree {

   Node head;
   
   void add(int key, String name){
   Node input=new Node(key,name);
   if(head==null){
   head=input;
   }else{
   Node focus=head;
   
   while(true){
   if(focus.Key<key){
        if(focus.right==null){
            focus.right=input;
                return;
   }else{
        focus=focus.right;
        }
        
   }else{
   if(focus.left==null){
        focus.left=input;
            System.out.println("left"+key);
                return;
   }else{
        focus=focus.left;
   }
   }
   }
   }
   }
   
   
   void inOrderTraversal(Node traverse){
   if(traverse!=null){
   inOrderTraversal(traverse.left);
   System.out.println(traverse.Key);
   inOrderTraversal(traverse.right);
   
   }
   }
   
   
    public static void main(String[] args) {
    BinaryTree bst=new BinaryTree();
    bst.add(5, "five");
    bst.add(1, "five");
    bst.add(8, "five");
    bst.add(3, "five");
    bst.add(4, "five");
    bst.add(9, "five");
    
    bst.inOrderTraversal(bst.head);
    }
    
   
}
