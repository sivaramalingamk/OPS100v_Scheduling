/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ops.quizz2;

import java.io.IOException;
import java.util.Scanner; 

/** File: OPSQuizz2
 * Date: 07/11/2017
 * @author Oceane Fradon
 */

public class OPSQuizz2 {
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose Your Scheduling algorithm :");
        System.out.println("1.  FCFS\n" + "2.  SJF\n" + "3.  SRTN\n" + "4.  RR\n");
       
        System.out.print("Enter the number to select the algorithm : ");
        int choices = sc.nextInt();
        
        switch(choices) {
            case 1:
                //FCFS
                FCFS.main(args);
                break;
            case 2:
                //SJF
                SJF.main(args);
                break;
            case 3:
                //SRTN
                SRTN.main(args);
                break;
            case 4:
                //RR
                RR.main(args);
                break;
            default:
                break;
        }
    }
}
