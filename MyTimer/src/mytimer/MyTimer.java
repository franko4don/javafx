/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytimer;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author FRANKCHUKY
 */
public class MyTimer {

    /**
     * @param args the command line arguments
     */
    Timer timer;
    static MyTimer tmr;
    public MyTimer(int seconds){
    timer=new Timer();
    timer.schedule(new TimerExecute(), seconds*1000);
    }
    
    public static void main(String[] args) {
        tmr= new MyTimer(20);
        for(int i=0; i<6; i++){
       
        System.out.println("Printed After "+i+" seconds");
        
        //    
        }
    }
    

class TimerExecute extends TimerTask{
@Override

    public void run(){
        timer.cancel();
    }
}
}
