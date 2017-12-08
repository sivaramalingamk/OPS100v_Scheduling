package ops;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sonia
 */
import java.io.*;
import java.util.Scanner;

public class OPSquizz {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
    
    
    int i = 0;
    int n = 50;
    int arrival[] = new int[n];
    int burst[] = new int[n];
    int exit[] = new int[n];
    int tabprocess[] = new int[n];
    System.out.println("Enter the Number of Processes:");  
    int process = sc.nextInt();
    float turn=0;
    float wait = 0;
    
    for(i =0; i<process; i++)
    {
        System.out.println("Enter Process " +i+" ’s Arrival Time: ");
        arrival[i] = sc.nextInt();
        
        System.out.println("Enter Process " +i+" ’s Burst Time: ");
        burst[i] = sc.nextInt();
        tabprocess[i] = i;
        
    }
    System.out.print("You have selected FCFS Algorithm for the processes :");
    
      for(i =0; i<process; i++){
        System.out.print(i+" ,");
       }
      
      System.out.println("\n process | arrival | burst |");
       for(i =0; i<process; i++){
        System.out.println("\n" + tabprocess[i]+ " | "+ arrival[i]+" | " +burst[i]+ " | ");
       }
       
       for(i=0; i<process; i++)
       {    
           for(int j=0; j<process; j++)
            {
                if (arrival[i] < arrival[j])
                {
                    int tmp = tabprocess[j];
                    tabprocess[j]= tabprocess[i]; 
                    tabprocess[i]= tmp;
                    tmp = arrival[j];
                    arrival[j]= arrival[i]; 
                    arrival[i]= tmp;
                    tmp = burst[j];
                    burst[j]= burst[i]; 
                    burst[i]= tmp;
               
                }
       
            }
       }
       
        System.out.println("Here is the scheduling ");
        
        for(i =0; i<process-1; i++){
        System.out.print(tabprocess[i]+" ->");
        
       }
        System.out.print(tabprocess[process-1]);
        
        System.out.println("\n process | arrival | burst | exit ");
        exit[0]=burst[0];
       for(i =0; i<process; i++){
        exit[i+1]= burst[i+1] + exit[i];
        System.out.println("\n" + tabprocess[i]+ " | "+ arrival[i]+" | " +burst[i]+ " | "+exit[i]+ " | ");
        
       }
       
       for(i =0; i<process; i++){
           turn += exit[i] - arrival[i];
       }
       turn = turn/process;
        System.out.println("Average turnaround time is:" +turn);
        
        for(i =0; i<process-1; i++){
            wait += exit[i] - arrival[i+1];
        }
       wait = wait/process;
        System.out.println("Average waiting time is:"+wait);
    }
}