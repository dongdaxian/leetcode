package below500.problem480;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
//        List<Integer> ls = Arrays.stream(new int[]{1, 2}).boxed().collect(Collectors.toList());
//        ls.add(2, 3);
//        System.out.println(ls.get(2));
        for (double tmp : new Test().medianSlidingWindow2(new int[]{-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648}, 3))
            System.out.println(tmp);
    }

    public int binarySearch(List<Integer> ls, int target, int k) {
        int left = 0, right = k - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (ls.get(mid) == target) {
                return mid;
            } else if (ls.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Integer> ls = Arrays.stream(nums).limit(k).boxed().collect(Collectors.toList());
        Collections.sort(ls);
        double[] res = new double[nums.length - k + 1];
        res[0] = ((double) ls.get(k / 2) + ls.get((k - 1) / 2)) / 2;
        for (int i = k; i < nums.length; i++) {
            int index = binarySearch(ls, nums[i - k], k);
            ls.remove(index);
            index = binarySearch(ls, nums[i], k - 1);
            ls.add(index, nums[i]);
            res[i - k + 1] = ((double) ls.get(k / 2) + ls.get((k - 1) / 2)) / 2;
        }
        return res;
    }

    public double[] medianSlidingWindow2(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        DualHeap dh = new DualHeap();
        for (int i = 0; i < k; i++) {
            dh.insert(nums[i]);
        }
        res[0] = dh.getMid();
        for (int i = k; i < nums.length; i++) {
            dh.erase(nums[i - k]);
            dh.insert(nums[i]);
            res[i - k + 1] = dh.getMid();
        }
        return res;
    }
}

class DualHeap {
    Queue<Integer> smallQueue;
    Queue<Integer> largeQueue;
    int smallSize, largeSize;
    Map<Integer, Integer> delayed;

    public DualHeap() {
        //相减的话可能会溢出
        this.smallQueue = new PriorityQueue<>(Comparator.reverseOrder());
        this.largeQueue = new PriorityQueue<>(Integer::compareTo);
        this.delayed = new HashMap<>();
        smallSize = largeSize = 0;

    }

    public double getMid() {
        double res = 0;
        if (smallSize > largeSize) {
            res = smallQueue.peek();
        } else if (smallSize < largeSize) {
            res = largeQueue.peek();
        } else {
            res = ((double) smallQueue.peek() + largeQueue.peek()) / 2;
        }
        return res;
    }

    public void insert(int num) {
        if ((!smallQueue.isEmpty() && num <= smallQueue.peek()) || largeQueue.isEmpty()) {
            smallQueue.offer(num);
            smallSize++;
        } else {
            largeQueue.offer(num);
            largeSize++;
        }
        makeBalance();
    }

    //也可以在erase后makeBalance()
    public void erase(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if (num <= smallQueue.peek()) {
            smallSize--;
            prune(smallQueue);
        } else {
            largeSize--;
            prune(largeQueue);
        }
    }

    public void prune(Queue<Integer> queue) {
        while (delayed.getOrDefault(queue.peek(), 0) > 0) {
            int tmp = queue.poll();
            delayed.put(tmp, delayed.get(tmp) - 1);
        }
    }

    public void makeBalance() {
        if (smallSize + 1 < largeSize) {
            smallQueue.offer(largeQueue.poll());
            smallSize++;
            largeSize--;
            prune(largeQueue);
        } else if (largeSize + 1 < smallSize) {
            largeQueue.offer(smallQueue.poll());
            smallSize--;
            largeSize++;
            prune(smallQueue);
        }
    }

}

