package schtime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Schtime {
    
    int select_process(int s[][], int ct, int q, int d)
{
    int m = 2000;
    int ind = -1;
    for(int i = 0; i < d; i ++){
            if(s[i][0]<= ct && s[i][2]!=0){
                if(m>s[i][2]){
                    m = s[i][2];
                    ind = i;
                }
                            
            }
    }
return ind;
}

void STRN(int ind, int s[][], int ct, int q)
{
    if(q>s[ind][2]){
        s[ind][2]-=q;
        ct+=q;
        }
    else{
        ct+=s[ind][2];
        s[ind][2]= 0;
        }

        if(s[ind][2] == 0){
            s[i][3] = ct;
        }

}
    
    public static void main(String[] args) throws IOException {
        
        Scanner in = new Scanner(System.in);
        int choice;
        boolean b = true;
        
        while (b)
        {
            System.out.println("\nChoose your scheduling algorithm ? \n\n1)FCFS (First come, First Served)\n2) SJF (Shortest Job First\n3)SRTF ()\n4)RR()\n");
           choice = in.nextInt();

            switch (choice)
            {
                case 1:
                    int a;
                    System.out.println("CPU Scheduling Algorithm - First Come First Served");
                    System.out.println("Enter the number of processes : ");
                    a = in.nextInt();
  
                   //int[]tab = new int[a];
                    int[]burstTimes = new int[a];
                    int[]arrivalTimes = new int[a];
                   int[] processes = new int[a];
                    
                    int[] exitTimes = new int[a];
                    int[] TurnAroundTimes = new int[a];
                    int[] waitingTimes = new int[a];
                    
                     //read Arrival times
                     for (int i = 0; i < a; i++){
                        System.out.print("Enter Process  " + (i + 1) + "'s   Arrival Time : ");
                        arrivalTimes[i] = in.nextInt();
                        processes[i] = i;
                    }   
            
                     System.out.println();

                     //read burst times
                    for (int i = 0; i < a; i++){
                        System.out.print("Enter Process   " + (i + 1) + "'s   Burst Time : ");
                        burstTimes[i] = in.nextInt();
                    }

                    Arrays.sort(arrivalTimes);

                    // calculate exit times
                    exitTimes[0] = burstTimes[0];
                    for (int i = 1; i < a; i++){
                         exitTimes[i] = exitTimes[i - 1] + burstTimes[i];
                    }
                    
                     //calculate turnaround times for each process
                    for (int i = 0; i < a; i++){
                         TurnAroundTimes[i]= exitTimes[i] - arrivalTimes[i];
                    }
                    
                     //calculate waiting times for each process
                    for (int i = 0; i < a; i++){
                        waitingTimes[i]= TurnAroundTimes[i] - burstTimes[i];
                    }
                     
                     // Displaying  Arrival, Burst, Exit, TurnAround and Waiting times : 
                    System.out.println("\nArrival Times:");
                    for (int i = 0; i < a; i++){
                        System.out.print(arrivalTimes[i] + "  |  ");
                    }
                    
                    System.out.println("\nBurst Times:");
                    for (int i = 0; i < a; i++){
                        System.out.print(burstTimes[i] + "  |  ");
                    }  

                    System.out.println("\nExit Times:");
                    for (int i = 0; i < a; i++){
                        System.out.print(exitTimes[i] + "  |  ");
                    }
                    
                    System.out.println("\nTurnAround Times:");
                    for (int i = 0; i < a; i++) {
                        System.out.print(TurnAroundTimes[i] + "  |  ");
                    }
                    
                    System.out.println("\nWaiting Times:");
                    for (int i = 0; i < a; i++){
                        System.out.print(waitingTimes[i] + "  |  ");
                    }
                    
                    //Printing the average WT & TT
     float wt = 0,tt = 0;
     for(int i = 0; i < a; i++){
      wt+= waitingTimes[i];
      tt+= TurnAroundTimes[i];
     }
     wt /= a;
     tt /= a;
     System.out.println("The Average WT is: " + wt);
     System.out.println("The Average TT is: " + tt);
                 break;
                 
                case 2:
                    
                    System.out.println("You chose the SRF Process ! \n Enter the number of processes : ");
                    int c = in.nextInt();
                    
                    int[]burstTimes1 = new int[c];
                    int[]arrivalTimes1 = new int[c];
                    int[] processes1 = new int[c];
                    
                    int[] exitTimes1 = new int[c];
                    int[] TurnAroundTimes1 = new int[c];
                    int[] waitingTimes1 = new int[c];
                    
                     //read Arrival times
                     for (int i = 0; i < c; i++){
                        System.out.print("Enter Process  " + (i + 1) + "'s   Arrival Time : ");
                        arrivalTimes1[i] = in.nextInt();
                        processes1[i] = i;
                    }
                     
                     System.out.println();
                     
                     //read burst times
                    for (int i = 0; i < c; i++){
                        System.out.print("Enter Process   " + (i + 1) + "'s   Burst Time : ");
                        burstTimes1[i] = in.nextInt();
                    }
                   
                    //ExitTimes 
                     for (int i = 0; i < c; i++){
                        for (int j = 0; j < c; j++)
                            if (arrivalTimes1[i] < arrivalTimes1[j])
                            {
                                // swap in arrival times
                                int tempAr = arrivalTimes1[i];
                                arrivalTimes1[i] = arrivalTimes1[j];
                                arrivalTimes1[j] = tempAr;
                                
                                //swap in burst times too
                                int tempBr = burstTimes1[i];
                                burstTimes1[i] = burstTimes1[j];
                                burstTimes1[j] = tempBr;
                            }
                     }
                     
                     for (int i = 1; i < c; i++){
                        for (int j = 1; j <c; j++)
                            if (burstTimes1[i] < burstTimes1[j])
                            {
                                // swap in arrival times
                                int tempAr = arrivalTimes1[i];
                                arrivalTimes1[i] = arrivalTimes1[j];
                                arrivalTimes1[j] = tempAr;
                                
                                //swap in burst times too
                                int tempBr = burstTimes1[i];
                                burstTimes1[i] = burstTimes1[j];
                                burstTimes1[j] = tempBr;
                            }
                     }

                     //exit time
                     exitTimes1[0] = burstTimes1[0];
                     for(int i =1; i < c;  i++){
                             exitTimes1[i] = exitTimes1[i-1] + burstTimes1[i];
                         }
                    
                    //calculate turnaround times for each process
                    for (int i = 0; i < c; i++){
                         TurnAroundTimes1[i]= exitTimes1[i] - arrivalTimes1[i];
                    }
                    
                     //calculate waiting times for each process
                    for (int i = 0; i < c; i++){
                        waitingTimes1[i]= TurnAroundTimes1[i] - burstTimes1[i];
                        if(waitingTimes1[i]<0) waitingTimes1[i] = 0;
                    }
                    
                     System.out.println("\nArrival Times:");
                    for (int i = 0; i < c; i++){
                        System.out.print(arrivalTimes1[i] + "  |  ");
                    }
                    
                     System.out.println("\nBurst Times:");
                    for (int i = 0; i < c; i++){
                        System.out.print(burstTimes1[i] + "  |  ");
                    }
                    
                    System.out.println("\nExit times:");
                    for (int i = 0; i < c; i++){
                        System.out.print(exitTimes1[i]+ "  |  ");
                    }
                    
                     System.out.println("\nTurnAround Times:");
                    for (int i = 0; i < c; i++) {
                        System.out.print(TurnAroundTimes1[i] + "  |  ");
                    }
                    
                    System.out.println("\nWaiting Times:");
                    for (int i = 0; i < c; i++){
                        System.out.print(waitingTimes1[i] + "  |  ");
                    }
                    
                    //Printing the average WT & TT
     float wt2 = 0,tt2 = 0;
     for(int i = 0; i < c; i++)
     {
      wt2 += waitingTimes1[i];
      tt2 += TurnAroundTimes1[i];
     }
     wt2 /= c;
     tt2 /= c;
     System.out.println("The Average WT is: " + wt2);
     System.out.println("The Average TT is: " + tt2 );
                     
                    break;
                    
                case 3:
                    System.out.println("You chose the SRTF Process ! \n Enter the number of processes : ");
                    
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n;
      System.out.println("Please enter the number of Processes: ");
       n = Integer.parseInt(br.readLine());
       int proc[][] = new int[n + 1][4];//proc[][0] is the AT array,[][1] - RT,[][2] - WT,[][3] - TT
       for(int i = 1; i <= n; i++)
       {
      System.out.println("Please enter the Arrival Time for Process " + i + ": ");
      proc[i][0] = Integer.parseInt(br.readLine());
      System.out.println("Please enter the Burst Time for Process " + i + ": ");
      proc[i][1] = Integer.parseInt(br.readLine());
     }
       System.out.println();
     
       //Calculation of Total Time and Initialization of Time Chart array
     int total_time = 0;
     for(int i = 1; i <= n; i++)
     {
      total_time += proc[i][1];
     }
     int time_chart[] = new int[total_time];
     
     for(int i = 0; i < total_time; i++)
     {
      //Selection of shortest process which has arrived
      int sel_proc = 0;
      int min = 99999;
      for(int j = 1; j <= n; j++)
      {
       if(proc[j][0] <= i)//Condition to check if Process has arrived
       {
        if(proc[j][1] < min && proc[j][1] != 0)
        {
         min = proc[j][1];
         sel_proc = j;
        }
       }
      }
      
      //Assign selected process to current time in the Chart
      time_chart[i] = sel_proc;
      
      //Decrement Remaining Time of selected process by 1 since it has been assigned the CPU for 1 unit of time
      proc[sel_proc][1]--;
      
      //WT and TT Calculation
      for(int j = 1; j <= n; j++)
      {
       if(proc[j][0] <= i)
       {
        if(proc[j][1] != 0)
        {
         proc[j][3]++;//If process has arrived and it has not already completed execution its TT is incremented by 1
            if(j != sel_proc)//If the process has not been currently assigned the CPU and has arrived its WT is incremented by 1
             proc[j][2]++;
        }
        else if(j == sel_proc)//This is a special case in which the process has been assigned CPU and has completed its execution
         proc[j][3]++;
       }
      }
      
      //Printing the Time Chart
      if(i != 0)
      {
       if(sel_proc != time_chart[i - 1])
        //If the CPU has been assigned to a different Process we need to print the current value of time and the name of 
        //the new Process
       {
        System.out.print("--" + i + "--P" + sel_proc);
       }
      }
      else//If the current time is 0 i.e the printing has just started we need to print the name of the First selected Process
       System.out.print(i + "--P" + sel_proc);
      if(i == total_time - 1)//All the process names have been printed now we have to print the time at which execution ends
       System.out.print("--" + (i + 1));
      
     }
     System.out.println();
     System.out.println();
     
     //Printing the WT and TT for each Process
     System.out.println("P\t WT \t TT ");
     for(int i = 1; i <= n; i++)
     {
      System.out.printf("%d\t%2dms\t%2dms",i,proc[i][2],proc[i][3]);
      System.out.println();
     }
     
     System.out.println();
     
     //Printing the average WT & TT
     float WT = 0,TT = 0;
     for(int i = 1; i <= n; i++)
     {
      WT += proc[i][2];
      TT += proc[i][3];
     }
     WT /= n;
     TT /= n;
     System.out.println("The Average WT is: " + WT + "ms");
     System.out.println("The Average TT is: " + TT + "ms");
 
                    break;
                    
                case 4 :
                     System.out.println("You chose the RR  Process ! \n Enter the number of processes : ");
                   BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Enter the Time Quantum: ");
       int q = Integer.parseInt(br2.readLine());
      System.out.println("Please enter the number of Processes: ");
       int n2 = Integer.parseInt(br2.readLine());
       int proc2[][] = new int[n2 + 1][4];//proc[][0] is the AT array,[][1] - RT,[][2] - WT,[][3] - TT
       for(int i = 1; i <= n2; i++)
       {
      System.out.println("Please enter the Burst Time for Process " + i + ": ");
      proc2[i][1] = Integer.parseInt(br2.readLine());
     }
       System.out.println();
     
       //Calculation of Total Time and Initialization of Time Chart array
     int total_time2 = 0;
     for(int i = 1; i <= n2; i++)
     {
      total_time2 += proc2[i][1];
     }
     int time_chart2[] = new int[total_time2];
     
     int sel_proc = 1;
     int current_q = 0;
     for(int i = 0; i < total_time2; i++)
     {
      //Assign selected process to current time in the Chart
      time_chart2[i] = sel_proc;
      
      //Decrement Remaining Time of selected process by 1 since it has been assigned the CPU for 1 unit of time
      proc2[sel_proc][1]--;
      
      //WT and TT Calculation
      for(int j = 1; j <= n2; j++)
      {
       if(proc2[j][1] != 0)
       {
        proc2[j][3]++;//If process has not completed execution its TT is incremented by 1
        if(j != sel_proc)//If the process has not been currently assigned the CPU its WT is incremented by 1
         proc2[j][2]++;
       }
       else if(j == sel_proc)//This is a special case in which the process has been assigned CPU and has completed its execution
        proc2[j][3]++;
      }
      
      //Printing the Time Chart
      if(i != 0)
      {
       if(sel_proc != time_chart2[i - 1])
        //If the CPU has been assigned to a different Process we need to print the current value of time and the name of 
        //the new Process
       {
        System.out.print("--" + i + "--P" + sel_proc);
       }
      }
      else//If the current time is 0 i.e the printing has just started we need to print the name of the First selected Process
       System.out.print(i + "--P" + sel_proc);
      if(i == total_time2 - 1)//All the process names have been printed now we have to print the time at which execution ends
       System.out.print("--" + (i + 1));
      
      //Updating value of sel_proc for next iteration
      current_q++;
      if(current_q == q || proc2[sel_proc][1] == 0)//If Time slice has expired or the current process has completed execution
      {
       current_q = 0;
       //This will select the next valid value for sel_proc
       for(int j = 1; j <= n2; j++)
       {
        sel_proc++;
        if(sel_proc == (n2 + 1))
            sel_proc = 1;
        if(proc2[sel_proc][1] != 0)
         break;
       }
      }
     }
     System.out.println();
     System.out.println();
     
     //Printing the WT and TT for each Process
     System.out.println("P\t WT  \t TT  ");
     for(int i = 1; i <= n2; i++)
     {
      System.out.printf("%d\t%3dms\t%3dms",i,proc2[i][2],proc2[i][3]);
      System.out.println();
     }
     
     System.out.println();
     
     //Printing the average WT & TT
     float WT2 = 0,TT2 = 0;
     for(int i = 1; i <= n2; i++)
     {
      WT2 += proc2[i][2];
      TT2 += proc2[i][3];
     }
     WT2 /= n2;
     TT2 /= n2;
     System.out.println("The Average WT is: " + WT2);
     System.out.println("The Average TT is: " + TT2 );
     break;
                    
            default:
                    System.out.println("Which Process Would You Run ?");
            break;
            }
        }
    }    
}