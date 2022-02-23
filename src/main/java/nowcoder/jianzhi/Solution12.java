package nowcoder.jianzhi;

public class Solution12 {

    public static void main(String[] args) {
        System.out.println(new Solution12().hasPath(new char[][]{{'A','B'},{'C','D'}},"DCAB"));
        ;
    }

    public boolean hasPath (char[][] matrix, String word) {
        // write code here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int len = matrix.length * matrix[0].length;
        boolean[] flag = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (dfs(matrix, word, i, 0, flag)) {
                return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] matrix, String word, int matrixIndex, int strIndex, boolean[] flag) {
        int colLen = matrix[0].length;
        boolean ret = false;
        if (flag[matrixIndex] || matrix[matrixIndex / colLen][matrixIndex % colLen] != word.charAt(strIndex)) {
            return ret;
        }
        if (strIndex == word.length() - 1) {
            ret = true;
        } else {
            flag[matrixIndex] = true;
            ret = ret || ((matrixIndex + 1) % colLen != 0 && matrixIndex + 1 < matrix.length * colLen && dfs(matrix, word, matrixIndex + 1, strIndex + 1, flag));
            ret = ret || (matrixIndex % colLen != 0 && matrixIndex - 1 >= 0 && dfs(matrix, word, matrixIndex - 1, strIndex + 1, flag));
            ret = ret || (matrixIndex + colLen < matrix.length * colLen && dfs(matrix, word, matrixIndex + colLen, strIndex + 1, flag));
            ret = ret || (matrixIndex - colLen >= 0 && dfs(matrix, word, matrixIndex - colLen, strIndex + 1, flag));
            flag[matrixIndex] = false;
        }

        return ret;
    }
}
