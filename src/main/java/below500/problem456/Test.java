package below500.problem456;

import java.util.*;

public class Test {
    //    左边部分维护min，右边部分维护一个TreeMap，以便随时能找出最小key
    public boolean find132pattern(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) - 1);
            if (map.get(nums[i]) == 0) {
                map.remove(nums[i]);
            }

            if (nums[i] > min) {
                Integer mid = map.ceilingKey(min + 1);
                if (mid != null && mid < nums[i]) {
                    return true;
                }
            } else {
                min = nums[i];
            }
        }
        return false;
    }

    //从前往后，num[i]不仅需要与左右边界比较，还可能同时存在多个区间
    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        int mid = Integer.MIN_VALUE;
        Deque<Integer> queue = new LinkedList<>();
        queue.push(nums[n - 1]);

        for (int i = n - 2; i > -1; i--) {
            if (nums[i] < mid) {
                return true;
            }
//            取最大mid
            while (!queue.isEmpty() && nums[i] > queue.peek()) {
                mid = queue.pop();
            }
//            栈中的所有元素都大于mid，且从栈底到栈顶递减
//            此时nums[i]只可能大于等于mid，若是执行了循环，那么一定大于mid
            if (nums[i] > mid) {
                queue.push(nums[i]);
            }
        }
        return false;
    }
}
