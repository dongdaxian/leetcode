package concurrency.problem1117;

import java.util.concurrent.Semaphore;

public class H2O {
	Semaphore s1;
	Semaphore s2;
	
	public H2O() {
		s1 = new Semaphore(2, true);
		s2 = new Semaphore(0, true);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		s1.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        s2.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        s2.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		s1.release(2);
    }
}
