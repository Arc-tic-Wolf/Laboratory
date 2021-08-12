public class threadtest {
    public static void main (String [] args){
        System.out.println("Hello World");
        tester t1=new tester("Thread-1");
        tester t2=new tester("Thread-2");
        tester t3=new tester("Thread-3");
        tester t4=new tester("Thread-4");
        tester t5=new tester("Thread-5");

        //run() for main thread
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Done");
    }
    
}

class tester extends Thread {
    public tester(String name){
        super(name);
    }

    public void run(){
        for (int i=0;i<=5;i++){
            System.out.println("From "+getName()+": "+i);
            try {
                sleep(250);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
