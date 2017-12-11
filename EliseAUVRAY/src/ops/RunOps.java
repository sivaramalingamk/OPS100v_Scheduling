/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ops;

import java.util.Scanner;

public class RunOps {
    
    public static void main(String[] args) {
               
        int choix = 0; 
    
        System.out.println("Choose your scheduling algorithm");
        
        Scanner sc = new Scanner(System.in); 
        System.out.println("1- FCFS \n"
                + "2- SJF \n"
                + "3- SRTN \n"
                + "4- RR \n"
                + "5- Multileve Queue \n");
        System.out.print("Enter the number to select algorithm: ");
        
        do {
            choix = sc.nextInt();
            OPS run = new OPS();
            run.initialisation();
            run.displayInitialisation(choix);
            
            switch (choix){
                case 1:
                    run.fcfs();
                    break;

                case 2:
                    run.sjf();
                    break;

                case 3:
                    run.srtn();
                    break;

                case 4:
                    run.rr(); //waiting time and turnaround time not calculated
                    break;

                /*case 5:
                    //multileveQueue();
                    break;
                */
                default:
                    System.out.println("Please enter valide number. ");
                    break;
            }
            
            run.averageTurnaroundTime();
            run.averageWaitingTime();
            
        }while (choix < 1 || choix > 5);

    }
    
}
