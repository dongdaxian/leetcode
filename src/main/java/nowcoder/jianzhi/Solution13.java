package nowcoder.jianzhi;

public class Solution13 {

    public static void main(String[] args) {
        System.out.println(new Solution13().movingCount(1, 2, 3));
    }

    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] matrix = new boolean[rows][cols];
        return dfs(matrix, rows, cols, 0, 0, threshold);
    }

    //BFS也可以
    public int dfs(boolean[][] matrix, int rows, int cols, int i, int j, int threshold) {
        if (i >= rows || j >= cols || i < 0 || j < 0 || matrix[i][j]) {
            return 0;
        }
        int posSum = 0;
        int tmpi = i;
        int tmpj = j;
        while (tmpi != 0) {
            posSum += tmpi % 10;
            tmpi = tmpi / 10;
        }
        while (tmpj != 0) {
            posSum += tmpj % 10;
            tmpj = tmpj / 10;
        }
        if (posSum > threshold) {
            return 0;
        }
        matrix[i][j] = true;
        int count = 1;
        for(int[] direc: DIRECTIONS) {
            count += dfs(matrix, rows, cols, i + direc[0], j + direc[1], threshold);
        }
        return count;
    }

}
