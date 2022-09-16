package basis;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[] {1};
        int[] res = new MergeSort().sort(nums);
        for (int i: res) {
            System.out.print(i + " ");
        }
    }

    //非递归
    public int[] sort(int[] nums) {
        if (nums == null) {
            return null;
        }
        int length = nums.length;
        int[] res = new int[length];
        for (int len = 1; len < length; len = len * 2) {
            for (int i = 0; i < length; i += len * 2) {
                int left = i, leftEnd = Math.min(length, left + len);
                int right = left + len, rightEnd = Math.min(length, left + 2 * len);
                int ptr = i;
                while (left < leftEnd && right < rightEnd) {
                    res[ptr++] = nums[left] > nums[right] ? nums[right++] : nums[left++];
                }
                while (left < leftEnd) {
                    res[ptr++] = nums[left++];
                }
                while (right < rightEnd) {
                    res[ptr++] = nums[right++];
                }
            }
            int[] tmp = res;
            res = nums;
            nums = tmp;
        }
        return nums;
    }

}
