public class task3{
    public static void main(String[] args) {
        int [] arr={45360,15120,83160,55440,7560,98280,75600,27720,65520,30240};
        long start = System.currentTimeMillis();
        Quicksort.parallelQuicksort(arr,0,arr.length -1);
        
        System.out.println("Threaded array sorted in "+(System.currentTimeMillis()-start)+" ms");
        for (int i:arr){
            System.out.println(i);
        }
    }
}

class Quicksort extends Thread {
    private int arr[];
    private int low,high;
    public static int numThreads = Runtime.getRuntime().availableProcessors();
    public static int count = 0;

    public Quicksort(int[] arr, int low, int high){
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    public void run(){
        parallelQuicksort(arr,low,high);    
    }

    public static void quicksort(int[] arr, int low, int high){
        if (high>low){
            int i = partition(arr,low,high);
            quicksort(arr,low,i-1);
            quicksort(arr,i+1,high);
        }
    }

    public static  void parallelQuicksort(int[] arr, int low, int high){
        if (high>low){
            int i = partition(arr,low,high);
            if (count < numThreads){
                count++;
                Quicksort quicksort  = new Quicksort(arr, low, i-1);
                quicksort.start();
                try{
                    quicksort.join();
                }
                catch (InterruptedException e){}
            }
            else{
                quicksort(arr,low,i-1);
            }   
            if (count < numThreads){
                count++;
                Quicksort quicksort  = new Quicksort(arr, i+1, high);
                quicksort.start();
                try{
                    quicksort.join();
                }
                catch (Exception e){}
            }
            else{
                quicksort(arr,i+1,high);
            }   
        }
    }
    public static int partition(int[] arr, int low,int high)
    {
     
        // pivot
        int pivot = arr[high];
         
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
     
        for(int j = low; j <= high - 1; j++)
        {
             
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot)
            {
                 
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int median(int a, int b, int c) {
        if (a <= b) {
            if (c <= a) {
                return a;
            }

            return b <= c ? b : c;
        } 

        if (c <= b) {
            return b;
        }

        return a <= c ? a : c;
    } 
}