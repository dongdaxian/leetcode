package nowcoder.jianzhi;

public class Solution19 {

    public boolean match (String str, String pattern) {
        boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < pattern.length(); j++) {
            if (pattern.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j - 1];
            }
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pattern.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i + 1][j - 1];
                    if (str.charAt(i) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j + 1] || dp[i][j + 1];
                    }
                }
            }
        }

        return dp[str.length()][pattern.length()];
    }

}
