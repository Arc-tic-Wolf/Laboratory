public class mythread{
  public static void main(String[] args) {
    System.out.println("hello");
    System.out.println(Thread.currentThread().getName());
    fthread first=new fthread("Thread 1");
    Thread second=new Thread(new sthread(),"Thread 2");
    first.start();
    second.start();

    
  }
  
}

class fthread extends Thread{
    public fthread(String name){
        super(name);
    }
    public void run(){
        System.out.println("Hi");
        System.out.println(Thread.currentThread().getName());
    }
}

class sthread implements Runnable{
    public void run(){
        System.out.println("Hey");
        System.out.println(Thread.currentThread().getName());
    }
}

