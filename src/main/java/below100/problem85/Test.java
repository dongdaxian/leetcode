package below100.problem85;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
//		char[][] matrix = new char[][]{
//			{'1','0','1','0','0'},
//			{'1','0','1','1','1'},
//			{'1','1','1','1','1'},
//			{'1','0','0','1','0'}};
//		char[][] matrix = new char[][]{{'1'}};

        char[][] matrix = new char[][]{
                {'0', '1', '1', '0', '1'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(new Test().maximalRectangle2(matrix));

    }

    public int maximalRectangle1(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] rowArea = new int[m][n];
        for (int i = 0; i < m; i++)
            if (matrix[i][0] == '1')
                rowArea[i][0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == '1')
                    rowArea[i][j] = rowArea[i][j - 1] + 1;

        int maxArea = 0;                             //此时已经转化为n个问题84了
		//连续三列的高度是1 3 3，显然最大面积是6而不是3，放在84题的图中就很容易理解错在哪里(此方法错误)
        for (int j = 0; j < n; j++) {
            for (int i = 0, min = Integer.MAX_VALUE, len = 0; i < m; i++) {
                if (rowArea[i][j] > 0) {
                    min = Math.min(min, rowArea[i][j]);
                    len++;
                    maxArea = Math.max(maxArea, len * min);
                } else {
                    len = 0;
                    min = Integer.MAX_VALUE;
                }
            }
        }
        return maxArea;
    }

    public int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] colArea = new int[m][n];                //按列计算，方便传入problem84的函数
        for (int i = 0; i < n; i++)
            if (matrix[0][i] == '1')
                colArea[0][i] = 1;
        for (int j = 0; j < n; j++)
            for (int i = 1; i < m; i++)
                if (matrix[i][j] == '1')
                    colArea[i][j] = colArea[i - 1][j] + 1;

        int maxArea = 0;
        below100.problem84.Test ts = new below100.problem84.Test();
        for (int i = 0; i < m; i++)
            maxArea = Math.max(maxArea, ts.largestRectangleArea1(colArea[i]));

        return maxArea;
    }

    public int maximalRectangle3(char[][] matrix) {    //我们更新一次 heights，就利用之前的算法求一遍 leftLessMin[]和 rightLessMin[]
        if (matrix.length == 0) return 0;        //其实求 leftLessMin[]和rightLessMin[]可以利用之前的来更新本次的

        int maxArea = 0;
        int cols = matrix[0].length;
        int[] leftLessMin = new int[cols];
        int[] rightLessMin = new int[cols];
        Arrays.fill(leftLessMin, -1); //初始化为 -1，也就是最左边
        Arrays.fill(rightLessMin, cols); //初始化为 cols，也就是最右边
        int[] heights = new int[cols];
        for (int row = 0; row < matrix.length; row++) {
            //更新所有leftLessMin。如果要把这种更新方式应用到84题，需要以柱状图中最高高度作为cols，一层一层更新下来
            int boundary = -1; //记录上次出现 0 的位置
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    //和上次出现 0 的位置比较
                    leftLessMin[col] = Math.max(leftLessMin[col], boundary);
                } else {
                    //当前是 0 代表当前高度是 0，所以初始化为 -1，防止对下次循环的影响
                    leftLessMin[col] = -1;
                    boundary = col;
                }
            }
            boundary = cols;
            for (int col = cols - 1; col >= 0; col--) {
                if (matrix[row][col] == '1') {
                    rightLessMin[col] = Math.min(rightLessMin[col], boundary);
                } else {
                    rightLessMin[col] = cols;
                    boundary = col;
                }
            }

            //更新所有高度
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    heights[col]++;
                } else {
                    heights[col] = 0;
                }
            }
            for (int col = cols - 1; col >= 0; col--) {
                int area = (rightLessMin[col] - leftLessMin[col] - 1) * heights[col];
                maxArea = Math.max(area, maxArea);
            }

        }
        return maxArea;

    }


}
