/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeentrypoint;

/**
 *
 * @author FRANKCHUKY
 */
public class TreeEntryPoint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SuffixTree tree=new SuffixTree("CAGTCAGG$");
        tree.Initialize();
    }
    
}
