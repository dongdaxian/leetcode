package below300.problem283;

public class Test {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            for (; j - 1 > -1 && nums[j - 1] == 0; j--) ;
            nums[i] = 0;
            nums[j] = temp;
        }
    }

    public void moveZeroes3(int[] nums) {
        int zeroPtr = 0;
        int ptr = 0;
        while (zeroPtr < nums.length) {
            while (zeroPtr < nums.length && nums[zeroPtr] != 0) {
                zeroPtr++;
            }
            ptr = zeroPtr + 1;
            while (ptr < nums.length && nums[ptr] == 0) {
                ptr++;
            }
            if (zeroPtr >= nums.length || ptr >= nums.length) {
                break;
            }
            int tmp = nums[zeroPtr];
            nums[zeroPtr] = nums[ptr];
            nums[ptr] = tmp;
        }
    }

    public void moveZeroes2(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
