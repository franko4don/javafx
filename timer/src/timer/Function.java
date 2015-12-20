/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;
/**
 *
 * @author FRANKCHUKY
 */
public class Function {
    
    
    public String time(double prescaler,double freq,double time){
        double value=freq/4;
        double number=1/(value*1000000);
        double second=number*prescaler*prescaler;
        double count=time/second;
        int counter=(int)count;
        String get="    movlw "+"d'"+counter+"'\n"+"    movwf counter\n"+"frank:\n"+"    btfss 0bh,2\n"+"    goto frank\n"+"    bcf 0bh,2\n"+"    decfsz counter,1\n"+"    goto frank\n"+"    bcf 0bh,2\n"+"    return";
        return get;
    }
}
