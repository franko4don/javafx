/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeentrypoint;

import java.util.Vector;

/**
 *
 * @author FRANKCHUKY
 */
public class SuffixTree {
final private String raw;
private Vector<Node> children;
    public SuffixTree(String str){
    raw=str;
    }
    int p=0;
    public void Initialize(){
        children=new Vector<>();
            Node n=new Node(raw.substring(raw.length()-2),raw.length()-2);
            children.addElement(n); 
            for(int length=raw.length()-3; length>=0; length--){
                int count=0;
                for(int i=0; i<children.size(); i++){                    
                    if(children.elementAt(i).getKey().charAt(0)==raw.charAt(length)){                          
                        BuildTree(children.elementAt(i),length);
                    }
                    else{
                        count++;
                    }
                }
                if(count==children.size()){
                    children.addElement(new Node(raw.substring(length),length));
                }
            }
        }
    
    public void BuildTree(Node node, int indexOfStr){
        boolean found=false; 
        for(int i=indexOfStr,j=0; i<raw.length() && j<node.getKey().length(); i++,++j){
            if(node.getKey().charAt(j)!= raw.charAt(i)){
                found=true;
                Node split1=new Node(node.getKey().substring(j),node.getIndex());
                Node split2=new Node(raw.substring(i),indexOfStr);
                node.setKey(node.getKey().substring(0,j));
                node.setIndex(-2);
                node.addNode(split1);
                node.addNode(split2);
                break;
            }
        }
        if(!found){
            boolean hasDownChild=false;
            String cutoff=raw.substring(indexOfStr+(node.getKey().length()-1));
           // System.out.println(cutoff);
            for(int i=0; i<node.getChildren().size(); ++i){
                if(node.getChildren().elementAt(i).getKey().charAt(0)==cutoff.charAt(0)){
                    BuildTree(node.getChildren().elementAt(i),indexOfStr);
                    hasDownChild=true;
                    break;
                }
            }
            
            if(!hasDownChild){
                node.addNode(new Node(cutoff,indexOfStr));
                      //  System.out.println("executed");
            }
        }
        // System.out.println("Node"+p);
         p++;
        for(int k=0; k<node.getChildren().size(); k++){
            System.out.println(node.getChildren().elementAt(k).getIndex()+(1)+" "+node.getChildren().elementAt(k).getKey());
        }
    }
}
