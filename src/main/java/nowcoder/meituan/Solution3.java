package nowcoder.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long fileNum = sc.nextLong();

        int changedFileNumOnBook = sc.nextInt();
        int changedFileNumOnCom = sc.nextInt();
        long[][] bookChange = new long[changedFileNumOnBook][2];
        long[][] comChange = new long[changedFileNumOnCom][2];
        for (int i = 0; i < changedFileNumOnBook; i++) {
            bookChange[i][0] = sc.nextLong();
        }
        for (int i = 0; i < changedFileNumOnBook; i++) {
            bookChange[i][1] = sc.nextLong();
        }
        for (int i = 0; i < changedFileNumOnCom; i++) {
            comChange[i][0] = sc.nextLong();
        }
        for (int i = 0; i < changedFileNumOnCom; i++) {
            comChange[i][1] = sc.nextLong();
        }
        System.out.println(getConflictFileNum(changedFileNumOnBook, changedFileNumOnCom, bookChange, comChange));
    }

    private static int getConflictFileNum(int changedFileNumOnBook, int changedFileNumOnCom, long[][] bookChange, long[][] comChange) {
        Arrays.sort(bookChange, (o1, o2) -> {return (int) (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);});
        Arrays.sort(comChange, (o1, o2) -> {return (int) (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);});
        bookChange = merge(bookChange);
        comChange = merge(comChange);
        changedFileNumOnBook = bookChange.length;
        changedFileNumOnCom = comChange.length;
        int res = 0;
        int bookPtr = 0;
        int comPtr = 0;
        while (bookPtr < changedFileNumOnBook && comPtr < changedFileNumOnCom) {
            long[] book = bookChange[bookPtr];
            long[] com = comChange[comPtr];
            if (book[1] > com[1]) {
                if (book[0] <= com[0]) {
                    res += com[1] - com[0] + 1;
                } else if (book[0] <= com[1]) {
                    res += com[1] - book[0] + 1;
                }
                comPtr++;
            } else {
                if (com[0] <= book[0]) {
                    res += book[1] - book[0] + 1;
                } else if (com[0] <= book[1]) {
                    res += book[1] - com[0] + 1;
                }
                bookPtr++;
            }
        }

        return res;
    }

    private static long[][] merge(long[][] change) {
        List<long[]> ls = new ArrayList<>();
        int len = change.length;
        if (len == 0) {
            return change;
        }
        ls.add(change[0]);
        for (int i = 1; i < len; i++) {
            long[] tmp = change[i];
            long[] pre = ls.get(ls.size() - 1);
            if (tmp[0] > pre[1]) {
                ls.add(tmp);
            } else {
                pre[1] = Math.max(tmp[1], pre[1]);
            }
        }
        return ls.toArray(new long[0][0]);
    }


}
