/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import java.util.Scanner;

/**
 *
 * @author Guillaume RIOU
 */
public class SJF {
    
    public static void begin(){
    
    int nb = nbProcess();
    
    int[] ATime;
    int[] BTime;
    
    ATime = new int[nb];
    BTime = new int[nb];
    
    Scanner s1 = new Scanner (System.in);
    
    boolean done = false;
    
    for(int i=0; i<nb;i++)
        {
        System.out.print("Enter Process "+i+"’s Arrival Time: ");
        ATime[i] = s1.nextInt();
        System.out.print("Enter Process "+i+"’s Burst Time: ");
        BTime[i] = s1.nextInt();
        }
    
    //arry process
    
    int[] NbPr;
    NbPr = new int[nb];
    for (int j=0; j<nb;j++)
        {
        NbPr[j]=j;   
        }
    
    System.out.print("You have selected SJN Algorithm for the processes ");
    
    int j;
    
    for(j=0; j<ATime.length-1;j++) 
        {
        System.out.print(""+j+",");
        }
    System.out.print(""+j);
    

    print(ATime,BTime,done,NbPr);
    
    scheduling(ATime,BTime,NbPr);
    done=true;
    
    print(ATime,BTime,done,NbPr);
    
        
    }
    
    public static int nbProcess() { 
    
    System.out.print("Enter the Number of Processes: ");
    
    int nb;
    Scanner scan = new Scanner(System.in);
    nb = scan.nextInt();
    
    return nb;
    
    }
    
    public static void print(int[] ATime, int[] BTime, boolean done, int[] NbPr){
    
        
    if(done==false)
        {
        System.out.println("\nProcess  |  Arrival  |  Burst  |");    
        for(int i=0; i<ATime.length; i++) System.out.println("   "+i+"     |     "+ATime[i]+"     |    "+BTime[i]+"    |");
        }
    else
        {
            
        int[] ETime;
        ETime = new int[ATime.length];
        ETime[0]=BTime[0];
        
        System.out.println("\nProcess  |  Arrival  |  Burst  |   Exit");
        for(int i=0; i<ATime.length; i++)
            {   
            if(i==ATime.length-1)System.out.println("   "+NbPr[i]+"     |     "+ATime[i]+"     |    "+BTime[i]+"    |   "+ETime[i]);
            else{
                ETime[i+1]=ETime[i]+BTime[i+1];   
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
        for(int i=1; i<ATime.length; i++) WaitTime[i]=AWaitTime(ATime,ETime,i);
        
        
        ///AVERAGE
        for(int j=0; j<TurnTime.length;j++) 
            {
                System.out.println("WTT"+j+"="+WaitTime[j]);
                WTT+=WaitTime[j];
            }
        System.out.println("Average waiting time is: "+WTT/WaitTime.length);
        
        }
    }
    
    public static void scheduling(int[] ATime,int[] BTime,int[] NbPr){
    
        int tmp;
        
        //trier par arrival
        
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
        print(ATime,BTime,false,NbPr);
        
        for (int c=1;c<=BTime.length;c++)
        {
            for(int d=c+1;d<BTime.length;d++)
                {
                if(BTime[c]>BTime[d]) 
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
        
        System.out.println("Here is the scheduling");
        
        int i;
        for(i=0; i<ATime.length-1;i++) 
        {
        System.out.print(NbPr[i]+"->");
        } 
    System.out.println(""+NbPr[i]);
        
        
    }
    

    public static int ATurnTime(int[] ATime,int[] ETime,int i){


        int ATT;
        ATT=ETime[i]-ATime[i]; 
        return ATT;
    
    }
    
    public static int AWaitTime(int[] ATime,int[] ETime,int i){


        int AWT;
        AWT=ETime[i-1]-ATime[i]; 
        return AWT;
    
    }
    
}
