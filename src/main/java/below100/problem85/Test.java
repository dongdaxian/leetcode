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
			{'0','1','1','0','1'},
			{'1','1','0','1','0'},
			{'0','1','1','1','0'},
			{'1','1','1','1','0'},
			{'1','1','1','1','1'},
			{'0','0','0','0','0'}};
			System.out.println(new Test().maximalRectangle2(matrix));

	}

	public int maximalRectangle1(char[][] matrix) {	
		if(matrix == null || matrix.length == 0) return 0;
		int m = matrix.length, n = matrix[0].length;
		int[][] rowArea = new int[m][n];
		for(int i = 0; i < m; i++)
			if(matrix[i][0] == '1')
				rowArea[i][0] = 1;
		for(int i = 0; i < m; i++)
			for(int j = 1; j < n; j++)
				if(matrix[i][j] == '1')
					rowArea[i][j] = rowArea[i][j - 1] + 1;
		
		int maxArea = 0;							//��ʱ�Ѿ�ת��Ϊn������84��
		for(int j = 0; j < n; j++) {				//�������еĸ߶���1 3 3����Ȼ��������6������3������84���ͼ�оͺ���������������(�˷�������)
			for(int i = 0, min = Integer.MAX_VALUE, len = 0; i < m; i++) {		
				if(rowArea[i][j] > 0) {
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
		if(matrix == null || matrix.length == 0) return 0;
		int m = matrix.length, n = matrix[0].length;
		int[][] colArea = new int[m][n];				//���м��㣬���㴫��problem84�ĺ���
		for(int i = 0; i < n; i++)
			if(matrix[0][i] == '1')
				colArea[0][i] = 1;
		for(int j = 0; j < n; j++)
			for(int i = 1; i < m; i++)
				if(matrix[i][j] == '1')
					colArea[i][j] = colArea[i - 1][j] + 1;
		
		int maxArea = 0;	
		below100.problem84.Test ts = new below100.problem84.Test();
		for(int i = 0; i < m; i++) 
			maxArea = Math.max(maxArea, ts.largestRectangleArea1(colArea[i]));
		
		return maxArea;
	}
	
	public int maximalRectangle3(char[][] matrix) {	//���Ǹ���һ�� heights��������֮ǰ���㷨��һ�� leftLessMin[]�� rightLessMin[]
		    if (matrix.length == 0) return 0;		//��ʵ�� leftLessMin[]��rightLessMin[]��������֮ǰ�������±��ε�
		    
		    int maxArea = 0;
		    int cols = matrix[0].length;
		    int[] leftLessMin = new int[cols];
		    int[] rightLessMin = new int[cols];
		    Arrays.fill(leftLessMin, -1); //��ʼ��Ϊ -1��Ҳ���������
		    Arrays.fill(rightLessMin, cols); //��ʼ��Ϊ cols��Ҳ�������ұ�
		    int[] heights = new int[cols];
		    for (int row = 0; row < matrix.length; row++) {
		        //��������leftLessMin�����Ҫ�����ָ��·�ʽӦ�õ�84�⣬��Ҫ����״ͼ����߸߶���Ϊcols��һ��һ���������
		        int boundary = -1; //��¼�ϴγ��� 0 ��λ��
		        for (int col = 0; col < cols; col++) {
		            if (matrix[row][col] == '1') {
		                //���ϴγ��� 0 ��λ�ñȽ�
		                leftLessMin[col] = Math.max(leftLessMin[col], boundary);
		            } else {
		                //��ǰ�� 0 ����ǰ�߶��� 0�����Գ�ʼ��Ϊ -1����ֹ���´�ѭ����Ӱ��
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

		        //�������и߶�
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
