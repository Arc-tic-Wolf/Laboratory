public class task2 {
    public static void main (String [] args){
        test p[]=new test[10];
        for (int i=0;i<p.length;i++){
            p[i]=new test("thread-"+i);
        }
        int start=1,end=10000;
        for (int i=0;i<p.length;i++){
            p[i].start();
            p[i].maxDivisors(start, end);
            start+=10000;
            end+=10000;
        }
        int max=0,m=-1;
        for (int i=0;i<p.length;i++){
            try{
                p[i].join();
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(p[i].highest+" "+p[i].num);
            if (p[i].highest>max){
                max=p[i].highest;
                m=p[i].num;
            }
        }

        

        System.out.println("Number with max divisors is "+m);
    }
    
}

class test extends Thread {
    public test(String name){
        super(name);
    }
    public int highest=0,num=-1;
    public void maxDivisors(int head, int tail){
        int sum=0,k=-1;
        int [] a=new int[tail-head+1];
        for (int i=head;i<=tail;i++){
            int div=countDivisors(i);
            a[i-head]=div;
            if (div>sum){
                sum=div;
                k=i;
            }

        }
        this.highest=sum;
        this.num=k;

    }
    public int countDivisors(int n){
        int sum=0;
        for (int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(n/i==i){
                    sum++;
                }else {
                    sum+=2;
                }
            }
        }
        return sum;
    }
    
    
}
