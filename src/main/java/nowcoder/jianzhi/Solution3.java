package nowcoder.jianzhi;

public class Solution3 {

    public int findRepeatNumber(int[] nums) {
        boolean[] record = new boolean[nums.length];

        for (int tmp : nums) {
            if (record[tmp]) {
                return tmp;
            } else {
                record[tmp] = true;
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i]]) {
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
            if (nums[i] != i)
                return nums[i];
        }
        return -1;
    }

    public int findRepeatNumber3(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
