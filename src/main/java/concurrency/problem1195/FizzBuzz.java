package concurrency.problem1195;

import java.util.function.IntConsumer;

public class FizzBuzz {
	private int n;
	private int num = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(num <= n) {
        	if(num % 3 == 0 && num % 5 != 0) {
        		printFizz.run();
        		num++;
        		this.notifyAll();
        	} else {
        		wait();
        	}
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
    	while(num <= n) {
        	if(num % 3 != 0 && num % 5 == 0) {
        		printBuzz.run();
        		num++;
        		this.notifyAll();
        	} else {
        		wait();
        	}
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    	while(num <= n) {
        	if(num % 3 == 0 && num % 5 == 0) {
        		printFizzBuzz.run();
        		num++;
        		this.notifyAll();
        	} else {
        		wait();
        	}
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
    	while(num <= n) {
        	if(num % 3 != 0 && num % 5 != 0) {
        		printNumber.accept(num);
        		num++;
        		this.notifyAll();
        	} else {
        		wait();
        	}
        }
    }
}
