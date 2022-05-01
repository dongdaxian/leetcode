package nowcoder.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        char[][] ch = new char[num][];
        for (int i = 0; i < num; i++) {
            ch[i] = sc.nextLine().toCharArray();
        }
        List<String> res = new Solution1().sortStr(ch);
        for (String str : res) {
            System.out.println(str);
        }

    }

    public List<String> sortStr(char[][] ch) {
        int m = ch.length;
        int n = ch[0].length;
        int[] pos = new int[n];
        int[] buf = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }
        for (int i = m - 1; i > -1; i--) {
            int[] cnt = new int[10];
            for (char tmp : ch[i]) {
                cnt[tmp - '0']++;
            }
            for (int j = 1; j < 10; j++) {
                cnt[j] += cnt[j - 1];
            }
            //必须从大到小
            for (int j = n - 1; j > -1; j--) {
                buf[--cnt[ch[i][pos[j]] - '0']] = pos[j];
            }
            System.arraycopy(buf, 0, pos, 0, n);
        }
        List<String> res = new ArrayList<>();
        for (int tmp : pos) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(ch[i][tmp]);
            }
            res.add(sb.toString());
        }
        return res;
    }

}
