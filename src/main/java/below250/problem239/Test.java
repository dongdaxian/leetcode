package below250.problem239;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        int[] res = new Test().maxSlidingWindow4(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for (int tmp : res) {
            System.out.println(tmp);
        }
    }

    //O(nlogk)
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>((Integer o1, Integer o2) -> {
            return o2 - o1;
        });
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int ptr = 0;
        for (int i = 0; i < k - 1; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = k - 1; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            //其实这里ptr就等于i - k + 1，所以可以省掉
            res[ptr++] = map.firstKey();
            int pre = i - k + 1;
            if (map.get(nums[pre]) > 1) {
                map.put(nums[pre], map.get(nums[pre]) - 1);
            } else {
                map.remove(nums[pre]);
            }
        }
        return res;
    }

    //在最坏情况下，队列包含全部元素，所以时间复杂度是O(log(n!))，但这不是常见的时间复杂度，所以将它再扩大，表示成O(nlogn)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    //O(n)，构造的队列值递减、下标递增
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
//            要使队列中数字有序，入队和比较大小肯定是在同一端
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }


    public int[] maxSlidingWindow4(int[] nums, int k) {
        List<Integer> ls = new ArrayList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            ls.add(nums[i]);
        }
        ls.sort(Comparator.comparingInt(a -> a));
        for (int i = k - 1; i < nums.length; i++) {
            int index = binarySearch(ls, nums[i]);
            ls.add(index, nums[i]);
            res[i - k + 1] = ls.get(k - 1);
            index = binarySearch(ls, nums[i - k + 1]);
            ls.remove(index);
        }
        return res;
    }

    public int binarySearch(List<Integer> ls, int target) {
        int left = 0, right = ls.size() - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
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
}
