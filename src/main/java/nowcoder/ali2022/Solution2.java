package nowcoder.ali2022;


import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            long[] record = new long[5];
            for (int j = 0; j < 5; j++) {
                record[j] = sc.nextLong();
            }
            System.out.println(getOperationTimes(record));
        }

    }

    private static long getOperationTimes(long[] record) {
        Arrays.sort(record);
        long maxTimes = 0L;
        for (long tmp : record) {
            maxTimes += tmp;
        }
        long left = 1L, right = maxTimes / 4;
        //普通二分查找，返回target下标或第一个大于target的数的下标（未找到情况下），此处需要返回target下标或最后一个小于target的数的下标
        while (left < right) {
            long mid = (right - left + 1) / 2 + left;
            long sum = 0L;
            for (long tmp : record) {
                sum += Math.min(tmp, mid);
            }
            if (mid * 4 <= sum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}
