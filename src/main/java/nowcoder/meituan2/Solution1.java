package nowcoder.meituan2;

import java.util.Scanner;


//美团2022.8.6
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int res = 0;
            int min = Math.min(x, y);
            int max = Math.max(x, y);
            if (min * 2 <= max) {
                res = min;
            } else {
                res += (max - min);
                int tmp = min - (max - min);
                res += (tmp / 3) * 2;
                if (tmp % 3 == 1) {
                    res += 1;
                }

            }

            System.out.println(res);
        }
    }

}
