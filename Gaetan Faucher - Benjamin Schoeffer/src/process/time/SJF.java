/**
 * File : SJF.java
 * Date : 13/11/17
 * @author : Gaëtan Faucher
 */

package process.time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SJF {
    private final Scanner sc = new Scanner(System.in);
    int numbProcess, arrivalTime, burstTime, exitTime = 0, waitTime = 0;
    ArrayList<Process> listOfProcess = new ArrayList<>();
    
    public void processSetting(){
        System.out.print("\t SJF \n"
                + "Enter the Number of Processes: ");
        numbProcess = sc.nextInt();
    
        for (int i = 0; i < numbProcess; i++){
            listOfProcess.add(i, new Process());
            
            System.out.print("Enter Process " + i + " ’s Arrival Time: ");
            arrivalTime = sc.nextInt();
            System.out.print("Enter Process " + i + " ’s Burst Time: ");
            burstTime = sc.nextInt();
            
            listOfProcess.get(i).setProcess(i, arrivalTime, burstTime);
        } 
        Collections.sort(listOfProcess, Process.ComparatorBurst);
    }
    
    public void print(){
        System.out.println("\n###################################################################\n"
                + "     Process\t |    Arrival\t |\tBurst\t |\tExit \n"
                + "_________________|_______________|_______________|________________");
        for (int i = 0; i < numbProcess; i++){
            System.out.println("\t" + listOfProcess.get(i).getNumb() + "\t "
                + "|\t" + listOfProcess.get(i).getArrivalTime() + "\t "
                + "|\t" + listOfProcess.get(i).getBurstTime() + "\t "
                + "|\t" + listOfProcess.get(i).getExitTime(exitTime));
            listOfProcess.get(i).setExitTime(listOfProcess.get(i).getExitTime(exitTime));
            
            exitTime = listOfProcess.get(i).getExitTime(exitTime);
            
        }
        
        for (int j = 1; j < numbProcess; j++){
            waitTime += (listOfProcess.get(j-1).getExitTime() - listOfProcess.get(j).getArrivalTime());
        }
        System.out.println("###################################################################\n"
                + "Average Wait Time : " + waitTime / numbProcess);
    }
    
    public void SJF(){
        processSetting();
        print();
    }
}
