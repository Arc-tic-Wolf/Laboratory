public class task2b {
    public static void main (String [] args){
        long time=System.currentTimeMillis();
        test p[]=new test[10];
        for (int i=0;i<p.length;i++){
            p[i]=new test("thread-"+i);
        }
        int start=1,end=10000;
        for (int i=0;i<p.length;i++){
            p[i].run();
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
        System.out.println("Singlethread "+(System.currentTimeMillis()-time)+"ms");
        time=System.currentTimeMillis();
        test q[]=new test[10];
        for (int i=0;i<q.length;i++){
            q[i]=new test("thread-"+i);
        }
        start=1;
        end=10000;
        for (int i=0;i<p.length;i++){
            q[i].start();
            q[i].maxDivisors(start, end);
            start+=10000;
            end+=10000;
        }
        max=0;
        m=-1;
        for (int i=0;i<q.length;i++){
            try{
                q[i].join();
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(q[i].highest+" "+q[i].num);
            if (q[i].highest>max){
                max=q[i].highest;
                m=q[i].num;
            }
        }
        System.out.println("Number with max divisors is "+m);
        System.out.println("Multithread "+(System.currentTimeMillis()-time)+"ms");
        

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
