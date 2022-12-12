package nowcoder.baidu;

import java.util.Scanner;

// 2022.09.20
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    res2++;
                    break;
                case 2:
                    res1++;
                    break;
                case 3:
                    if (res2 > res1) {
                        res2++;
                    } else if (res2 < res1) {
                        res1++;
                    } else {
                        res1++;
                        res2++;
                    }
                    break;
                default:
            }
        }
        System.out.print(res2 + " " + res1);
    }
}
