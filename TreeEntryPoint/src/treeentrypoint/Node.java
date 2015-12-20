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
public class Node {
 private Vector<Node> children;
 private String key;
 private int index;
 private boolean leafFlag;
    public Node(String str, int index){
    key=str;
    this.index=index;
    leafFlag=false;
    }

    /**
     * @return the children
     */
    public Vector<Node> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Vector<Node> children) {
        
        this.children = children;
    }

    public void addNode(Node child){
        if(children==null){
            children=new Vector<>();
        }
        children.addElement(child);
    }
    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the leafFlag
     */
    public boolean isLeafFlag() {
        return leafFlag;
    }

    /**
     * @param leafFlag the leafFlag to set
     */
    public void setLeafFlag(boolean leafFlag) {
        this.leafFlag = leafFlag;
    }
    
    
}
