package nowcoder.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(new Solution2().getNumber(new int[]{1, 2, 3, 4}));

    }

    public int getNumber(int[] a) {
        int max = 0;
        for (int tmp : a) {
            max = Math.max(max, tmp);
        }
        boolean[] isPrime = new boolean[max + 1];
        isPrime[1] = true;
        int i = 1;
        while (i < (max + 1)) {
            if (!isPrime[i]) {
                if ((long)i * i < max + 1) {
                    for (int j = i * i; j < (max + 1); j += i) {
                        isPrime[j] = true;
                    }
                }
            }
            i++;
        }
        List<Integer> ls = new ArrayList<>();
        for (int tmp : a) {
            ls.add(tmp);
        }
        List<Integer> next = new ArrayList<>();
        while (ls.size() > 1) {
            for (int j = 0; j < ls.size(); j++) {
                if (!isPrime[j + 1]) {
                    next.add(ls.get(j));
                }
            }
            ls.clear();
            List<Integer> tmp = ls;
            ls = next;
            next = tmp;
        }

        return ls.get(0);
    }

}
