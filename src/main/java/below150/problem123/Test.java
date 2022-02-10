package below150.problem123;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    //这道题用动态规划，但dp数组不再像以前一样是一维、二维的了，我们用天数、进行的交易次数和当前是否持有股票(0代表不持有)构成了一个三维dp数组，值代表当前可以赚到的最多金钱
    //状态转移方程是：dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1])和dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
    //这道题k=2
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][][] dp = new int[prices.length][3][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 3; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][2][0];
    }

    //这种方法中一旦买入，进行交易的次数就减1，但原理还是一样的
    public int maxProfit2(int[] prices) {
        int[][][] profit = new int[prices.length][3][2];
        profit[0][1][1] = -prices[0];
        profit[0][0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j > -1; j--) {
                profit[i][j][1] = Math.max(profit[i - 1][j + 1][0] - prices[i], profit[i - 1][j][1]);
                profit[i][j][0] = Math.max(profit[i - 1][j][1] + prices[i], profit[i - 1][j][0]);
            }
        }
        return profit[prices.length - 1][0][0];
    }

}
