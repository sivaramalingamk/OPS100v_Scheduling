/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import java.util.Scanner;

/**
 *
 * @author Sylvain BARBIER
 */
public class RunSchedule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
                int choice;
                Scanner scan = new Scanner(System.in);
		
			System.out.println("\nChoose Your Scheduling algorithm.");
			System.out.println("\n1. FCFS\n2. SJF\n3. SRTN\n4. RR\n5. Exit\n");
                        System.out.print("Enter the number to select the algorithm: ");
                        choice = scan.nextInt();
			while (choice<1 || choice>5) { 
				//Hangman.flushSc();
				System.out.println("Please, focus");
                                System.out.println("\nChoose Your Scheduling algorithm.");
                                System.out.println("\n1. FCFS\n2. SJF\n3. SRTN\n4. RR\n5. Exit\n");
                                System.out.print("Enter the number to select the algorithm: ");
                                choice = scan.nextInt();
                            }
			
			switch (choice) {
                            
			case 1: FCFS.begin();
				break;
                                
			case 2: SJF.begin();
				break;
                        case 3: SRTN.begin();
				break;
                        case 4: RR.begin();
				break;
                                
			case 5: System.out.println("ciao :)");
                                System.exit(0);
                                break;
			}
                
		System.out.println("-----------------EOF-----------------");
		System.exit(0);
            
            
    }
    
}
