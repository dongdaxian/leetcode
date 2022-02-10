package below100.problem59;

public class Test {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int curRow = 0, curCol = -1;
        while (n > 0) {
            for (int i = 0; i < n; i++) {
                res[curRow][++curCol] = num++;
            }
            for (int i = 0; i < n - 1; i++) {
                res[++curRow][curCol] = num++;
            }
            if (n == 1)
                break;
            for (int i = 0; i < n - 1; i++) {
                res[curRow][--curCol] = num++;
            }
            for (int i = 0; i < n - 2; i++) {
                res[--curRow][curCol] = num++;
            }
            n -= 2;
        }
        return res;
    }
}
