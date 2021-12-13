package below1050.problem1030;

import java.util.Map;

public class Test {
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] dis = new int[][]{{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        int[][] res = new int[R * C][];
        int index = 0;
        res[index++] = new int[]{r0, c0};
        int maxDis = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        int row = r0, col = c0;
        for(int i = 0; i < maxDis; i++){
            row--;
            for(int j = 0; j < 4; j++){
                while((j % 2 == 0 && row != r0) || (j % 2 != 0 && col != c0)){
                    if(row < R && row >= 0 && col >= 0 && col < C){
                        res[index++] = new int[]{row, col};
                    }
                    row += dis[j][0];
                    col += dis[j][1];
                }
            }
        }
        return res;
        
        
    }
}
