package below500.problem455;

import java.util.Arrays;

public class Test {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int m = g.length, n = s.length;
        int count = 0;
        while (i < m && j < n) {
            while (j < n && s[j] < g[i])
                j++;
            if (j < n && s[j] >= g[i]) {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
}
