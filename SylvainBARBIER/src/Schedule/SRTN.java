/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Sylvain BARBIER
 */
public class SRTN {
        
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
        for(int i=0; i<ATime.length; i++) TurnTime[i]=ATurnTime(ATime,ETime,i);
        
        for(int j=0; j<TurnTime.length;j++) 
            {
                System.out.println("ATT"+j+"="+TurnTime[j]);
                ATT+=TurnTime[j];
            }
        System.out.println("Average turnaround time is: "+ATT/TurnTime.length);
        
        //WAITING TIME
        
        int[] WaitTime;
        float WTT = 0;
        WaitTime = new int[ATime.length];
        WaitTime[0]=0;
        
        
        ///AVERAGE
        
        
        }
    }
    
    public static void scheduling(int[] ATime, int[] BTime, int[] ETime, int[] NbPr){
            
        List order = new LinkedList();
        
        
        int WTT[] = new int[ATime.length];
        Arrays.fill(WTT, 0);
        int[] orderTab = new int [order.size()];

        
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
       
       //on trie par ordre d'arrivé pour mettre le premier en premier
       
        int totBTime = 0;
        for(int f = 0; f < BTime.length; f++) totBTime += BTime[f];
        
        int x = 0; // to know the process to execute
        int Bmin = BTime[0];
        for(int f = 0; f < totBTime; f++) //for each quantum of 1
        {
            for(int g = 0; g < BTime.length; g++) // searching for the minimum burst time and decreasing it
            {
                if(BTime[g] > 0 && BTime[g] <= Bmin && ATime[g] <= f) 
                {
                    Bmin = BTime[g];
                    x = g;
                }
            }
            BTime[x] -= 1;
            
            order.add(NbPr[x]);
            
            for(int y=0;y<BTime.length;y++)
            {
                if(BTime[y]>0 && BTime[y] != BTime[x]) WTT[y]+=1;
            }
            
            
            for(int g = 0; g < BTime.length; g++) // searching for the minimum burst time and decreasing it
            {
                if(BTime[g] > 0) ETime[g]++;
            }
            for(int h = 0; h < BTime.length; h++)
            {
                if(Bmin < BTime[h]) Bmin = BTime[h];
            }
        }
        
        for(int t=0;t<BTime.length;t++)
            {
                WTT[t]-=t;
                System.out.println("WTT["+t+"] = "+WTT[t]);
            }
     
        System.out.println("Here is the scheduling");
        int i;
        for(i = 0; i < order.size(); i++) 
        {
            System.out.print(order.get(i)+"->");
        } 
        System.out.println(""+order.get(order.size() - 1)); 
        
        //AVERAGE
        float TT=0;
        for(int m=0; m<BTime.length;m++) 
            {
                System.out.println("WTT"+m+"="+WTT[m]);
                TT+=WTT[m];
            }
        System.out.println("Average waiting time is: "+TT/WTT.length);
        
        
    }

    public static int ATurnTime(int[] ATime,int[] ETime,int i){


        int ATT;
        ATT=ETime[i]-ATime[i]; 
        return ATT;
    
    }
    
 
}
