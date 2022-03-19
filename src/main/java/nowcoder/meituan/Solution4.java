package nowcoder.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {

    private static long maxValue = 0;
    private static int possNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ballNum = sc.nextInt();
        int k1 = sc.nextInt();
        int k2 = sc.nextInt();
        int[] ball = new int[ballNum];
        for (int i = 0; i < ballNum; i++) {
            ball[i] = sc.nextInt();
        }
//        dfs(ball, k1, k2, 0, 0L);
        computeCombination(ball, k1, k2);
        System.out.print(maxValue + " " + possNum);
    }

    private static void dfs(int[] ball, int k1, int k2, int index, long sum) {
        if (index >= ball.length) {
            return;
        }
        if (sum + ball[index] >= maxValue && (sum + ball[index]) % k1 == 0 && (sum + ball[index]) % k2 != 0) {
            if (sum + ball[index] > maxValue) {
                maxValue = sum + ball[index];
                possNum = 1;
            } else if (sum + ball[index] == maxValue) {
                possNum = (possNum + 1) % 998244353;
            }
        }
        dfs(ball, k1, k2, index + 1, sum);
        dfs(ball, k1, k2, index + 1, sum + ball[index]);

    }

    private static void computeCombination(int[] ball, int k1, int k2) {
        int divisor = (k1 * k2) / maxCommonDivisor(k1, k2);
        int len = ball.length;
        //从前i个数中选取一个组合，组合的数字和为n，n必须满足余divisor为j。valueDp[i][j]记录了最大的n，timesDp[i][j]记录了n为valueDp[i][j]的组合数
        //为什么要余divisor？已知preNum，newNum是使得preNum % k1 == num % k1 && preNum % k2 == num % k2成立的num的最小值，那么：preNum % divisor == newNum
        int[][] valueDp = new int[len + 1][divisor];
        int[][] timesDp = new int[len + 1][divisor];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < divisor; j++) {
                //必须初始化为极小的数
                valueDp[i][j] = -0x3f3f3f3f;
            }
        }
        valueDp[0][0] = 0;
        timesDp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < divisor; j++) {
                valueDp[i][j] = Math.max(valueDp[i][j], valueDp[i - 1][j]);
                //确保余数为正数
                int index = ((j + ball[i - 1]) % divisor + divisor) % divisor;
                if (valueDp[i - 1][j] != -0x3f3f3f3f) {
                    valueDp[i][index] = Math.max(valueDp[i][index], valueDp[i - 1][j] + ball[i - 1]);
                }
            }
            for (int j = 0; j < divisor; j++) {
                if (valueDp[i][j] == valueDp[i - 1][j]) {
                    timesDp[i][j] = (timesDp[i][j] + timesDp[i - 1][j]) % 998244353;
                }
                int index = ((j + ball[i - 1]) % divisor + divisor) % divisor;
                if (valueDp[i][index] == valueDp[i - 1][j] + ball[i - 1]) {
                    timesDp[i][index] = (timesDp[i][index] + timesDp[i - 1][j]) % 998244353;
                }
            }
        }
        for (int j = 0; j < divisor; j++) {
            if (j % k1 == 0 && j % k2 != 0) {
                if (valueDp[len][j] > maxValue) {
                    maxValue = valueDp[len][j];
                    possNum = timesDp[len][j];
                }
            }
        }

    }

    //求最大公约数
    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {            //保证被除数大于除数
            int temp = m;
            m = n;
            n = temp;
        }

        while (m % n != 0) {    //在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;               // 返回最大公约数
    }

}
