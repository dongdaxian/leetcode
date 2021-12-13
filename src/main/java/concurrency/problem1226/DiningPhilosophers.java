package concurrency.problem1226;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
	Semaphore[] s;
    public DiningPhilosophers() {
        s = new Semaphore[5];
        for(int i = 0; i < 5; i++) {
        	s[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        if(philosopher % 2 == 0) {
        	s[philosopher].acquire();
        	pickLeftFork.run();
        	s[(philosopher + 1) % 5].acquire();
        	pickRightFork.run();
        } else {
        	s[(philosopher + 1) % 5].acquire();
        	pickRightFork.run();
        	s[philosopher].acquire();
        	pickLeftFork.run();
        }
        eat.run();
        putLeftFork.run();
        s[philosopher].release();	//如果先释放，在还没有输出放下行为时，就会有拿起行为了，并且完全可能拿起行为的输出还要早于此放下行为的输出，于是就会输出错误
        putRightFork.run();
        s[(philosopher + 1) % 5].release();
        
    }
}
