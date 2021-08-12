import java.util.*;
public class sjf{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int pid[]=new int[n];
        int arrival[]=new int[n];
        int burst[]=new int[n];
        int complete[]=new int[n];
        int turnaround[]=new int[n]; //complete-arrival
        int waiting[]=new int[n]; //complete-burst-arrival
        int a[]=new int[n];
        int t=0,sum=0;
        double avgwt=0,avgta=0;
        System.out.println("pid arrival burst");
        for(int i=0;i<n;i++){
            pid[i]=i+1;
            System.out.print("P"+pid[i]+"\t");
            arrival[i]=sc.nextInt();
            burst[i]=sc.nextInt();
            a[i]=burst[i];
        }
        boolean b=true;
        while(sum!=n){

            int c=n, min=999, mini=-1;
            for (int i=0;i<n;i++){
                if (arrival[i]<=t && a[i]>0 && burst[i]<min){
                    min=a[i];
                    mini=i;
                    b=false;
                } 
            }
            if(b){
                t++;
                continue;
            }
            a[mini]--;
            min=a[mini];
            if(min==0){
                min=999;
            }
            if(a[mini]==0){
                sum++;
                b=true;
                complete[mini]=t+1;
                waiting[mini]=complete[mini]-burst[mini]-arrival[mini];
            }
            t++;
        }
        for(int i=0;i<n;i++){
            turnaround[i]=burst[i]+waiting[i];
        }
        for(int i=0;i<n;i++){
            avgwt+=waiting[i];
            avgta+=turnaround[i];
        }
        avgta/=n;
        avgwt/=n;
        System.out.println("pid complete turnaround waiting");
        for(int i=0;i<n;i++){
            System.out.println("P"+pid[i]+"\t"+complete[i]+"\t"+turnaround[i]+"\t"+waiting[i]);
        }
        System.out.println("Average: turnaround time "+avgta+" & waiting time "+avgwt);
        


    }
}

