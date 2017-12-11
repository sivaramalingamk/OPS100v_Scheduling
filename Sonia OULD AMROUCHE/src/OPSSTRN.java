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
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class OPSSTRN {
    
    public static void main(String[] args) {
        
    
    Scanner sc = new Scanner(System.in);
    int i = 0;
    int n = 20;
    System.out.println("Enter the Number of Processes:");  
    int process = sc.nextInt();
    
    int arrival[] = new int[n];
    int burst[] = new int[n];
    int exit[] = new int[n];
    int tabprocess[] = new int[n];
    int time = 0;
    float turn=0;
    float wait = 0;
    int Quantum = 0;
    int temp = 0;
    int finish = 0;
    int cpt =0;
    
    
    for(i =0; i<process; i++)
    {
        System.out.println("Enter Process " +i+" ’s Arrival Time: ");
        arrival[i] = sc.nextInt();
        
        System.out.println("Enter Process " +i+" ’s Burst Time: ");
        burst[i] = sc.nextInt();
        tabprocess[i] = i;
        exit[i]=1;
        
    }
       /* System.out.println("Quantum :");
       Quantum = sc.nextInt();*/
     System.out.print("You have selected STRN Algorithm for the processes :");
    
      for(i =0; i<process; i++){
        System.out.print(i+" ,");
       }
      
      System.out.println("\n process | arrival | burst |");
       for(i =0; i<process; i++){
        System.out.println( tabprocess[i]+ " | "+ arrival[i]+" | " +burst[i]+ " | ");
       }
      for(i=1; i<process; i++)
       {    
           for(int j=1; j<process; j++)
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
      
     /* for (i=0; i<process; i++)
      {
          time += burst[i];
      }*/
      
    
      
     /* for(i=0;i<process;i++)
      {
          finish = burst[i];
          burst[i]-=Quantum;
          for(int j=0;j<process;j++)
          {
              if(burst[j]>0){
              exit[j]+= Quantum;}
              
          }
          if(burst[i]<=0)
          {
              temp = Math.abs(burst[i-Quantum]);
              burst[i] = 0;
              burst[i+1] -= temp;
              
              exit[i] +=finish;
              cpt++;
          }
          if(cpt == time)break;
          System.out.println(finish);
          
          
      }*/
        List order = new LinkedList();

              
        int totBTime = 0;
        for(int f = 0; f < burst.length; f++) totBTime += burst[f];
        
        int x = 0; // to know the process to execute
        int Bmin = burst[0];
        for(int f = 0; f < totBTime; f++) //for each quantum of 1
        {
            for(int g = 0; g < burst.length; g++) // searching for the minimum burst time and decreasing it
            {
                if(burst[g] > 0 && burst[g] <= Bmin && arrival[g] <= f) 
                {
                    Bmin = burst[g];
                    x = g;
                }
            }
            burst[x] -= 1;
            order.add(tabprocess[x]);
            for(int g = 0; g < burst.length; g++) // searching for the minimum burst time and decreasing it
            {
                if(burst[g] > 0) exit[g]++;
            }
            for(int h = 0; h < burst.length; h++)
            {
                if(Bmin < burst[h]) Bmin = burst[h];
            }
        }
     
        System.out.println("Here is the scheduling");
        
        for(i = 0; i < order.size(); i++) 
        {
            System.out.print(order.get(i)+"->");
        } 
        System.out.println(""+order.get(order.size() - 1)); 
        
        
        
        
      System.out.println("\n process | arrival | burst | exit ");
       for(i =0; i<process; i++){
       
        System.out.println( tabprocess[i]+ " | "+ arrival[i]+" | " +burst[i]+ " | "+exit[i]+ " | ");
        
       }
      
    
} 
}

