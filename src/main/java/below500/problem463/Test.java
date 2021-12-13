package below500.problem463;

public class Test {
	public static void main(String[] args) {
		
	}
	
	public int islandPerimeter(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;
        int len = 0;
        int colNum = grid[0].length;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < colNum; j++){
                if(grid[i][j] == 1){
                    if(j == 0)
                        ++len;
                    if(j == colNum - 1)
                        ++len;
                    if(j > 0 && grid[i][j - 1] == 0)
                        ++len;
                    if(j < colNum - 1 && grid[i][j + 1] == 0)
                        ++len;
                }
            }
        }

        for(int j = 0; j < colNum; j++){
            for(int i = 0; i < grid.length; i++){
                if(grid[i][j] == 1){
                    if(i == 0)
                        ++len;
                    if(i == grid.length - 1)
                        ++len;
                    if(i > 0 && grid[i - 1][j] == 0)
                        ++len;
                    if(i < grid.length - 1 && grid[i + 1][j] == 0)
                        ++len;
                }
            }
        }
        return len;
    }
}
