/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AUVRAY Elise
 */
public class OPS {
    private List<Process> processes;
    private int nbProcess;
    
    //constructor
    OPS(){
        processes = new ArrayList<Process>();
    }
    
    //methodes
    void initialisation(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        nbProcess = sc.nextInt();
        
        for (int i = 0; i < nbProcess; i++){
            System.out.print("Enter process " + i + "'s arrival Time: ");
            int arrivalTime = sc.nextInt();
            
            System.out.print("Enter process " + i + "'s burst Time: ");
            int burstTime = sc.nextInt();
            
            Process process = new Process(i, arrivalTime, burstTime);
            processes.add(process);
        }
        System.out.println();
        
    }
    
    void displayInitialisation(int choix){
        switch (choix){
             case 1:
                    System.out.print("You have selected FCFS Algorithm for the process ");
                    break;

                case 2:
                    System.out.print("You have selected SJF Algorithm for the process ");
                    break;

                case 3:
                    System.out.print("You have selected SRTTN Algorithm for the process ");
                    break;

                case 4:
                    System.out.print("You have selected RR Algorithm for the process ");
                    break;

                case 5:
                    System.out.print("You have selected multileve queue Algorithm for the process ");
                    break;

                default:
                    break;
        }
        
        for (int i = 0; i < nbProcess-1; i++){
            System.out.print(i + ", ");
        }
        System.out.println(nbProcess - 1);
        
        System.out.println("\nProcess | Arrival | Burst");
        for (int i = 0; i < nbProcess; i ++){
            processes.get(i).display();
        }
    }
   
    void sortArrivalTime(){
        int nb = nbProcess;

        for(; nb > 1 ; nb--){

            int i=0;
            int indiceMax = 0;
            while(i < nb)
            {
                if(processes.get(i).getArrivalTime() > processes.get(indiceMax).getArrivalTime())
                    indiceMax = i;
                i++;
            }

            int tmp;
            tmp = processes.get(nb-1).getArrivalTime();
            processes.get(nb-1).setArrivalTime(processes.get(indiceMax).getArrivalTime());
            processes.get(indiceMax).setArrivalTime(tmp);
            
            tmp = processes.get(nb-1).getBurstTime();
            processes.get(nb-1).setBurstTime(processes.get(indiceMax).getBurstTime());
            processes.get(indiceMax).setBurstTime(tmp);
            
            tmp = processes.get(nb-1).getId();
            processes.get(nb-1).setId(processes.get(indiceMax).getId());
            processes.get(indiceMax).setId(tmp);
            
            tmp = processes.get(nb-1).getExit();
            processes.get(nb-1).setExit(processes.get(indiceMax).getExit());
            processes.get(indiceMax).setExit(tmp);
        }
    }
    
    void sortBurstTime(){
        int nb = nbProcess;

        for(; nb > 1 ; nb--){

            int i=0;
            int indiceMax = 0;
            while(i < nb)
            {
                if(processes.get(i).getBurstTime() > processes.get(indiceMax).getBurstTime())
                    indiceMax = i;
                i++;
            }

            int tmp;
            tmp = processes.get(nb-1).getArrivalTime();
            processes.get(nb-1).setArrivalTime(processes.get(indiceMax).getArrivalTime());
            processes.get(indiceMax).setArrivalTime(tmp);
            
            tmp = processes.get(nb-1).getBurstTime();
            processes.get(nb-1).setBurstTime(processes.get(indiceMax).getBurstTime());
            processes.get(indiceMax).setBurstTime(tmp);
            
            tmp = processes.get(nb-1).getId();
            processes.get(nb-1).setId(processes.get(indiceMax).getId());
            processes.get(indiceMax).setId(tmp);
        }
    }
    
    void sortInvertBurstTime(){
        int nb = nbProcess;

        for(; nb > 1 ; nb--){

            int i=0;
            int indiceMin = 0;
            while(i < nb)
            {
                if(processes.get(i).getBurstTime() <= processes.get(indiceMin).getBurstTime())
                    indiceMin = i;
                i++;
            }

            int tmp;
            tmp = processes.get(nb-1).getArrivalTime();
            processes.get(nb-1).setArrivalTime(processes.get(indiceMin).getArrivalTime());
            processes.get(indiceMin).setArrivalTime(tmp);
            
            tmp = processes.get(nb-1).getBurstTime();
            processes.get(nb-1).setBurstTime(processes.get(indiceMin).getBurstTime());
            processes.get(indiceMin).setBurstTime(tmp);
            
            tmp = processes.get(nb-1).getId();
            processes.get(nb-1).setId(processes.get(indiceMin).getId());
            processes.get(indiceMin).setId(tmp);
        }
    }
    
    void sortId(){
        int nb = nbProcess;

        for(; nb > 1 ; nb--){

            int i=0;
            int indiceMax = 0;
            while(i < nb)
            {
                if(processes.get(i).getId() > processes.get(indiceMax).getId())
                    indiceMax = i;
                i++;
            }

            int tmp;
            tmp = processes.get(nb-1).getArrivalTime();
            processes.get(nb-1).setArrivalTime(processes.get(indiceMax).getArrivalTime());
            processes.get(indiceMax).setArrivalTime(tmp);
            
            tmp = processes.get(nb-1).getBurstTime();
            processes.get(nb-1).setBurstTime(processes.get(indiceMax).getBurstTime());
            processes.get(indiceMax).setBurstTime(tmp);
            
            tmp = processes.get(nb-1).getId();
            processes.get(nb-1).setId(processes.get(indiceMax).getId());
            processes.get(indiceMax).setId(tmp);
            
            tmp = processes.get(nb-1).getExit();
            processes.get(nb-1).setExit(processes.get(indiceMax).getExit());
            processes.get(indiceMax).setExit(tmp);
            
            tmp = processes.get(nb-1).getTurnaroundTime();
            processes.get(nb-1).setTurnaroundTime(processes.get(indiceMax).getTurnaroundTime());
            processes.get(indiceMax).setTurnaroundTime(tmp);
            
            tmp = processes.get(nb-1).getWaitingTime();
            processes.get(nb-1).setWaitingTime(processes.get(indiceMax).getWaitingTime());
            processes.get(indiceMax).setWaitingTime(tmp);
        }
    }
    
    void fcfs(){
        sortArrivalTime();
        
        System.out.println("\nHere is the scheduling: ");
        
        for (int i = 0; i < nbProcess-1; i++){
            System.out.print(i + "->");
        }
        System.out.println(nbProcess);
        
        int exit = processes.get(0).getArrivalTime() + processes.get(0).getBurstTime();
        processes.get(0).setExit(exit);
        
        int turnaroundTime, waitingTime;
        
        for (int i = 1; i < nbProcess; i++){
            exit += processes.get(i).getBurstTime();
            processes.get(i).setExit(exit);
        }
        
        for (int i = 0; i < nbProcess; i++){
            turnaroundTime = processes.get(i).getExit() - processes.get(i).getArrivalTime();
            processes.get(i).setTurnaroundTime(turnaroundTime);
            
            waitingTime = processes.get(i).getTurnaroundTime() - processes.get(i).getBurstTime();
            processes.get(i).setWaitingTime(waitingTime);
        } 
        
        sortId();
        
        System.out.println("\nProcess | Arrival | Burst | Exit");
        for (int i = 0; i < nbProcess; i++){
            processes.get(i).displayFinal();
        }
        
    }
    
    void sjf(){
        sortArrivalTime();
        
        int tmp = processes.get(1).getArrivalTime() - processes.get(0).getArrivalTime();
        int exit = processes.get(0).getArrivalTime();
        processes.get(0).setBurstTime(processes.get(0).getBurstTime() - tmp);
        System.out.println("\nHere is the scheduling: ");
        System.out.print(processes.get(0).getId() + "->");
        sortBurstTime();
        
        for (int i = 0; i < nbProcess-1; i++){
            System.out.print(processes.get(i).getId() + "->");
        }
        System.out.println(processes.get(nbProcess-1).getId());
        
        exit += processes.get(0).getArrivalTime() + processes.get(0).getBurstTime();
        processes.get(0).setExit(exit);
        
        int turnaroundTime, waitingTime;
        
        for (int i = 1; i < nbProcess; i++){
            exit += processes.get(i).getBurstTime();
            processes.get(i).setExit(exit);
        }
        
        for (int i = 0; i < nbProcess; i++){
            turnaroundTime = processes.get(i).getExit() - processes.get(i).getArrivalTime();
            processes.get(i).setTurnaroundTime(turnaroundTime);
            
            waitingTime = processes.get(i).getTurnaroundTime() - processes.get(i).getBurstTime();
            if (waitingTime < 0) waitingTime = 0; 
            processes.get(i).setWaitingTime(waitingTime);
            
            
        } 
        
        sortArrivalTime();
        processes.get(0).setBurstTime(processes.get(0).getBurstTime()+tmp);
        
        sortId();
        
        System.out.println("\nProcess | Arrival | Burst | Exit");
        for (int i = 0; i < nbProcess; i++){
            processes.get(i).displayFinal();
        }
        
    }
    
    void srtn(){
        sortArrivalTime();
        
        int tmp = processes.get(0).getArrivalTime();
        int exit = processes.get(0).getArrivalTime();        
        
        System.out.print("\nHere is the scheduling: ");
        System.out.print(processes.get(0).getId() + "->");
        
        sortInvertBurstTime();
        tmp = processes.get(0).getArrivalTime() - tmp;
       
        sortArrivalTime();
        processes.get(0).setBurstTime(processes.get(0).getBurstTime() - tmp);
        sortInvertBurstTime();
        
        for (int i = 0; i < nbProcess-1; i++){
            System.out.print(processes.get(i).getId() + "->");
        }
        System.out.println(processes.get(nbProcess-1).getId());
        
        exit += tmp + processes.get(0).getBurstTime();
        processes.get(0).setExit(exit);
        
        int turnaroundTime, waitingTime;
        
        for (int i = 1; i < nbProcess; i++){
            exit += processes.get(i).getBurstTime();
            processes.get(i).setExit(exit);
        }
        
        for (int i = 0; i < nbProcess; i++){
            turnaroundTime = processes.get(i).getExit() - processes.get(i).getArrivalTime();
            processes.get(i).setTurnaroundTime(turnaroundTime);
            
            waitingTime = processes.get(i).getTurnaroundTime() - processes.get(i).getBurstTime();
            if (waitingTime < 0) waitingTime = 0; 
            processes.get(i).setWaitingTime(waitingTime);
        
        } 
       
        sortArrivalTime();
        processes.get(0).setBurstTime(processes.get(0).getBurstTime()+tmp);
        
        sortId();
        
        System.out.println("\nProcess | Arrival | Burst | Exit");
        for (int i = 0; i < nbProcess; i++){
            processes.get(i).displayFinal();
        }
        
    }
    
    void rr() {
        sortArrivalTime();
        
        int exit = processes.get(0).getArrivalTime(), waitingTime = 0, turnaroundTime = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the quantum: ");
        int quantum = sc.nextInt();
        
        System.out.println("Here is the scheduling: ");
        int check = 0;
        
        while (check < nbProcess){
            for (int i = 0; i < nbProcess; i++){
                if (processes.get(i).getBurstTime() > quantum){
                    processes.get(i).setBurstTime(processes.get(i).getBurstTime() - quantum);
                    System.out.print("->"+processes.get(i).getId());
                    exit += quantum;
                }
                else if (processes.get(i).getBurstTime() != 0){
                    exit += processes.get(i).getBurstTime();
                    System.out.print("->"+processes.get(i).getId());
                    processes.get(i).setBurstTime(0);
                    processes.get(i).setExit(exit);
                    check++;
                }
            }
        }
        
        for (int i = 0; i < nbProcess; i++){
            turnaroundTime = processes.get(i).getExit() - processes.get(i).getArrivalTime();
            processes.get(i).setTurnaroundTime(turnaroundTime);
            
            waitingTime = processes.get(i).getTurnaroundTime() - processes.get(i).getBurstTime();
            if (waitingTime < 0) waitingTime = 0; 
            processes.get(i).setWaitingTime(waitingTime);
        
        } 
        
        sortId();
        
        System.out.println("\nProcess | Arrival | Burst | Exit");
        for (int i = 0; i < nbProcess; i++){
            processes.get(i).displayFinal();
        }
        
    }
    
    void averageTurnaroundTime(){
        float average = 0;
        
        for (int i = 0; i < nbProcess; i++){
            average += processes.get(i).getTurnaroundTime();
        }

        System.out.println("Average turnaround time is: " + average / nbProcess);
    } 
    
    void averageWaitingTime(){
        float average = 0;
        
        for (int i = 0; i < nbProcess; i++){
            average += processes.get(i).getWaitingTime();
        }
        
        System.out.println("Average waiting time is: " + average / nbProcess);
    } 
   
}
