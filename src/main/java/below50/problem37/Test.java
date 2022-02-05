package below50.problem37;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {
        doSolve2(board, 0, 0);
    }

    //有返回值版本，此时第一次调用时的返回值是无用的
    public boolean doSolve1(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) {
            for (int j = col; j < 9; j++) {                        //两个for循环主要用于碰到非'.'时选择下一个，其实不会遍历，与方法2本质相同
                if (board[i][j] != '.')
                    continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (doSolve1(board, i, j + 1))
                            return true;
                        board[i][j] = '.';
                    }

                }
                return false;
            }
        }
        return true;
    }

    public boolean doSolve2(char[][] board, int row, int col) {
        int i = 0, j = 0;
        for (i = row; i < 9; i++, col = 0) {
            for (j = col; j < 9 && board[i][j] != '.'; j++) ;
            if (j != 9) break;
        }
        if (i == 9) return true;

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, i, j, num)) {
                board[i][j] = num;
                if (doSolve2(board, i, j + 1))
                    return true;
                board[i][j] = '.';
            }
        }
        return false;
    }


    //无返回值版本
    boolean flag = false;

    public void doSolve3(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) {
            for (int j = col; j < 9; j++) {                        //两个for循环主要用于碰到非'.'时选择下一个，其实不会遍历，与方法2本质相同
                if (board[i][j] != '.')
                    continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        doSolve3(board, i, j + 1);
                        if (flag)
                            return;
                        board[i][j] = '.';
                    }
                }
                return;
            }
        }
        flag = true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int rowbeg = (row / 3) * 3, colbeg = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num || board[rowbeg + i / 3][colbeg + i % 3] == num)
                return false;
        }
        return true;
    }

    boolean[][] lines = new boolean[9][9];
    boolean[][] columns = new boolean[9][9];
    boolean[][][] blocks = new boolean[3][3][9];
    List<int[]> ls = new ArrayList<>();
    boolean valid = false;

    public void solveSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    ls.add(new int[]{i, j});
                else {
                    int digit = board[i][j] - '0' - 1;
                    lines[i][digit] = columns[digit][j] = blocks[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    private void dfs(char[][] board, int beg) {
        if (beg == ls.size()) {
            valid = true;
            return;
        }

        int i = ls.get(beg)[0];
        int j = ls.get(beg)[1];
        for (int num = 0; num < 9 && !valid; num++) {
            if (!lines[i][num] && !columns[num][j] && !blocks[i / 3][j / 3][num]) {
                board[i][j] = (char) (num + '0' + 1);
                lines[i][num] = columns[num][j] = blocks[i / 3][j / 3][num] = true;
                dfs(board, beg + 1);
//				if(valid)
//					return;
                lines[i][num] = columns[num][j] = blocks[i / 3][j / 3][num] = false;
            }
        }
    }

}
