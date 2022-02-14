package nowcoder.microsoft;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().solution("ag", "agb"));
    }


    public String solution(String S, String T) {
        // write your code in Java SE 8
        int n = S.length();
        int m = T.length();
        if (m == n + 1) {
            int i = 0;
            for (; i < n && S.charAt(i) == T.charAt(1 + i); i++);
            if (i == n) {
                return "INSERT " + T.charAt(0);
            }
        } else if (m == n) {
            List<Integer> ls = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if (S.charAt(i) != T.charAt(i)) {
                    ls.add(i);
                }
            }
            if (ls.size() == 0) {
                return "NOTHING";
            } else if (ls.size() == 1) {
                return "CHANGE " + S.charAt(ls.get(0)) + " " + T.charAt(ls.get(0));
            } else if (ls.size() == 2) {
                int fir = ls.get(0);
                int sed = ls.get(1);
                if (S.charAt(fir) == T.charAt(sed) && S.charAt(sed) == T.charAt(fir)) {
                    return "SWAP " + S.charAt(fir) + " " + S.charAt(sed);
                }
            }
        }
        return "IMPOSSIBLE";

    }
}
