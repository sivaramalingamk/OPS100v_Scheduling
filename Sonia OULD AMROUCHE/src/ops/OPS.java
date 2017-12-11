/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ops;

import java.util.Scanner;
/**
 *
 * @author Sonia
 */
public class OPS {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        
        int choice;
        System.out.println("\nChoose Your Scheduling algorithm :\n"
                    + "1 : FCFS\n"
                    + "2 : SJF\n"
                    + "3 : SRTN\n"
                    + "4 : RR\n"
                    + "Enter the number to select the algorithm:\n"
                           );

            choice = sc.nextInt();
            System.out.println("");
            switch(choice){
                case 1:
                          
                    OPSquizz.main(args);
                break;
                case 2:
                    
                    OPSSJF.main(args);
               
                break;
                 case 3:
                         
                    OPSSTRN.main(args);
                break;
                 case 4:
                     
                     RR.begin();
                break;
                 
                
                
            }
        
        // TODO code application logic here
    }
    
}
