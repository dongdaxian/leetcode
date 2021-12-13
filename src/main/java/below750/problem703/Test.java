package below750.problem703;

import java.util.PriorityQueue;
import java.util.Queue;

public class Test {

    Queue<Integer> pq;
    int k;

    public Test(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int tmp: nums)
            add(tmp);
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k)
            pq.poll();
        return pq.peek();
    }

}
