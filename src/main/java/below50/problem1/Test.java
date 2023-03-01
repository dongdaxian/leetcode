package below50.problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] result = new Test().Two_Sum2(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] Two_Sum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                break;
            }
        }

        return result;
    }

    public int[] Two_Sum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index == null) map.put(nums[i], i);
            else {
                result[0] = index;
                result[1] = i;
                break;
            }
        }
        return result;
    }

    public int[] Two_Sum3(int[] nums, int target) {
        //首尾各设一个指针，往中间扫描
        List<int[]> ls = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ls.add(new int[]{nums[i], i});
        }
        ls.sort((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        int i = 0;
        int j = nums.length - 1;
        int[] res = new int[2];
        while (i < j) {
            if (ls.get(i)[0] + ls.get(j)[0] > target) {
                j--;
            } else if (ls.get(i)[0] + ls.get(j)[0] < target) {
                i++;
            } else {
                res[0] = ls.get(i)[1];
                res[1] = ls.get(j)[1];
                break;
            }
        }
        return res;
    }

}
