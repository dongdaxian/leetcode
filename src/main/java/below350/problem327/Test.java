package below350.problem327;

public class Test {
    public static void main(String[] args) {

    }

    /*
    * 两个数组均为升序，找出下标对满足n2[j]−n1[i]∈[lower,upper] 的数量，可以在O(n)中完成
    * */
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        return countRangeRecursive(sum, lower, upper, 0, nums.length);
    }
    //归并排序
    public int countRangeRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right)
            return 0;
        int mid = (left + right) / 2;
        int res = 0;
        res += countRangeRecursive(sum, lower, upper, left, mid);
        res += countRangeRecursive(sum, lower, upper, mid + 1, right);

        int i = left;
        int l = mid + 1, r = mid + 1;
        //注意这部分时间复杂度为O(n)
        while (i < mid + 1) {
            while (l <= right && sum[l] - sum[i] < lower)
                l++;
            while (r <= right && sum[r] - sum[i] <= upper)
                r++;
            res += r - l;
            i++;
        }
        //之所以使用前缀和数组sum而不是原数组nums，是因为需要排序，前缀和数组排序后仍可以求此题结果
        int[] sorted = new int[right - left + 1];
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid)
                sorted[p++] = (int) sum[p2++];
            else if (p2 > right)
                sorted[p++] = (int) sum[p1++];
            else {
                if (sum[p1] < sum[p2]) {
                    sorted[p++] = (int) sum[p1++];
                } else {
                    sorted[p++] = (int) sum[p2++];
                }
            }
        }
        for (int j = 0; j < right - left + 1; j++) {
            sum[left + j] = sorted[j];
        }

        return res;
    }

}
