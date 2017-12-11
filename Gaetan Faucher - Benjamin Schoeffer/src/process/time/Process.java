/**
 * File : Process.java
 * Date : 13/11/17
 * @author : Gaëtan Faucher
 */

package process.time;

import java.util.Comparator;

public class Process{
    
    /* Attributes */
    private int number, arrivalTime, burstTime, exitTime, remainingBurstTime;
    private boolean finish = false;
    
    /* Methods */
    
        /* Setters */
    public void setProcess(int n, int a, int b){
        number  = n;
        arrivalTime = a;
        burstTime = b;
        remainingBurstTime = b;
    }
    
    public void setState(boolean state){
        finish = state;
    }
    
    public void setExitTime(int eT){
        exitTime = eT;
    }
    
    /*########################################*/
        /* Getters */
    public int getNumb(){
        return number;
    }
    
    public int getArrivalTime(){
        return arrivalTime;
    }
    
    public int getBurstTime(){
        return burstTime;
    }
    
    public int getRemainingBurstTime(){
        return remainingBurstTime;
    }
    
    public int getExitTime(int prevExitTime){
        return prevExitTime + burstTime;
    }
    
    public int getExitTime(){
        return exitTime;
    }
    
    public boolean getState(){
        return finish;
    }
    
    /*########################################*/
        /* Functions */
    public void substractQuantum(int q){
        remainingBurstTime -= q;
    }
     
    public static Comparator<Process> ComparatorArrival = new Comparator<Process>() {
      
        @Override
        public int compare(Process p1, Process p2) {
            return p1.getArrivalTime() - (p2.getArrivalTime());
        }
    };
    
    public static Comparator<Process> ComparatorBurst = new Comparator<Process>() {
      
        @Override
        public int compare(Process p1, Process p2) {
            return p1.getBurstTime()- (p2.getBurstTime());
        }
    };
}
