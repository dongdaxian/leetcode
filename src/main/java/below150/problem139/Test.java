package below150.problem139;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("leet");
        ls.add("code");
        System.out.println(new Test().wordBreak("leetcode", ls));
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        //在此状态转移方程下，必须有两个for循环用于限制范围
        for (int k = 1; k <= s.length(); k++) {
            for (int i = 0, j = i + k; j <= s.length(); i++, j++) {
                if (wordDict.contains(s.substring(i, j))) {
                    dp[i][j - 1] = true;
                } else {
                    for (int temp = i + 1; temp < j; temp++) {
                        if (dp[i][temp - 1] && dp[temp][j - 1]) {
                            dp[i][j - 1] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    //但dp可以只用一维，因为我们完全可以让dp[temp][j - 1]只对应一个单词
    public boolean workBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

}
