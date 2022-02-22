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
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dis[i][j] = dis[i - 1][j - 1];
                else
                    dis[i][j] = Math.min(dis[i - 1][j - 1], Math.min(dis[i][j - 1], dis[i - 1][j])) + 1;  //replace、insert、delete
            }
        }
        return dis[word1.length()][word2.length()];
    }

}
