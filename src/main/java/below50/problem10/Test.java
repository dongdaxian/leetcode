package below50.problem10;

public class Test {

    public static void main(String[] args) {
        String s = "abc";
        String p = "c*a*b*c*";
        System.out.print(new Test().isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {    //因为s与p的match，与s-1和p-1的match、s和p-1的match、s-1和p的match的结果有关，所以可以用动态规划
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*')
                dp[0][j + 1] = dp[0][j - 1];
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];                                //如果数组维度没有多申请1，应是dp[i][j]=dp[i-1][j-1]，需要处理i=0和j=0的情况
                } else if (p.charAt(j) == '*') {
                    //dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j];
                    if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j + 1] || dp[i][j + 1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];

    }

}
