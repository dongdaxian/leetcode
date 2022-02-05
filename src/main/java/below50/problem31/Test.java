package below50.problem31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {


    public void nextPermutation(int[] nums) {
        List<Integer> queue = new ArrayList<>();
        int i = nums.length - 2;
        queue.add(nums[nums.length - 1]);
        for (; i > -1 && nums[i] >= nums[i + 1]; i--) {
            queue.add(nums[i]);
        }
        if (i > -1)
            queue.add(nums[i]);
        Collections.sort(queue);
        int j = i + 1;
        boolean flag = false;
        for (int temp : queue) {
            if (i > -1 && !flag && temp > nums[i]) {
                nums[i] = temp;
                flag = true;
            } else
                nums[j++] = temp;
        }
    }


    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        while (i > -1 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int j = nums.length - 1;
//        while (j > -1 && (i == -1 || nums[i] >= nums[j])) {
//            j--;
//        }
//        if (i != -1 && j != -1) {
//            swap(nums, i, j);
//        }
        if (i != -1) {
            while (j > -1 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        //可证，此时下标i+1之后的数组为逆序
        reverse(nums, i + 1);

    }

    private void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
