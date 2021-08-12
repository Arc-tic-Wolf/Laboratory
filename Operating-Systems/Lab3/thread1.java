public class task1 {
    public static void main (String [] args){
        test t1=new test("Thread-1");
        test t2=new test("Thread-2");

        //run() for main thread
        t1.start();
        t2.start();
        t1.output(1);
        t2.output(11);
        t1.output(21);
        
    }
    
}

class test extends Thread {
    public test(String name){
        super(name);
    }

    
    public void output(int n){
        int num=n;
        for (int i=0;i<10;i++,num++){
            System.out.println("From "+getName()+": "+num);
        }
    }
}
