package below100.problem54;

import java.util.ArrayList;
import java.util.List;

public class Test {


//    办法二，方向设置为int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}，dirIndex代表对应下标，
//    curRow和curCol修改后，如超出边界或已经访问过该位置，则dirIndex加一并重新计算curRow和curCol
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int curRow = 0;
        int curCol = -1;
        List<Integer> res = new ArrayList<>();
        while(row > 0 && col > 0) {
            for(int i = 0; i < col; i++) {
                curCol++;
                res.add(matrix[curRow][curCol]);
            }
            for(int i = 0; i < row - 1; i++) {
                curRow++;
                res.add(matrix[curRow][curCol]);
            }
            if(row == 1 || col == 1)
                break;
            for(int i = 0; i < col - 1; i++) {
                curCol--;
                res.add(matrix[curRow][curCol]);
            }
            for(int i = 0; i < row - 2; i++) {
                curRow--;
                res.add(matrix[curRow][curCol]);
            }
            row -= 2;
            col -= 2;
        }
        return res;
    }
}
