package nowcoder.meituan2;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ary = new int[num];
        int posCount = 0;
        int negCount = 0;
        for (int i = 0; i < num; i++) {
            ary[i] = sc.nextInt();
            if (ary[i] > 0) {
                posCount++;
            }
        }
        int res = num - posCount;
        int tmp = res;
        for (int i = 0; i < num; i++) {
            if (ary[i] > 0) {
                tmp++;
            } else if (ary[i] < 0) {
                tmp--;
            }
            res = Math.min(res, tmp);
        }
        System.out.println(res);

    }
}
