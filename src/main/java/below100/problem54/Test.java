package below100.problem54;

import java.util.ArrayList;
import java.util.List;

public class Test {


//    �취������������Ϊint[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}��dirIndex�����Ӧ�±꣬
//    curRow��curCol�޸ĺ��糬���߽���Ѿ����ʹ���λ�ã���dirIndex��һ�����¼���curRow��curCol
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
