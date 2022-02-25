package below100.problem84;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().largestRectangleArea1_2(new int[]{2,1,5,6,2,3}));

    }
    //暴力解法是O(n^2)，但从直觉来说结果复杂度应该小于排序，会有更好时间复杂度的解法
    //类似42题第二种解法，找出每一根柱子对应的左右边界
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int[] fromLeft = new int[n];
        int[] fromRight = new int[n];
        fromLeft[0] = -1;
        fromRight[n - 1] = n;
        for (int i = 1, j = 0; i < n; i++) {                //类似于28题kmp中计算模式串的算法，时间复杂度为O(n)
            j = i - 1;
            while (j > -1 && heights[i] <= heights[j])
                j = fromLeft[j];
            fromLeft[i] = j;
        }
        for (int i = n - 2, j = n - 1; i > -1; i--) {
            j = i + 1;
            while (j < n && heights[i] <= heights[j])
                j = fromRight[j];
            fromRight[i] = j;
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++)
            maxArea = Math.max(maxArea, heights[i] * (fromRight[i] - fromLeft[i] - 1));
        return maxArea;
    }

    //使用单调栈计算fromLeft、fromRight
    public int largestRectangleArea1_2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int[] fromLeft = new int[n];
        int[] fromRight = new int[n];
        Arrays.fill(fromLeft, -1);
        Arrays.fill(fromRight, n);
        //使用单调栈计算fromLeft、fromRight
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n - 1; i > -1; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                fromLeft[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                fromRight[stack.pop()] = i;
            }
            stack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++)
            maxArea = Math.max(maxArea, heights[i] * (fromRight[i] - fromLeft[i] - 1));
        return maxArea;
    }

    //另一种单调栈
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            if (st.isEmpty() || (i != heights.length && heights[i] >= heights[st.peek()])) {
                st.push(i);
            } else {
                int temp = heights[st.pop()];
                maxArea = Math.max(maxArea, (st.isEmpty() ? i : (i - st.peek() - 1)) * temp);
                i--;
            }
        }

        return maxArea;
    }

    //时间复杂度O(nlogn)
    public int largestRectangleArea3(int[] heights) {    //分治法
        return getMaxArea(heights, 0, heights.length - 1);
    }

    public int getMaxArea(int[] heights, int i, int j) {
        if (i > j) return 0;
        if (i == j) return heights[i];
        int min = Integer.MAX_VALUE;
        int ptr = 0;

        for (int k = i; k <= j; k++) {
            if (min > heights[k]) {
                min = heights[k];
                ptr = k;
            }

        }

        return Math.max(min * (j - i + 1), Math.max(getMaxArea(heights, i, ptr - 1), getMaxArea(heights, ptr + 1, j)));
    }
}
