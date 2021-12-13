package nowcoder.huaweizhenti;

import java.util.Scanner;

public class Solution28 {
    static int ret = 0;

//    使用dfs进行全排，会超时
    public static void dfs(int[] small, int[] big, int smallIndex, int bigIndex, boolean[] notSu, int pos) {
        if (pos == smallIndex) {
            int tmpRet = 0;
            for (int i = 0; i < smallIndex; i++) {
                if (!notSu[small[i] + big[i]]) {
                    tmpRet++;
                }
            }
            ret = Math.max(ret, tmpRet);
            return;
        }
        for (int i = pos; i < bigIndex; i++) {
            int tmp = big[i];
            big[i] = big[pos];
            big[pos] = tmp;
            dfs(small, big, smallIndex, bigIndex, notSu, pos + 1);
            tmp = big[i];
            big[i] = big[pos];
            big[pos] = tmp;
        }
    }

//    使用匈牙利算法，奇数去匹配偶数
    public static boolean find(boolean[] notSu, int x, int[] evenAry, int size, boolean[] used, int[] evenMatched) {
        for (int i = 0; i < size; i++) {
            if (!used[i] && !notSu[evenAry[i] + x]) {
                used[i] = true;
                if (evenMatched[i] == 0 || find(notSu, evenMatched[i], evenAry, size, used, evenMatched)) {
                    evenMatched[i] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] notSu = new boolean[60001];
        for (int i = 2; i < 60001; i++) {
            if (!notSu[i]) {
                long tmp = (long)i * i;
                while (tmp < 60001) {
                    notSu[(int)tmp] = true;
                    tmp += i;
                }
            }
        }
        while (sc.hasNextInt()) {
            ret = 0;
            int argsNum = sc.nextInt();
            int[][] record = new int[2][argsNum];
            int[] index = new int[2];
            for (int i = 0; i < argsNum; i++) {
                int tmp = sc.nextInt();
                record[tmp & 1][index[tmp & 1]++] = tmp;
            }
//            if (index[0] <= index[1]) {
//                dfs(record[0], record[1], index[0], index[1], notSu, 0);
//            } else {
//                dfs(record[1], record[0], index[1], index[0], notSu, 0);
//            }
            int[] evenMatched = new int[index[0]];
            for (int i = 0; i < index[1]; i++) {
                boolean[] used = new boolean[index[0]];
                if (find(notSu, record[1][i], record[0], index[0], used, evenMatched)) {
                    ret++;
                }
            }
            System.out.println(ret);
        }

    }

}
