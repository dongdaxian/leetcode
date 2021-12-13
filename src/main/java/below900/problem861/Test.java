package below900.problem861;

public class Test {
	public static void main(String[] args) {
		
		System.out.println(new Test().matrixScore(new int[][] {{0, 1}, {1, 1}}));
	}
	
	public int matrixScore(int[][] A) {
        for(int[] temp: A){
            if(temp[0] == 0){
                for(int i = 0; i < temp.length; i++){
                    temp[i] = 1 - temp[i];
                }
            }
        }

        int xlen = A.length;
        int ylen = A[0].length;
        for(int j = 0; j < ylen; j++){
            int count = 0;
            for(int i = 0; i < xlen; i++){
                if(A[i][j] == 1)
                    count++;
                else
                    count--;
            }
            if(count < 0){
                for(int i = 0; i < xlen; i++){
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        int res = 0;
        for(int[] temp: A){
            int basis = 1;
            for(int i = temp.length - 1; i > -1; i--){
                res += temp[i] * basis;
                basis = 2 * basis;
            }

        }
        return res;
    }
	
	//方法一的三步可以合在一个循环中
	public int matrixScore2(int[][] A) {
		int m = A.length, n = A[0].length;
		int res = m * (1 << (n - 1));
		
		for(int j = 1; j < n; j++) {
			int nOnes = 0;
			for(int i = 0; i < m; i++) {
				if(A[i][0] == 1) {
					nOnes += A[i][j];
				} else {
					nOnes += (1 - A[i][j]);
				}
			}
			nOnes = Math.max(nOnes, m - nOnes);
			res += nOnes * (1 << (n - j - 1));
		}
		return res;
	}
	
}
