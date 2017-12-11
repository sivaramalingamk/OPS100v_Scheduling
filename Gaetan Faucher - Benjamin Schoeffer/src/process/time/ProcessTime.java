/**
 * File : ProcessTime.java
 * Date : 13/11/17
 * @author : Gaëtan Faucher
 */

package process.time;

import java.util.Scanner;

public class ProcessTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int algoChoice;
        
        System.out.print("\t Choose your scheduling algorithm : \n"
                + "1 : FCFS \n"
                + "2 : SJF \n"
                + "3 : SRTN (not ready to use)\n"
                + "4 : RR \n"
                + "5 : Multilevel Queue (not ready to use)\n\n"
                + "Enter the number to select the algorithm: ");
        algoChoice = sc.nextInt();
        
        switch(algoChoice){
            case 1 : 
                FCFS algoFCFS = new FCFS();
                algoFCFS.FCFS();
            break;
            case 2 :
                SJF algoSJF = new SJF();
                algoSJF.SJF();
            break;
            case 3 :
                /* SRTN */
                System.out.println("\n Not ready to use !!!\n");
            break;
            case 4 : 
                RR algoRR = new RR();
                algoRR.RR(); 
            break;
            case 5 :
                /* Multilevel Queue */
                System.out.println("\n Not ready to use !!!\n");
            break;
            default :
                System.out.println("\n Error : invalid imput !\n");
        }
    }
    
}
