/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runturnaround;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Raphael Poulain and Sebastien Serre
 * 217313302 and 217313248
 * 
 */

public class RunTurnaround {

    public static void main(String[] args) {
        menu();
    }
    
    public static void menu() {
    
        int choice = 0;
        
        while(choice != 6) {
            System.out.println("\nChoose Your Scheduling algorithm.");
            System.out.println("1. FCFS");
            System.out.println("2. SJF");
            System.out.println("3. SRTN");
            System.out.println("4. RR");
            System.out.println("5. Multilevel Queue");
            System.out.println("6. Exit\n");
            System.out.print("Enter the number to select the algorithm: ");
        
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            
            switch (choice) {
                case 1: fcfs();
                    break;
                case 2: sjf();
                    break;
                case 3: srtn();
                    break;
                case 4: rr();
                    break;
                case 5: mult();
                    break;
                case 6: break;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    
    public static ArrayList<Process> setProcess() {
    
        int nbr, arrivalTime, burstTime;
        
        System.out.print("\nEnter the number of processes: ");
        Scanner input = new Scanner(System.in);
        nbr = input.nextInt();
        
        ArrayList<Process> allProcess = new ArrayList<Process>();
        
        for(int i = 1; i <= nbr; i++) {
            System.out.print("Enter Process "+ i +"’s Arrival Time: ");
            arrivalTime = input.nextInt();
            System.out.print("Enter Process "+ i +"’s Burst Time: ");
            burstTime = input.nextInt();
            allProcess.add(new Process(i, arrivalTime, burstTime));
        }
        
        return(allProcess);
    }
    public static int setQuantum() {
        int quantum;
        
        System.out.print("\nWhat is your CPU's quantum : ");
        Scanner input = new Scanner(System.in);
        quantum = input.nextInt();
        
        return quantum;
    }
    
    public static double getAverageTime(ArrayList<Process> allProcess) {
        
        double averageTime = 0;
        
        for(int i = 0; i < allProcess.size(); i++)
            averageTime = averageTime + allProcess.get(i).getWaitingTime();
        
        averageTime = averageTime / allProcess.size();
        
        return averageTime;
    }
    
    public static int sumBurstTime(ArrayList<Process> allProcess) {
        
        int sum = 0;
        
        for(int i = 0; i < allProcess.size(); i++)
            sum = sum + allProcess.get(i).getBurstTime();
        
        return sum;
    }
    
    public static int firstArrivalTime(ArrayList<Process> allProcess) {
        
        int firstArrivalTime = allProcess.get(0).getArrivalTime();
        
        for (int i = 1; i < allProcess.size(); i++) {
            if (allProcess.get(i).getArrivalTime() < firstArrivalTime)
                firstArrivalTime = allProcess.get(i).getArrivalTime();
        }
        
        return firstArrivalTime;
    }
    
    public static void showProcess(ArrayList<Process> allProcess) {
        System.out.println("\nProcess | Arrival | Burst");
        
        for(int i = 0; i < allProcess.size(); i++) {
            System.out.print("   "+allProcess.get(i).getProcessNumber());
            System.out.print("    |    "+allProcess.get(i).getArrivalTime());
            System.out.println("    |   "+allProcess.get(i).getBurstTime());
        }
    }
    
    public static void showFinal(ArrayList<Process> allProcess) {
        System.out.println("\nProcess | Arrival | Burst | Exit");
        
        for(int i = 0; i < allProcess.size(); i++) {
            System.out.print("   "+allProcess.get(i).getProcessNumber());
            System.out.print("    |    "+allProcess.get(i).getArrivalTime());
            System.out.print("    |   "+allProcess.get(i).getBurstTime());
            System.out.println("   |  "+allProcess.get(i).getExitTime());
        }
    }
    
    //First Come First Serve
    public static void fcfs() {
        
        int time = 0;
        ArrayList<Process> allProcess = setProcess();
        showProcess(allProcess);
        
        Collections.sort(allProcess, Process.ComparatorArrivalTime);
        
        time = allProcess.get(0).getArrivalTime() + allProcess.get(0).getBurstTime();
        allProcess.get(0).setExitTime(time);
        
        for(int i = 1; i < allProcess.size(); i++) {
            
            if (allProcess.get(i).getArrivalTime() > time) {
                time = allProcess.get(i).getArrivalTime() + allProcess.get(i).getBurstTime();
                allProcess.get(i).setExitTime(time);
            }
            else {
                time = time + allProcess.get(i).getBurstTime();
                allProcess.get(i).setExitTime(time);
            }
            
        }
        
        showFinal(allProcess);
        System.out.println("\nThe average time is " + getAverageTime(allProcess));
    }
    
    //Shorter Job Next
    public static void sjf() {
        
        int time = 0;
        ArrayList<Process> allProcess = setProcess();
        showProcess(allProcess);
        
        Collections.sort(allProcess, Process.ComparatorBurstTime);
        
        while (sumBurstTime(allProcess) != 0) {
            
            for(int i = 0; i < allProcess.size(); i++) {
            
                if (allProcess.get(i).getArrivalTime() <= time) {
                    
                }
                
                showFinal(allProcess);
            }
        }
        System.out.println("\nThe average time is " + getAverageTime(allProcess));
        
        //showFinal(allProcess);
    }
    
    //Shorter Remain Time
    public static void srtn() {
        
        int time = 0;
        ArrayList<Process> allProcess = setProcess();
        showProcess(allProcess);
        
        Collections.sort(allProcess, Process.ComparatorBurstTime);
        
        time = allProcess.get(0).getArrivalTime() + allProcess.get(0).getBurstTime();
        allProcess.get(0).setExitTime(time);
        
        for(int i = 1; i < allProcess.size(); i++) {
            
            if (allProcess.get(i).getArrivalTime() > time) {
                time = allProcess.get(i).getArrivalTime() + allProcess.get(i).getBurstTime();
                allProcess.get(i).setExitTime(time);
            }
            else {
                time = time + allProcess.get(i).getBurstTime();
                allProcess.get(i).setExitTime(time);
            }
            
        }
        
        showFinal(allProcess);
        System.out.println("\nThe average time is " + getAverageTime(allProcess));
    }
    
    //Round Robin Scheduling
    public static void rr() {
        
        int time = 0;
        int quantum = setQuantum();
        ArrayList<Process> allProcess = setProcess();
        showProcess(allProcess);
        
        Collections.sort(allProcess, Process.ComparatorArrivalTime);
        
        while (sumBurstTime(allProcess) != 0) {
            
            for(int i = 0; i < allProcess.size(); i++) {
            
                if (allProcess.get(i).getArrivalTime() > time) {
                    i = -1;
                    time++;
                }
                else {
                    if (allProcess.get(i).getBurstTime() >= quantum) {
                        time = time + quantum;
                        allProcess.get(i).setBurstTime(allProcess.get(i).getBurstTime() - quantum);
                        allProcess.get(i).setExitTime(time);
                    }
                    else if (allProcess.get(i).getBurstTime() < quantum && allProcess.get(i).getBurstTime() > 0) {
                        time = time + allProcess.get(i).getBurstTime();
                        allProcess.get(i).setBurstTime(0);
                        allProcess.get(i).setExitTime(time);
                    }
                }
                showFinal(allProcess);
            }
        }
        
        //showFinal(allProcess);
        System.out.println("\nThe average time is " + getAverageTime(allProcess));
    }
    
    //Multiple-Level Queues Scheduling
    public static void mult() {
        
        int time = 0;
        ArrayList<Process> allProcess = setProcess();
        showProcess(allProcess);
        
        Collections.sort(allProcess, Process.ComparatorBurstTime);
        
        time = allProcess.get(0).getArrivalTime() + allProcess.get(0).getBurstTime();
        allProcess.get(0).setExitTime(time);
        
        for(int i = 1; i < allProcess.size(); i++) {
            
            if (allProcess.get(i).getArrivalTime() > time) {
                time = allProcess.get(i).getArrivalTime() + allProcess.get(i).getBurstTime();
                allProcess.get(i).setExitTime(time);
            }
            else {
                time = time + allProcess.get(i).getBurstTime();
                allProcess.get(i).setExitTime(time);
            }
            
        }
        
        showFinal(allProcess);
        System.out.println("\nThe average time is " + getAverageTime(allProcess));
    }
}
