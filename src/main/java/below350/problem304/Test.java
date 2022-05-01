package below350.problem304;

public class Test {
    int[][] sum;

    public Test(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        sum = new int[m][n + 1];
//        for(int i = 0; i < m; i++) {
//            for(int j = 1; j < n + 1; j++) {
//                sum[i][j] = sum[i][j - 1] + matrix[i][j - 1];
//            }
//        }

        //法二
        int m = matrix.length;;
        int n = matrix[0].length;
        sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
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

    public int sumRegion2(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}
