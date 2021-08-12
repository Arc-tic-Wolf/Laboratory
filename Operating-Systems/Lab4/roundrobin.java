import java.util.*;

public class roundrobin{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("#processes");
        int n=sc.nextInt();
        LinkedList<Round>r=new LinkedList<Round>();
        Queue<Round>q=new LinkedList<Round>();
        int quantum=4;
        int arrival=0;
        double avgwt=0,avgta=0;
        int time=0;
        System.out.println("pid burst");
        for(int i=0;i<n;i++){
            System.out.print("P"+(i+1)+"\t");
            int burst=sc.nextInt();
            Round m=new Round(i+1,burst,arrival);
            r.add(m);
            q.add(m);
        }
        while(!q.isEmpty()){
            Round s=q.remove();
            s.wait+=time-s.timeout;
            if(s.temp>=quantum){
                s.temp-=quantum;
                time+=quantum;
                s.timeout=time;
                if(s.temp>0){
                    q.add(s);
                }
            }else {
                time+=s.temp;
                s.timeout=time;
                s.temp=0;
            }
        }
        for (Round p:r){
            p.turn=p.burst+p.wait;
            avgta+=p.turn;
            avgwt+=p.wait;
        }
        avgwt/=n;
        avgta/=n;
        System.out.println("pid complete turnaround waiting");
        for(Round p:r){
            System.out.println("P"+p.pid+"\t"+(p.turn+arrival)+"\t"+p.turn+"\t"+p.wait);
        }
        System.out.println("Average: turnaround time "+avgta+" & waiting time "+avgwt);
    }
}

class Round{
    int pid;
    int burst;
    int temp;
    int arrival;
    int wait=0;
    int turn;
    int timeout=0;
    public Round(int pid,int burst, int arrival){
        this.pid=pid;
        this.burst=burst;
        this.arrival=arrival;
        this.temp=burst;
    }
    
}

