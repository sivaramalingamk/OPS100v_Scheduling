import java.util.*;
import java.lang.*;


public class Myprocess
{
    private int Process;
    private int Burst_Time;
    private int Arrival;
    private int Start;
    private int Wait;
    private int Finish;
    private int TA;
    public Myprocess Myprocess(int process,int burst_Time,int arrival,int start,int wait,int finish,int tA)
    {
        this.Process = process;
        this.Burst_Time = burst_Time;
        this.Arrival = arrival;
        this.Start = start;
        this.Wait = wait;
        this.Finish = finish;
        this.TA = tA;
        return this;
    }
    public void setProcess(int p)
    {
        this.Process = p;
    }
    public int GetProcess()
    {
        return this.Process;
    }
    public void setBurst_Time(int B)
    {
        this.Burst_Time = B;
    }
    public int GetBurst_Time()
    {
        return this.Burst_Time;
    }

    public void setArrival(int A)
    {
        this.Arrival = A;
    }
    public int GetArrival()
    {
        return this.Arrival;
    }
    public void setStart(int S)
    {
        this.Start = S;
    }
    public int GetStart()
    {
        return this.Start;
    }
    public void setWait(int W)
    {
        this.Wait = W;
    }
    public int GetWait()
    {
        return this.Wait;
    }
    public void setFinish(int finish) { this.Finish = finish;}
    public int GetFinish()
    {
        return this.Finish;
    }
    public void setTA(int ta)
    {
        this.TA = ta;

    }
    public int GetTA()
    {
        return this.TA;
    }


}