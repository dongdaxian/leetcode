package below100.problem79;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().exist(new char[][]{{'A','B'}, {'C','D'}}, "ACDB"));

	}
	public boolean exist(char[][] board, String word) {
		boolean[][] flag = new boolean[board.length][board[0].length]; 
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == word.charAt(0) && beginAtIJ(board, word, i, j, 0, flag))
					return true;
			}
		}
		return false;
    }
	public boolean beginAtIJ(char[][] board, String word, int i, int j, int k, boolean[][] flag) {
		if(k == word.length()) return true;
		if(i > -1 && i < board.length && j > -1 && j < board[0].length) {
			if(board[i][j] == word.charAt(k) && !flag[i][j]) {
				flag[i][j] = true;				//也可以不用flag，把board设置成其他值表示已遍历过
				if(beginAtIJ(board, word, i + 1, j, k + 1, flag) || beginAtIJ(board, word, i - 1, j, k + 1, flag) ||
						beginAtIJ(board, word, i, j + 1, k + 1, flag) || beginAtIJ(board, word, i, j - 1, k + 1, flag))
					return true;
				flag[i][j] = false;
			}
		}
		return false;
	}

}
