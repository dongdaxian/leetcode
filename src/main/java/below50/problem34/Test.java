package below50.problem34;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


    public int[] searchRange(int[] nums, int target) {
        int find = searchRangeHelper(nums, target);
        if (find == -1)
            return new int[]{-1, -1};
        int left = find - 1;
        int right = find + 1;
        while (left > -1 && nums[left] == target)
            left--;
        while (right < nums.length && nums[right] == target)
            right++;
        return new int[]{left + 1, right - 1};
    }

    public int searchRangeHelper(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        //二分查找中，此处必须是<=，否则当数组只有一个元素时会出错
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange2(int[] nums, int target) {
        int first = searchFirst(nums, target);
        if (first < nums.length && nums[first] == target) {
            return new int[]{first, searchFirst(nums, target + 1) - 1};
        } else {
            return new int[]{-1, -1};
        }
    }


    //改造过的二分查找，返回target下标，如没有则返回第一个大于target数字的下标，可以超出界限
    public int searchFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

}
