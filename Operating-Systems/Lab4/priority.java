import java.util.*;

public class priority{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Process []p=new Process[n];
        int []wait=new int[n];
        int []turn=new int[n];
        int arrival=0;
        double avgwt=0,avgta=0;
        System.out.println("pid burst priority");
        for(int i=0;i<n;i++){
            System.out.print("P"+(i+1)+"\t");
            int burst=sc.nextInt();
            int priority=sc.nextInt();
            p[i]=new Process(i+1,burst,priority);
        }
        Arrays.sort(p);
        wait[0]=0;
        for (int i=1;i<n;i++){
            wait[i]=p[i-1].burst+wait[i-1];
            avgwt+=wait[i];
        }
        for (int i=0;i<n;i++){
            turn[i]=p[i].burst+wait[i];
            avgta+=turn[i];
        }
        avgwt/=n;
        avgta/=n;
        System.out.println("pid complete turnaround waiting");
        for(int i=0;i<n;i++){
            System.out.println("P"+p[i].pid+"\t"+(turn[i]+arrival)+"\t"+turn[i]+"\t"+wait[i]);
        }
        System.out.println("Average: turnaround time "+avgta+" & waiting time "+avgwt);
    }
}

class Process implements Comparable<Process>{
    int pid;
    int burst;
    int priority;
    public Process(int pid,int burst, int priority){
        this.pid=pid;
        this.burst=burst;
        this.priority=priority;
    }
    public int compareTo(Process p){
        return this.priority-p.priority;
    }
}

