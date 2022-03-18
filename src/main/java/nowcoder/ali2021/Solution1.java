package nowcoder.ali2021;

import java.util.Scanner;
import java.util.stream.IntStream;


//    阿里2021-4-16笔试
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ary = IntStream.rangeClosed(1, num).toArray();
        int circle = sc.nextInt();
        while (circle > 0) {
            circle--;
            int left = sc.nextInt(), right = sc.nextInt();
            while (left < right) {
                int tmp = ary[left - 1];
                ary[left - 1] = ary[right - 1];
                ary[right - 1] = tmp;
                left++;
                right--;
            }
        }
        int ret = 0;
        for (int i = num - 1; i > -1; i--) {
            for (int j = i - 1; j > -1; j--) {
                if (ary[j] > ary[i]) {
                    ret++;
                }
            }
        }
        System.out.print(ret);
    }
}
