package below100.problem84;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().largestRectangleArea2(new int[]{1,5,1}));

	}
	
	public int largestRectangleArea1(int[] heights) {	//对应42题第二种解法
		if (heights == null || heights.length == 0) return 0;
		int n = heights.length;
		int[] fromLeft = new int[n];
		int[] fromRight = new int[n];
		fromLeft[0] = -1;
		fromRight[n - 1] = n;
		for(int i = 1, j = 0; i < n; i++) {
			j = i - 1;
			while(j > -1 && heights[i] <= heights[j])	//仍是两层循环，此处用for(;;j--)复杂度不变
				j = fromLeft[j];
			fromLeft[i] = j;
		}
		for(int i = n - 2, j = n - 1; i > -1; i--) {
			j = i + 1;
			while(j < n && heights[i] <= heights[j])
				j = fromRight[j];
			fromRight[i] = j;
		}
		
		int maxArea = 0;
		for(int i = 0; i < n; i++) 
			maxArea = Math.max(maxArea, heights[i] * (fromRight[i] - fromLeft[i] - 1));
		return maxArea;
    }

	public int largestRectangleArea2(int[] heights) {	//使用栈
		if (heights == null || heights.length == 0) return 0;
		Stack<Integer> st = new Stack<>();
	    int maxArea = 0;
	    for(int i = 0; i <= heights.length; i++) {
	    	
	    	if(st.isEmpty() || (i != heights.length && heights[i] >= heights[st.peek()]))
	    		st.push(i);
	    	else {
	    		int temp = heights[st.pop()];
	    		maxArea = Math.max(maxArea, (st.isEmpty() ? i : (i - st.peek() - 1)) * temp);
	    		i--;
	    	}
	    }
	    
		return maxArea;
    }
	
	public int largestRectangleArea3(int[] heights) {	//分治法
		return getMaxArea(heights, 0, heights.length - 1);
	}

	public int getMaxArea(int[] heights, int i, int j) {
		if(i > j) return 0;
		if(i == j) return heights[i];
		int min = Integer.MAX_VALUE;
		int ptr = 0;
		
		for(int k = i; k <= j; k++) {
			if(min > heights[k]) {
				min = heights[k];
				ptr = k;
			}

		}
		
		return Math.max(min * (j - i + 1), Math.max(getMaxArea(heights, i, ptr - 1), getMaxArea(heights, ptr + 1, j)));
	}	
}
