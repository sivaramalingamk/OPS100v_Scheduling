/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ops.quizz2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** File: OPSQuizz2
 * Date: 07/11/2017
 * @author Oceane Fradon
 */

public class RR {
    
     public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("\nEnter the Number of Processes : ");
        int NbProcess = Integer.parseInt(br.readLine());
        int proc[][] = new int[NbProcess + 1][5];
        
        for(int i = 0; i < NbProcess; i++) { 
            System.out.print("Enter Process " + i + "’s Arrival Time : ");
            proc[i][0] = Integer.parseInt(br.readLine());
            System.out.print("Enter Process " + i + "’s Burst Time : ");
            proc[i][1] = Integer.parseInt(br.readLine());
        } 
        
        System.out.print("\nYou have selected RR Algorithm for the processes ");
        for(int i = 0; i < NbProcess; i++) { 
            System.out.print(i + ", "); 
        }
        
        System.out.println("\nEnter the Quantum: ");
        int Quantum = Integer.parseInt(br.readLine());
        
        System.out.println("\n\n    Process    |    Arrival    |    Burst   |");
        for(int i = 0; i < NbProcess; i++) {
            System.out.println("       " + i + "       |       " + proc[i][0] + "       |      " + proc[i][1] + "     |");
        }
         System.out.println("");

        //Calculation of Total Time and Initialization of Time Chart array
        int TotTime = 0;
        for(int i = 0; i < NbProcess; i++) {
            TotTime += proc[i][1];
        }
        int TimeChart[] = new int[TotTime];
     
        int process = 1;
        int CurQuantum = 0;
        for(int i = 0; i < TotTime; i++) {
            
            //Assign selected process to current time in the Chart
            TimeChart[i] = process;
            
            //Decrement Remaining Time of selected process by 1 since it has been assigned the CPU for 1 unit of time
            proc[process][1]--;
            
            //WT and TT Calculation
            for(int j = 0; j < NbProcess; j++) {
                if(proc[j][1] != 0) {
                    proc[j][4]++;//If process has not completed execution its TT is incremented by 1
                    if(j != process)//If the process has not been currently assigned the CPU its WT is incremented by 1
                    proc[j][3]++;
                }
                else if(j == process) //This is a special case in which the process has been assigned CPU and has completed its execution
                    proc[j][4]++;
            }

            //Printing TimeChart
            if (i != 0){
                if (process != TimeChart[i-1]){
                    System.out.print("--" + i + "--P" + process);
                }
            }
            else
                System.out.print(i + "--P" + process);
            if (i == TotTime - 1)
                System.out.print("--" + ( i+1 ));
            
            
            CurQuantum ++;
            if (CurQuantum == Quantum || proc[process][1] == 0) {
                CurQuantum = 0;
                for (int j = 0; j < NbProcess; j++) {
                    process ++;
                    if (process == (NbProcess +1))
                        process = 1;
                }
            }
        } 

        System.out.println("\n\nHere is the scheduling");
            
        //Exit
        proc[0][2] = proc[0][1];
        for(int i = 1; i < NbProcess;  i++){
            proc[i][2] = (proc[i-1][2]) + proc[i][1];
        }

        System.out.println("");
        System.out.println("    Process    |    Arrival    |    Burst   |    Exit");
        for(int i = 0; i < NbProcess; i++) {
            System.out.println("       " + i + "       |       " + proc[i][0] + "       |      " + proc[i][1] + "     |      " + proc[i][2]);
        } 
        
        //Printing the average WT & TT
        float AvgWt = 0,AvgTAt = 0;
        for(int i = 1; i <= NbProcess; i++) {
            AvgWt += proc[i][3];
            AvgTAt += proc[i][4];
        }
        AvgWt /= NbProcess;
        AvgTAt /= NbProcess;
        System.out.println("\nThe Average waiting time is: " + AvgWt);
        System.out.println("The Average turnaround is: " + AvgTAt);
    }
}
