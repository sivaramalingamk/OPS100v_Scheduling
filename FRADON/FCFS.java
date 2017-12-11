/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ops.quizz2;

import java.util.Scanner; 

/** File: OPSQuizz2
 * Date: 07/11/2017
 * @author Oceane Fradon
 */

public class FCFS {
    
    public static void main(String[] args) {
        
        int Atime[] = new int [10];
        int Btime[] = new int [10];
        int Process[] = new int [10];
        int Exit[] = new int [10];
        int Wtime[] = new int [10];
        int TAtime[] = new int [10];
        float AvgTA = 0, AvgW = 0;
        float TotAvgTA = 0, TotAvgW = 0;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nEnter the Number of Processes : ");
        int NbProcess = sc.nextInt();
        
        for(int i = 0; i < NbProcess; i++) { 
            System.out.print("Enter Process " + i + "’s Arrival Time : ");
            Atime[i] = sc.nextInt();
            System.out.print("Enter Process " + i + "’s Burst Time : ");
            Btime[i] = sc.nextInt(); 
        } 
        
        System.out.println("");
        System.out.print("You have selected FCFS Algorithm for the processes ");
        for(int i = 0; i < NbProcess; i++) { 
            System.out.print(i + ", "); 
            Process[i] = i; 
        }
        
        //Sorting according to arrival times
        for(int i = 0 ; i < NbProcess; i++) {
            for(int j = 0;  j < NbProcess-(i+1) ; j++) {
		if( Atime[j] > Atime[j+1] ) {
                    int temp = Atime[j];
                    Atime[j] = Atime[j+1];
                    Atime[j+1] = temp;
                    temp = Btime[j];
                    Btime[j] = Btime[j+1];
                    Btime[j+1] = temp;
                    temp = Process[j];
                    Process[j] = Process[j+1];
                    Process[j+1] = temp;
		}
            }
	}
        
        System.out.println("\n\n    Process    |    Arrival    |    Burst   |");
        for(int i = 0; i < NbProcess; i++) {
            System.out.println("       " + Process[i] + "       |       " + Atime[i] + "       |      " + Btime[i] + "     |");
        } 

        System.out.println("\nHere is the scheduling");
        
        //Calculate Exit
        Exit[0] = Atime[0] + Btime[0];
        for (int i = 1; i < NbProcess; i++) {
            Exit[i] = Exit[i-1] + Btime[i];
        }
        
        System.out.println("\n    Process    |    Arrival    |    Burst   |    Exit");
        for(int i = 0; i < NbProcess; i++) {
            System.out.println("       " + Process[i] + "       |       " + Atime[i] + "       |      " + Btime[i] + "     |      " + Exit[i]);
        } 
        
        TAtime[0] = 0;
        for (int i = 0; i < NbProcess; i++) {     
            //Calculation of Average turnaround time
            TAtime[i] = Exit[i] - Atime[i];         
            AvgTA += TAtime[i];
            TotAvgTA = AvgTA/NbProcess;
            
            //Calculation of Average waiting time
            Wtime[i] = TAtime[i] - Btime[i];        
            AvgW += Wtime[i];
            TotAvgW = AvgW/NbProcess;
       }
   
       System.out.println("\nAverage turnaround time is : " + TotAvgTA);
       System.out.println("Average waiting time is : " + TotAvgW);
    }
}