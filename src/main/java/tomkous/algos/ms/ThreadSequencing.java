package tomkous.algos.ms;

public class ThreadSequencing {

	    public static void main(String[] args) {
	        Thread t1 = new Thread(() -> System.out.println("Thread 1 is running"));
	        Thread t2 = new Thread(() -> System.out.println("Thread 2 is running"));
	        Thread t3 = new Thread(() -> System.out.println("Thread 3 is running"));	        

	        try {
	            t1.start();
	            t1.join(); // Main thread blocks until t1 finishes
	            System.out.println("Main Thread i waiting untill 1st Thread is finished");
	            
	            t2.start();
	            t2.join(); // Main thread blocks until t2 finishes
	            System.out.println("Main Thread i waiting untill 2nd Thread is finished");
	            
	            t3.start();
	            t3.join(); // Main thread blocks until t3 finishes
	            System.out.println("Main Thread i waiting untill 3rd Thread is finished");
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	        System.out.println("All threads have run");
	    }
	}
