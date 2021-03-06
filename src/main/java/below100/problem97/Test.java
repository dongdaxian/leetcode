package below100.problem97;

public class Test {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(new Test().isInterleave2(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
//		return backtrack(s1, s2, s3, 0, 0);
        boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
        return backtrack(s1, s2, s3, 0, 0, matrix);
    }

    public boolean backtrack(String s1, String s2, String s3, int i, int j) {
        if (i + j == s3.length())
            return true;
        //避免复杂的if-else判断
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            res = res || backtrack(s1, s2, s3, i + 1, j);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            res = res || backtrack(s1, s2, s3, i, j + 1);
        }
        return res;
    }


    /*
    * 同一个小问题可能多次计算，matrix[i][j]表示是否计算过该子问题，子问题只要是第二次计算，说明会返回false，
    * */
    public boolean backtrack(String s1, String s2, String s3, int i, int j, boolean[][] matrix) {
        if (i + j == s3.length())
            return true;
        if (matrix[i][j])
            return false;
        matrix[i][j] = true;             //法三
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            res = res || backtrack(s1, s2, s3, i + 1, j, matrix);
//			matrix[i + 1][j] = !res;     //法一
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            res = res || backtrack(s1, s2, s3, i, j + 1, matrix);
//			matrix[i][j + 1] = !res;
        }
//		matrix[i][j] = !res;			//法二
        return res;
    }

    //真正用dp
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
        matrix[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            matrix[i + 1][0] = matrix[i][0] && (s1.charAt(i) == s3.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            matrix[0][i + 1] = matrix[0][i] && (s2.charAt(i) == s3.charAt(i));
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                matrix[i + 1][j + 1] = (matrix[i][j + 1] && s1.charAt(i) == s3.charAt(i + j + 1))
                        || (matrix[i + 1][j] && s2.charAt(j) == s3.charAt(i + j + 1));
            }
        }
        return matrix[s1.length()][s2.length()];
    }

}
