/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Guillaume RIOU
 */
public class RR {
    
    public static void begin(){
    
        int nb = nbProcess();
    
        int[] ATime;
        int[] BTime;
        int[] ETime;
    
        ATime = new int[nb];
        BTime = new int[nb];
        ETime = new int[nb];

        Scanner s1 = new Scanner (System.in);

        boolean done = false;

        for(int i=0; i<nb;i++)
        {
            System.out.print("Enter Process "+i+"’s Arrival Time: ");
            ATime[i] = s1.nextInt();
            System.out.print("Enter Process "+i+"’s Burst Time: ");
            BTime[i] = s1.nextInt();
            ETime[i] = 1;
        }
    
        //array process
    
        int[] NbPr;
        NbPr = new int[nb];
        for (int j=0; j<nb;j++) NbPr[j]=j;    
    
        System.out.print("You have selected SRTN Algorithm for the processes ");
    
        int j;
        for(j=0; j<ATime.length-1;j++) 
        {
        System.out.print(""+j+",");
        }
        System.out.print(""+j);
    

        print(ATime,BTime,ETime,done,NbPr);
    
        scheduling(ATime,BTime,ETime,NbPr);
        done=true;
    
        print(ATime,BTime,ETime,done,NbPr);
    }
    
    public static int nbProcess() { 
    
    System.out.print("Enter the Number of Processes: ");
    
    int nb;
    Scanner scan = new Scanner(System.in);
    nb = scan.nextInt();
    
    return nb;
    
    }
    
    public static void print(int[] ATime, int[] BTime, int []  ETime, boolean done, int[] NbPr){
    
        
    if(done==false)
        {
        System.out.println("\nProcess  |  Arrival  |  Burst  |");    
        for(int i=0; i<ATime.length; i++) System.out.println("   "+i+"     |     "+ATime[i]+"     |    "+BTime[i]+"    |");
        }
    else
        {
            
        System.out.println("\nProcess  |  Arrival  |  Burst  |   Exit");
        for(int i=0; i<ATime.length; i++)
            {   
            if(i==ATime.length-1)System.out.println("   "+NbPr[i]+"     |     "+ATime[i]+"     |    "+BTime[i]+"    |   "+ETime[i]);
            else{
                System.out.println("   "+NbPr[i]+"     |     "+ATime[i]+"     |    "+BTime[i]+"    |    "+ETime[i]);
                }
            
            }
        
        ///AVERAGE TURNING TIME
        
        int[] TurnTime;
        float ATT = 0;
        TurnTime = new int[ATime.length];        
        
        int turnaroundTime = 0;

        for (int i = 0; i < ATime.length; i++){
            turnaroundTime = ETime[i] - ATime[i];
            TurnTime[i]=turnaroundTime;
            System.out.println("Turntime["+i+"] = "+TurnTime[i]);
            
          //  waitingTime = TurnTime[i] - BTime[i];
          //  if (waitingTime < 0) waitingTime = 0; 
           // WaitTime[i] = waitingTime;
           // System.out.println("Waittime["+i+"] = "+WaitTime[i]);
            
          //  WTT+=WaitTime[i];
            ATT+=TurnTime[i];
        }
        
        System.out.println("Average turnaround time is: "+ATT/TurnTime.length);
       // System.out.println("Average waiting time is: "+WTT/WaitTime.length);

        }
    }

    public static void scheduling(int[] ATime, int[] BTime, int[] ETime, int[] NbPr){

        List order = new LinkedList();

        
        int[] WaitTime;
        float WTT = 0;
        WaitTime = new int[ATime.length];
        Arrays.fill(WaitTime,0);
        
        int[] Order;
        Order = new int [10000];
        
        int[] OrderCheck;
        OrderCheck = new int [Order.length];
        
        int waitingTime = 0;
        
        int tmp;
        for (int c=0;c<=ATime.length;c++)
        {
            for(int d=c+1;d<ATime.length;d++)
            {
                if(ATime[c]>ATime[d]) 
                {
                    tmp=ATime[c];
                    ATime[c]=ATime[d];
                    ATime[d]=tmp;

                    tmp=BTime[c];
                    BTime[c]=BTime[d];
                    BTime[d]=tmp;

                    tmp=NbPr[c];
                    NbPr[c]=NbPr[d];
                    NbPr[d]=tmp;
                }
            }
        }


        int exit = ATime[0];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the quantum: ");
        int quantum = sc.nextInt();

        System.out.println("Here is the scheduling: ");
        int check = 0;
        int nb=0;

        while (check < ATime.length){ //while all process are not free of any burst
            for (int i = 0; i < ATime.length; i++){
                if (BTime[i] > quantum){
                    
                    for(int o=0;o<ATime.length;o++)
                        {
                        if(o!=i && BTime[o]!=0) WaitTime[o]+=quantum;                                   
                        }
                            
                    BTime[i] -= quantum;
                    System.out.print("->"+i);
                    exit += quantum;
                    
                    nb++;
                    
                }
                else if (BTime[i] != 0){
                    
                for(int o=0;o<ATime.length;o++)
                    {
                    if(o!=i && BTime[o]!=0)  WaitTime[o]+=BTime[i];          
                    }                  
                    
                    exit += BTime[i];
                    System.out.print("->"+i);
                    BTime[i] = 0;
                    ETime[i] = exit;
                    check++; //checks if all process are free of burst
                    
                    Order[nb]=i;

                    nb++;
                }
    
            }

        }
        System.out.println("");
        float TT=0;
        for(int m=0; m<BTime.length;m++) 
            {
            System.out.println("WTT"+m+"="+WaitTime[m]);
            TT+=WaitTime[m];
            }
        System.out.println("Average waiting time is: "+TT/WaitTime.length);    
        
    }

}
