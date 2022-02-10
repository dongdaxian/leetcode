package below50.problem44;

public class Test {

    public static void main(String[] args) {
        System.out.print(new Test().isMatch("aab", "c*a*b"));
    }

    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] match = new boolean[slen + 1][plen + 1];
        match[0][0] = true;
        for (int i = 0; i < plen; i++)
            if (p.charAt(i) == '*')
                match[0][i + 1] = match[0][i];
        for (int i = 0; i < slen; i++)
            for (int j = 0; j < plen; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    match[i + 1][j + 1] = match[i][j];
                else if (p.charAt(j) == '*') {
                    match[i + 1][j + 1] = match[i][j] || match[i + 1][j] || match[i][j + 1];
                }
            }

        return match[slen][plen];
    }
}
