/**
 * File : RR.java
 * Date : 13/11/17
 * @author : Gaëtan Faucher
 */

package process.time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RR {
    private final Scanner sc = new Scanner(System.in);
    int numbProcess, arrivalTime, burstTime, exitTime = 0, quantum;
    ArrayList<Process> listOfProcess = new ArrayList<>();
    
    public void processSetting(){
        System.out.print("\t RR \n"
                + "Enter the Quantum Time: ");
        quantum = sc.nextInt();
        System.out.print("Enter the Number of Processes: ");
        numbProcess = sc.nextInt();
    
        for (int i = 0; i < numbProcess; i++){
            listOfProcess.add(i, new Process());
            
            System.out.print("Enter Process " + i + " ’s Arrival Time: ");
            arrivalTime = sc.nextInt();
            System.out.print("Enter Process " + i + " ’s Burst Time: ");
            burstTime = sc.nextInt();
            
            listOfProcess.get(i).setProcess(i, arrivalTime, burstTime);
        } 
        Collections.sort(listOfProcess, Process.ComparatorArrival);
    }
    
    public void calculateExitTime(){
        int eT = 0, exit = 0, i = 0;
        
        while (exit != numbProcess){
            if (listOfProcess.get(i).getState() == false){
                if (listOfProcess.get(i).getRemainingBurstTime() < quantum) eT += listOfProcess.get(i).getRemainingBurstTime();
                else eT += quantum;
                listOfProcess.get(i).substractQuantum(quantum);
                if (listOfProcess.get(i).getRemainingBurstTime() <= 0){
                    listOfProcess.get(i).setState(true);
                    exit++;
                    listOfProcess.get(i).setExitTime(eT);
                }
                if (i < numbProcess - 1){
                    if (listOfProcess.get(i+1).getArrivalTime() > eT) i--;
                }
            }
            
            if (i == numbProcess - 1) i = 0;
            else i++;
        }
        
    }
    
    public void print(){
        System.out.println("\n###################################################################\n"
                + "     Process\t |    Arrival\t |\tBurst\t |\tExit \n"
                + "_________________|_______________|_______________|________________");
        for (int i = 0; i < numbProcess; i++){
            System.out.println("\t" +listOfProcess.get(i).getNumb() + "\t "
                + "|\t" + listOfProcess.get(i).getArrivalTime() + "\t "
                + "|\t" + listOfProcess.get(i).getBurstTime() + "\t "
                + "|\t" + listOfProcess.get(i).getExitTime());
        }
    }
    
    public void RR(){
        processSetting();
        calculateExitTime();
        print();
    }
}
