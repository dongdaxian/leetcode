package below100.problem73;

public class Test {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0}};
        new Test().setZeroes(matrix);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagr = false, flagc = false;
        for (int i = 1; i < m; i++)
            if (matrix[i][0] == 0)
                flagc = true;
        for (int j = 1; j < n; j++)
            if (matrix[0][j] == 0)
                flagr = true;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
                else if ((i == 0 && flagr) || (j == 0 && flagc))
                    matrix[i][j] = 0;
        }


    }

}
