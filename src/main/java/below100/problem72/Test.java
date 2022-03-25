package below100.problem72;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().minDistance("", "a"));

    }

    public int minDistance(String word1, String word2) {        //与10、44题不同之处在于不都是从下标0开始匹配
        int[][] dis = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word2.length(); i++) {
            dis[0][i] = i;
        }
        for (int i = 0; i <= word1.length(); i++) {
            dis[i][0] = i;
        }
        //当word1或word2增加一个字符，新结果一定大于等于原结果
        //dp[i-1][j]到dp[i][j]对应word1增加字符，所以加1，如果结果小于dp[i-1][j]+1，说明不是增加操作
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dis[i][j] = Math.min(dis[i - 1][j - 1], Math.min(dis[i][j - 1] + 1, dis[i - 1][j] + 1));
                else
                    dis[i][j] = Math.min(dis[i - 1][j - 1], Math.min(dis[i][j - 1], dis[i - 1][j])) + 1;
            }
        }
        return dis[word1.length()][word2.length()];
    }

}
