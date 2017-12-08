
import java.util.*;
import java.lang.*;



public class Main
{
    public static Vector <Myprocess> init_V(Vector <Myprocess> V)//this method is to initialize the vector by the user
    {
        int nbProcess = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("How much process do you want : ");
        nbProcess = sc.nextInt();

        for(int i = 0;i<nbProcess;i++)
        {
            Myprocess p = new Myprocess();
            p.setProcess(i);
            System.out.print("What is the arrival : ");
            p.setArrival(sc.nextInt());
            System.out.print("What is the Burst Time : ");
            p.setBurst_Time(sc.nextInt());
            V.insertElementAt(p,i);
        }
        return V;
    }
    public static void Print(Vector <Myprocess> V)// this method permit to print the board calculated
    {
        float cpt1 = 0;
        int cpt =0;
        float m = V.size();
        System.out.println("Process | Arrival |  Burst Time  | Start | Wait | Finish | TA");
        for(int i = 0;i<m;i++)
        {
            System.out.println(V.get(i).GetProcess() +"         "+V.get(i).GetArrival()  +
                    "           "+ V.get(i).GetBurst_Time() +"           " + V.get(i).GetStart()+"        "
                    +V.get(i).GetWait()+"      "+V.get(i).GetFinish()+"      "+V.get(i).GetTA()  );
            cpt += V.get(i).GetTA();
            cpt1+= V.get(i).GetWait();
        }
        System.out.println("\n\nAverage turnaround time is "+ cpt/m);
        System.out.println("Average waiting time is : "+cpt1/m);
    }
    public static void Calculate1_2(Vector <Myprocess> V)// this method calculate the board data for exercice 1,2 and 3
    {

        for (int i =0; i<V.size();i++)
        {
            V.get(i).setProcess(i);
            if(i == 0)
            {
                V.get(i).setStart(0);
                V.get(i).setWait(0);
            }
            else
            {
                V.get(i).setStart(V.get(i-1).GetFinish());

            }
            V.get(i).setFinish(V.get(i).GetStart()+V.get(i).GetBurst_Time());// it's where i calculate the waiting time, the finish and the turnaround time 
            V.get(i).setTA(V.get(i).GetFinish() - V.get(i).GetArrival());//TA = Finish(Exit) - Arrival time
            V.get(i).setWait(V.get(i).GetTA()-V.get(i).GetBurst_Time());//Waiting time = TurnaroudTime - BurstTime
            if(V.get(i).GetWait() <0) V.get(i).setWait(0);
        }
    }

    public static Vector <Myprocess> V_orderFCFS(Vector <Myprocess> V)// This function is to order by arrival time
    {
        for(int j = 0;j<V.size();j++)
        {
            for(int k= 0;k<V.size();k++)
            {


                if(V.get(j).GetArrival()<=V.get(k).GetArrival())
                {
                    Myprocess p = new Myprocess();
                    p.setArrival(V.get(k).GetArrival());
                    V.get(k).setArrival(V.get(j).GetArrival());
                    V.get(j).setArrival(p.GetArrival());
                }
            }
        }

        return V;
    }

    public static Vector <Myprocess> V_orderSJF(Vector <Myprocess> V)// This function permit to put the smaller arrival in first and then order by BurstTime
    {
        int cpt = 0;
        for(int j = 0;j<V.size();j++)
        {
            for(int k= 0;k<V.size();k++)
            {
                if(V.get(j).GetArrival()<=V.get(k).GetArrival())
                {
                    Myprocess p = new Myprocess();
                    p.setArrival(V.get(k).GetArrival());
                    p.setBurst_Time(V.get(k).GetBurst_Time());
                    V.get(k).setArrival(V.get(j).GetArrival());
                    V.get(k).setBurst_Time(V.get(j).GetBurst_Time());
                    V.get(j).setArrival(p.GetArrival());
                    V.get(j).setBurst_Time(p.GetBurst_Time());
                    cpt += V.get(j).GetBurst_Time();
                }
            }
        }

        for(int l = 1;l<V.size();l++)
        {
            for(int p = 1;p<V.size();p++)
            {
                if(V.get(l).GetArrival() <= cpt)
                {
                    if(V.get(l).GetBurst_Time()<= V.get(p).GetBurst_Time())
                    {
                        Myprocess q = new Myprocess();
                        q.setArrival(V.get(l).GetArrival());
                        q.setBurst_Time(V.get(l).GetBurst_Time());
                        V.get(l).setArrival(V.get(p).GetArrival());
                        V.get(l).setBurst_Time(V.get(p).GetBurst_Time());
                        V.get(p).setArrival(q.GetArrival());
                        V.get(p).setBurst_Time(q.GetBurst_Time());
                        cpt += V.get(l).GetBurst_Time();
                    }
                }
            }
        }

        return V;
    }

    public static void V_OrderSRTN(Vector <Myprocess> V,int Q)// This function (Exercice 3) use the order function of the Second exercice but with a quantum 
    {
        int cpt = 0;
        int sz = V.size();
        int tmp = 0;
        V_orderSJF(V);
        int time = 0;
        int []countW = new int[sz];
        int []countB = new int [sz];
        int []countS = new int [sz];
        for(int i = 0;i<sz;i++)
        {
            countB[i] = V.get(i).GetBurst_Time();
        }
        do {

            if(V.get(cpt).GetFinish() != 0 || V.get(cpt).GetBurst_Time() == 0)
            {
                cpt++;
                
            }
            else
            {
                
                V.get(cpt).setBurst_Time(V.get(cpt).GetBurst_Time()-Q);// Burst Time = Burst TIme - Quantum
                time +=Q;
            }
            if(V.get(cpt).GetBurst_Time()<=0)
            {
                tmp =0;
                tmp = Math.abs(V.get(cpt).GetBurst_Time());// We take the absolute value of BurstTime - Q
                V.get(cpt).setBurst_Time(0);
                V.get(cpt).setFinish(time);
                V.get(cpt).setWait(countW[cpt]);
                V.get(cpt).setStart(countS[cpt]);
                if(V.get(cpt).GetArrival() == 0) V.get(cpt).setStart(0); 
                cpt++;
                if(cpt == sz)
                {
                    for(int i =0;i<sz;i++)
                    {
                        V.get(i).setTA(V.get(i).GetFinish()- V.get(i).GetArrival());

                    }
                    cpt =0;
                    break;
                } 
                V.get(cpt).setBurst_Time(V.get(cpt).GetBurst_Time()-tmp);      
            }
            for(int i =0;i<sz;i++)
            {
                if(i != cpt && V.get(i).GetBurst_Time() !=0 && V.get(i).GetArrival()<=time)
                {
                    countW[i]+=Q;
                }
            }
            for(int l = 0;l<V.size();l++)
            {
                for(int p = 0;p<V.size();p++)
                {
                    if(V.get(l).GetArrival() <= time)
                    {
                        if(V.get(l).GetBurst_Time()<= V.get(p).GetBurst_Time())
                        {
                            Myprocess q = new Myprocess();
                            q.setArrival(V.get(l).GetArrival());
                            q.setBurst_Time(V.get(l).GetBurst_Time());
                            V.get(l).setArrival(V.get(p).GetArrival());
                            V.get(l).setBurst_Time(V.get(p).GetBurst_Time());
                            V.get(p).setArrival(q.GetArrival());
                            V.get(p).setBurst_Time(q.GetBurst_Time());
    
                        }
                    }
                }
            }
            Print(V);
            
        }while(cpt != sz);


    }
    public static void V_OrderRR(Vector <Myprocess> V,int Q)
    {
        V_orderFCFS(V);
        int index = 0;
        int T = 0;
        int cpt = 0;
        int sz = V.size();
        int []countW = new int[sz];
        int []countB = new int [sz];
        for(int i = 0;i<sz;i++)
        {
            countB[i] = V.get(i).GetBurst_Time();
        }
        do
        {
            if(index > sz-1)
            {
                index = 0;
            } 
            if(V.get(index).GetFinish()!=0)
            {
                index++;
                continue;
            }
            if(V.get(index).GetStart() == 0)
            {
                if(index!=0)
                {
                    V.get(index).setStart(T);

                }
            }
            V.get(index).setBurst_Time(V.get(index).GetBurst_Time()-Q);
            if(countB[index]<=Q)
            {
                T+=countB[index];
            }
            else
            {
                T+=Q;
            }
            for(int i =0;i<sz;i++)
            {
                if(i != cpt && V.get(i).GetBurst_Time() !=0 && V.get(i).GetArrival()<=T)
                {
                    countW[i]+=T;
                }
            }
            if(V.get(index).GetBurst_Time()<=0)
            {
                V.get(index).setBurst_Time(0);
                if(V.get(index).GetFinish() ==0 && V.get(index).GetBurst_Time() == 0) V.get(index).setFinish(T);
            }
            for(int k = 0;k<sz;k++)
            {
                if(V.get(k).GetFinish() !=0 && V.get(k).GetBurst_Time() == 0) {
                    cpt++;
                    if (cpt > sz-1) {
                        for(int j = 0;j<sz;j++)
                        {
                            V.get(j).setTA(V.get(j).GetFinish() - V.get(j).GetArrival());
                            V.get(j).setWait(V.get(j).GetTA() - countB[j]);
                        }
                        return;
                    }
                }
                else
                {
                    cpt = 0;
                }
            }
            index++;
            
        }while(true);

    }

    public static void main(String[] args)
    {

        int choice;
        int Q =0;
        Vector <Myprocess> V = new  Vector<Myprocess>();
        Scanner sc = new Scanner(System.in);
        System.out.print("1.FCFS\n2.SJF\n3.SRTF\n4.RR\n5.Quit\n\nYour choice : ");
        choice = sc.nextInt();
        init_V(V);
            switch(choice)
            {
                case 1 :
                {

                    V_orderFCFS(V);
                    Calculate1_2(V);
                    Print(V);
                    break;
                }
				case 2 :
				{
                 
				    V_orderSJF(V);
                    Calculate1_2(V);
                    Print(V);
					break;
				}
				case 3 :
				{

                    System.out.println("Select the Quantum : ");
                    Q = sc.nextInt();
                    V_OrderSRTN(V,Q);
                    Print(V);
                    break;
				}
				case 4 ://It's working with 3-4 process, with more, there is some bug
				{
                    System.out.println("Select the Quantum : ");
                    Q = sc.nextInt();
                    V_OrderRR(V,Q);
                    Print(V);
                    break;
				}
                case 5 :
                {
                    System.out.println("Good bye!");
                    return;
                }
                default :
                {
                    System.out.print("No correct enter, please try again ! ");
                    break;
                }
            }  
    }

}
