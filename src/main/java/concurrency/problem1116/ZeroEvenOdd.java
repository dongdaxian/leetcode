package concurrency.problem1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
	private int n;
    
	Semaphore semaphorez = new Semaphore(1);
	Semaphore semaphoree = new Semaphore(0);
	Semaphore semaphoreo = new Semaphore(0);
	
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
    	for(int i = 0; i < n; i++) {
    		semaphorez.acquire();
    		printNumber.accept(0);
    		if(i % 2 == 0)
    			semaphoreo.release();
    		else
    			semaphoree.release();
    	}
        
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n / 2; i++) {
        	semaphoree.acquire();
        	printNumber.accept((i + 1) * 2);
        	semaphorez.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
    	for(int i = 0; i < (n + 1) / 2; i++) {
    		semaphoreo.acquire();
    		printNumber.accept(i * 2 + 1);
    		semaphorez.release();
        }
    }
}
