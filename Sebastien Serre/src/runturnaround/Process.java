/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runturnaround;

import java.util.Comparator;

/**
 * 
 * @author Raphael Poulain and Sebastien Serre
 * 217313302 and 217313248
 * 
 */

public class Process {
    
    //Variable
    private final int processNumber;
    private final int arrivalTime;
    private int burstTime;
    private int exitTime;
    private int waitingTime;
    
    Process(int processNumber, int arrivalTime, int burstTime) {
        this.processNumber = processNumber;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.exitTime = 0;
    }
    
    //Getters
    public int getProcessNumber() {
        return processNumber;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getBurstTime() {
        return burstTime;
    }
    public int getExitTime() {
        return exitTime;
    }
    public int getWaitingTime() {
        return (getExitTime() - getArrivalTime());
    }
    
    //Setters
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }
    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }
    
    //Methods
    public void showAllProcess() {
        System.out.println("\nProcess | Arrival | Burst");
        System.out.println("   "+processNumber+"    |    "
                +arrivalTime+"    |   "+ burstTime);
    }
    
    //Comparator ProcessNumber
    public static Comparator<Process> ComparatorProcessNumber = new Comparator<Process>() {
      
        @Override
        public int compare(Process pr1, Process pr2) {
            return (int) (pr1.getProcessNumber() - pr2.getProcessNumber());
        }
    };
    
    //Comparator ArrivalTime
    public static Comparator<Process> ComparatorArrivalTime = new Comparator<Process>() {
      
        @Override
        public int compare(Process pr1, Process pr2) {
            return (int) (pr1.getArrivalTime() - pr2.getArrivalTime());
        }
    };
    
    //Comparator BurstTime
    public static Comparator<Process> ComparatorBurstTime = new Comparator<Process>() {
      
        @Override
        public int compare(Process pr1, Process pr2) {
            return (int) (pr1.getBurstTime() - pr2.getBurstTime());
        }
    };
    
}
