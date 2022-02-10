package below1450.problem1438;

import java.util.Arrays;
import java.util.Objects;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {
        new Test().longestSubarray(new int[]{8, 2, 4, 7}, 4);
    }

    public int longestSubarray(int[] nums, int limit) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        for (; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(right - left + 1, res);
        }
        return res;
    }
}
