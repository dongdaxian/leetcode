package nowcoder.huaweizhenti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt() / 10;
        int n = sc.nextInt();
        Good[] preGoods = new Good[n];
        List<Good> ls = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            preGoods[i] = new Good(sc.nextInt() / 10, sc.nextInt());
            int parent = sc.nextInt();
            if(parent == 0) {
                ls.add(preGoods[i]);
            } else {
                preGoods[parent - 1].add(preGoods[i]);
            }
        }

        int[][] dp = new int[ls.size() + 1][money + 1];
        for (int i = 1; i <= ls.size(); i++) {
            List<int[]> combine = new ArrayList<>();
            Good tmp = ls.get(i - 1);
            int tmpPrice = tmp.price;
            int tmpValue = tmp.price * tmp.level;
            combine.add(new int[]{tmpPrice, tmpValue});
            if(tmp.ls.size() > 0) {
                tmpPrice += tmp.ls.get(0).price;
                tmpValue += tmp.ls.get(0).level * tmp.ls.get(0).price;
                combine.add(new int[]{tmpPrice, tmpValue});
            }
            if(tmp.ls.size() > 1) {
                tmpPrice += tmp.ls.get(1).price;
                tmpValue += tmp.ls.get(1).level * tmp.ls.get(1).price;
                combine.add(new int[]{tmpPrice, tmpValue});
                tmpPrice -= tmp.ls.get(0).price;
                tmpValue -= tmp.ls.get(0).level * tmp.ls.get(0).price;
                combine.add(new int[]{tmpPrice, tmpValue});
            }
            for(int j = 1; j <= money; j++) {
                int pre = dp[i - 1][j];
                for(int[] pbl: combine) {
                    if(j >= pbl[0]) {
                        pre = Math.max(dp[i - 1][j - pbl[0]] + pbl[1], pre);
                    }
                }
                dp[i][j] = pre;
            }
        }
        System.out.println(dp[ls.size()][money] * 10);
    }

}
class Good {
    int price;
    int level;
    List<Good> ls = new ArrayList<>();
    public Good(int price, int level) {
        this.price = price;
        this.level = level;
    }
    public void add(Good g) {
        ls.add(g);
    }
}
