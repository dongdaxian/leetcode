package below700.problem674;

public class Test {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int ret = 1;
        int record = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1])
                record++;
            else {
                ret = Math.max(record, ret);
                record = 1;
            }
        }
        ret = Math.max(record, ret);
        return ret;
    }

    public int findLengthOfLCIS2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

}
