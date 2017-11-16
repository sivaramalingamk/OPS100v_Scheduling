/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ops;

/**
 *
 * @author AUVRAY Elise
 */
public class Process {
    
    private int id;
    private int arrivalTime;
    private int burstTime;
    private int exit;
    private int turnaroundTime;
    private int waitingTime;
    
    //Constructor
    Process(int id, int arrivalTime, int burstTime){
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.exit = 0;
        this.turnaroundTime = 0;
        this.waitingTime = 0;
    }
    
    
    //getters
    int getId(){
        return id; 
    }
    
    int getArrivalTime(){
        return arrivalTime; 
    }
    
    int getBurstTime(){
        return burstTime; 
    }
    
    int getExit(){
        return exit; 
    }
    
    int getTurnaroundTime(){
        return turnaroundTime; 
    }
    
    int getWaitingTime(){
        return waitingTime; 
    }
    
    
    //setters
    void setId(int newId){
        id = newId;
    }
    
    void setArrivalTime(int newArrivalTime){
        arrivalTime = newArrivalTime;
    }
    
    void setBurstTime(int newBurstTime){
        burstTime = newBurstTime;
    }
    
    void setExit(int newExit){
        exit = newExit;
    }
    
    void setTurnaroundTime(int newTurnaroundTime){
        turnaroundTime = newTurnaroundTime;
    }
    
    void setWaitingTime(int newWaitingTime){
        waitingTime = newWaitingTime;
    }
    
    
    //methode
    void display(){
        System.out.println("    " + id + "   |    " + arrivalTime + "    |    " + burstTime);
    }
    
    void displayFinal(){
        System.out.println("    " + id + "   |    " + arrivalTime + "    |   " + burstTime + "   |  " + exit );
    }
}
