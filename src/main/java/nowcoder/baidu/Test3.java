package nowcoder.baidu;

import java.util.Scanner;


public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] input = new int[n][2];
        int maxN = 0;
        int maxM = 0;
        for (int i = 0; i < n; i++) {
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
            maxN = Math.max(maxN, input[i][0]);
            maxM = Math.max(maxM, input[i][1]);
        }
        long[][] dp = new long[maxN][maxM];
        dp[0][0] = 1;

        long standard = 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 + 7;

        int[][] colOddSum = new int[maxM][2];
        for (int i = 0; i < maxN; i++) {
            int[] rowOddSum = new int[2];
            for (int j = 0; j < maxM; j++) {
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
                if (j >= 3) {
                    dp[i][j] += rowOddSum[(j % 2) ^ 1] - dp[i][j - 1];
                }
                if (i >= 3) {
                    dp[i][j] += colOddSum[j][(i % 2) ^ 1] - dp[i - 1][j];
                }
                dp[i][j] %= standard;
                rowOddSum[j % 2] += dp[i][j];
                rowOddSum[j % 2] %= standard;
                colOddSum[j][i % 2] += dp[i][j];
                colOddSum[j][i % 2] %= standard;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dp[input[i][0] - 1][input[i][1] - 1]);
        }
    }
}
