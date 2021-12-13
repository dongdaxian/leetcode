package concurrency.problem1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz2 {
	private int n;
	private Semaphore sem, sem3, sem5, sem15;

    public FizzBuzz2(int n) {
        this.n = n;
        sem = new Semaphore(1);
        sem3 = new Semaphore(0);
        sem5 = new Semaphore(0);
        sem15 = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
    	for(int i = 3; i <= n; i += 3) {
    		if(i % 5 == 0)
    			continue;
    		sem3.acquire();
        	printFizz.run();
        	sem.release();
    	}
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
    	for(int i = 5; i <= n; i += 5){
    		if(i % 3 == 0)
    			continue;
    		sem5.acquire();
        	printBuzz.run();
        	sem.release();	
    	}
    	
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    	for(int i = 15; i <= n; i += 15) {
    		sem15.acquire();
        	printFizzBuzz.run();
        	sem.release();
    	}
    	
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
    	for(int i = 1; i <= n; i++) {
    		sem.acquire();
    		if(i % 15 == 0) {
    			sem15.release();
    		} else if(i % 3 == 0) {
    			sem3.release();
    		} else if(i % 5 == 0) {
    			sem5.release();
    		} else {
    			printNumber.accept(i);
    			sem.release();
    		}
    	}
    	
    	
    	
    }
}
