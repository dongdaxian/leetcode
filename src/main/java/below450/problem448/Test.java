package below450.problem448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int[] ary = new int[]{8, 2, 3, 4, 5, 6, 7, 2};
        new Test().make_standard(ary, 0);
        for (int tmp: ary)
            System.out.println(tmp);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int num: nums) {
            int index = (num - 1) % n;
            nums[index] += n;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }

//    会改变数组，但题目求的是消失数字，对结果无影响
    public void make_standard(int[] nums, int index) {
        if(nums[index] == index + 1)
            return;
        int num = nums[index];
        while(nums[num - 1] != num) {
            int tmp = nums[num - 1];
            nums[num - 1] = num;
            num = tmp;
        }
    }
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            make_standard(nums, i);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }


}
