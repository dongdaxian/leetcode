package basis;


public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1,6,8,7,3,5,16,4,8,36,13,44};
        new QuickSort().sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int midNum = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= midNum) {
                j--;
            }
            while (i < j && nums[i] <= midNum) {
                i++;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[left] = nums[i];
        nums[i] = midNum;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public void quickSort2(int[] nums, int left, int right) {
        if(left > right) {
            return;
        }
        int midNum = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= midNum) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= midNum) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = midNum;
        quickSort2(nums, left, i - 1);
        quickSort2(nums, i + 1, right);
    }

}
