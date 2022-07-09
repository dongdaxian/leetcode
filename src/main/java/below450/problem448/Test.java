package below450.problem448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int[] ary = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> ls = new Test().findDisappearedNumbers2(ary);
        for (int num : ls) {
            System.out.println(num);
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int index = (num - 1) % n;
            nums[index] += n;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }

    //    会改变数组，但题目求的是消失数字，对结果无影响
    public void make_standard(int[] nums, int index) {
        if (nums[index] == index + 1)
            return;
        int num = nums[index];
        while (nums[num - 1] != num) {
            int tmp = nums[num - 1];
            nums[num - 1] = num;
            num = tmp;
        }
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            make_standard(nums, i);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }


    public List<Integer> findDisappearedNumbers3(int[] nums) {
        for (int num : nums) {
            int abs = Math.abs(num);
            if (nums[abs - 1] > 0) {
                nums[abs - 1] = -nums[abs - 1];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
