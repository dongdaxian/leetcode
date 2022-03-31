package below200.problem152;

public class Test {

    //dp过大
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for (int k = 1; k < len; k++) {
            for (int i = 0; i + k < len; i++) {
                if (k == 1) {
                    dp[i][i + k] = nums[i] * nums[i + k];
                } else {
                    //dp[i][i + k] = nums[i] * nums[i + k] * dp[i + 1][i + k - 1];
                    dp[i][i + k] = nums[i] * dp[i + 1][i + k];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    //把最长回文子串dp设为int[]，表示以下标i结束的最长回文子串长度。dp[i]不一定由dp[i - 1]得到，行不通
    //根据该题的状态转移方程，maxF[i]一定由maxF[i - 1]和minF[i - 1]得到
    //压缩后的dp
    public int maxProduct2(int[] nums) {
        int maxF = nums[0];
        int minF = nums[0];
        int res = maxF;
        for (int i = 1; i < nums.length; i++) {
            int preMaxF = maxF, preMinF = minF;
            maxF = Math.max(preMaxF * nums[i], Math.max(preMinF * nums[i], nums[i]));
            minF = Math.min(preMaxF * nums[i], Math.min(preMinF * nums[i], nums[i]));
            res = Math.max(res, maxF);
        }
        return res;
    }
}
