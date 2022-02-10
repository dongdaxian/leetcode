package below1000.problem995;

public class Test {
    public int minKBitFlips(int[] nums, int k) {
        int revCnt = 0;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && nums[i - k] > 1) {
                revCnt ^= 1;
            }
            if ((nums[i] + revCnt) % 2 == 0) {
                if (i + k > nums.length) {
                    return -1;
                }
                ret++;
                revCnt ^= 1;
                nums[i] += 2;
            }
        }

        return ret;
    }
}
