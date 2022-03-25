package nowcoder.huawei;

import java.util.Scanner;


//华为2022.3.23
public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] t = new int[len];
        for (int i = 0; i < len; i++) {
            t[i] = sc.nextInt();
        }
        int maxTimes = sc.nextInt();
        int times = getMinStep(t);
        if (times == -1 || maxTimes < times) {
            System.out.println(-1);
        } else {
            System.out.println(times);
        }

    }



    private static int getMinStep(int[] t) {
        int step = 0;
        int cur = 0;
        int ableToReach = 0;
        for (int i = 0; i < t.length - 1; i++) {
            ableToReach = Math.max(ableToReach, t[i] + i);
            if (i == cur) {
                if (i == ableToReach) {
                    return -1;
                }
                cur = ableToReach;
                step++;
            }
        }
        return step;
    }

}
