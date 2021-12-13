package below350.problem304;

public class Test {
    int[][] sum;

    public Test(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return;
        int n = matrix[0].length;
        if(n == 0)
            return;
        sum = new int[m][n + 1];
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n + 1; j++) {
                sum[i][j] = sum[i][j - 1] + matrix[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sum == null)
            return 0;
        int ret = 0;
        for(int i = row1; i <= row2; i++) {
            ret += sum[i][col2 + 1] - sum[i][col1];
        }

        return ret;
    }
}
