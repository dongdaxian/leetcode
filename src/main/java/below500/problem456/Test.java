package below500.problem456;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Test {
//    ��߲���ά��min���ұ߲���ά��һ��TreeMap���Ա���ʱ���ҳ���Сkey
    public boolean find132pattern(int[] nums) {
        TreeMap<Integer, Integer> map= new TreeMap<>();
        for(int i = 1; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) - 1);
            if(map.get(nums[i]) == 0) {
                map.remove(nums[i]);
            }

            if(nums[i] > min) {
                Integer mid = map.ceilingKey(min + 1);
                if(mid != null && mid < nums[i]) {
                    return true;
                }
            } else {
                min = nums[i];
            }
        }
        return false;
    }

    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        int mid = Integer.MIN_VALUE;
        Deque<Integer> queue = new LinkedList<>();
        queue.push(nums[n - 1]);

        for(int i = n - 2; i > -1; i--) {
            if(nums[i] < mid) {
                return true;
            }
//            ȡ���mid
            while (!queue.isEmpty() && nums[i] > queue.peek()) {
                mid = queue.pop();
            }
//            ջ�е�����Ԫ�ض�����mid���Ҵ�ջ�׵�ջ���ݼ�
//            ��ʱnums[i]ֻ���ܴ��ڵ���mid������ִ����ѭ������ôһ������mid
            if(nums[i] > mid) {
                queue.push(nums[i]);
            }
        }
        return false;
    }
}
