public class monitorDemo {
  
    public static void main(String[] args) throws InterruptedException {
      Producer producer = new Producer();
      Consumer consumer = new Consumer();
  
      producer.start();
      consumer.start();
  
      producer.join();
      consumer.join();
  
      System.out.println("Buffer count: " + BufferWithMonitor.count);
    }
}

class Producer extends Thread {
    @Override
    public void run() {
      for (int i = 0 ; i < 100 ; i++)
        BufferWithMonitor.criticalSection("increment");
    }
}
  
class Consumer extends Thread {
    @Override
    public void run() {
      for (int i = 0 ; i < 100 ; i++)
        BufferWithMonitor.criticalSection("decrement");
    }
}
  
class BufferWithMonitor {
  
    static int count = 0;
  
    public static synchronized void criticalSection(String operation) {
      if (operation.equals("increment"))
        count++; // count = count + 1;
      else if (operation.equals("decrement"))
        count--; // count = count - 1;
    }
}
  
