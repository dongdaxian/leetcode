package below50.problem5;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] flag = new boolean[len][len];
        int beg = -1, end = -1;
        for (int k = 0; k < len; k++)
            for (int i = 0; i + k < len; i++) {
                if (s.charAt(i) == s.charAt(i + k)) {
                    if (k < 3) {
                        flag[i][i + k] = true;
                    } else if (flag[i + 1][i + k - 1]) {
                        flag[i][i + k] = true;
                    }
                    if (flag[i][i + k]) {
                        beg = i;
                        end = i + k;
                    }
                }
            }
        return s.substring(beg, end + 1);
    }


}
