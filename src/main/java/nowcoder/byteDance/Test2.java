package nowcoder.byteDance;

public class Test2 {

    //在一个无序整数数组中，求任意两个元素差值的最小绝对值
    public static void main(String[] args) {
        System.out.println(new Test2().getMinDiff(new int[] {1, 5, 3, 0}));

    }

    //就时间复杂度而言，不如排序的O(nlogn)
    public int getMinDiff(int[] nums) {
        int n = nums.length;
        int[] help = new int[n - 1];
        //nums中两数相减可以转化为help中连续和
        //nums中连续和也可以转化为前缀和数组sum中两数相减
        for (int i = 0; i < n - 1; i++) {
            help[i] = nums[i] - nums[i + 1];
        }

        /*
        * 转化为求最小子数组和，与53题不同在于求的是绝对值，所以dp[i] != Math.min(dp[i - 1] + help[i - 1], help[i - 1])，只能记录
        * 每个子数组的和
        * */

//        int[][] dp = new int[n - 1][n - 1];
        int res = Integer.MAX_VALUE;
//        for (int k = 0; k < n - 1; k++) {
//            for (int i = 0; i + k < n - 1; i++) {
//                if (k == 0) {
//                    dp[i][i] = help[i];
//                } else {
//                    dp[i][i + k] = dp[i][i + k - 1] + help[i + k];
//                }
//                res = Math.min(res, Math.abs(dp[i][i + k]));
//            }
//        }

        //压缩dp，dp[i]代表以i起始的子数组和
        int[] dp = new int[n - 1];
        for (int k = 0; k < n - 1; k++) {
            for (int i = 0; i <= k; i++) {
                dp[i] += help[k];
                res = Math.min(Math.abs(dp[i]), res);
            }
        }

        return res;
    }

}
