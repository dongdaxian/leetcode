package below50.problem42;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new Test().trap2(height));
	}
	
	public int trap1(int[] height) {
		int sum = 0;
		int n = height.length;
		if(n < 2) return 0;
		boolean[] flag = new boolean[n]; flag[0] = true; flag[n - 1] = true;
		
//		int i = 1, j = n - 2;
//		int record = 0;
//		while(i < n) {										//ֻ����һ�Σ�һ������һ��while/for����ɣ�����Ҫ��while����Ƕ��for(��Ȼʱ�临�ӶȲ���)
//			record = height[i - 1];
//			for(; i < n && record > height[i]; i++);
//			if(i < n)
//				flag[i++] = true;
//		}		
//		while(j > -1) {
//			record = height[j + 1];
//			for(; j > -1 && record > height[j]; j--);
//			if(j > -1) 
//				flag[j--] = true;
//		}
		
		for(int record = height[0], i = 1; i < n; i++) {              
			if(record <= height[i]) {
				record = height[i];
				flag[i] = true;
			}
		}
		for(int record = height[n - 1], i = n - 2; i > -1; i--) {
			if(record <= height[i]) {
				flag[i] = true;
				record = height[i];
			}
		}
		int edge = 0;
		for(int i = 0, j = 1; j < n; j++){
			if(flag[j]) {
//				edge = height[i] > height[j] ? height[j] : height[i];
				edge = Math.min(height[i], height[j]);                           
				for(int k = i + 1; k < j; k++)
					sum += edge - height[k];
				i = j;
			}
		}
		return sum;
    }
	
	
	public int trap2(int[] height) {			//��̬�滮��˼�룬�˴����Ǳ��ÿһ�����۵��������꣬���Ƕ���ÿһ��������������ǽ�ڵĸ߶�
		if(height.length < 3) return 0;    
		int n = height.length;
		int[] leftMax = new int[n];//leftMax[i]��ʾ��������i��������ǽ�ڸ߶�
		int[] rightMax = new int[n];
		for(int i = 1; i < n - 1; i++) leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
		for(int i = n - 2; i > 0; i--) rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
		
		int sum = 0;
		for(int i = 1; i < n - 1; i++) {
			int temp = Math.min(leftMax[i], rightMax[i]);
			if(height[i] < temp)
				sum += temp - height[i];
		}		
		
		return sum;
	}
	
	
	public int trap3(int[] height) {			//�Է������ĸĽ����������ָ�����м�ɨ������ֻ��һ�����飬��Ϊֻ��Ҫ��¼����ǽ�ڸ߶ȵ���Сֵ
		if(height.length < 3) return 0;    		//ֻҪ������ǽ��С����ǽ�ڣ���һ��������ɨ����Ϊ����i���յ���ǽ��ֻ�п��ܸ���
		int n = height.length;
		int[] wall = new int[n];
		int leftWall = height[0], rightWall = height[n - 1];
		int i = 1, j = n - 2;
		while(i <= j) {
			if(height[i] > leftWall) leftWall = height[i];
			if(height[j] > rightWall) rightWall = height[j];
			if(leftWall < rightWall)
				wall[i++] = leftWall;
			else
				wall[j--] = rightWall;
		}
		
		int sum = 0;
		for(i = 1; i < n - 1; i++)
			sum += wall[i] - height[i];
		
		return sum;
	}
	
	public int trap4(int[] height) { 				//�������ĸĽ��棬�Ѷ�Ӧ������̺���һ����
        if(height.length < 3) return 0;             
        int sum = 0;
		int i = 0, j = height.length - 1;
		int leftmax = height[i], rightmax = height[j];
		while(i < j) {									
			if(height[i] > leftmax) leftmax = height[i];
			if(height[j] > rightmax) rightmax = height[j];
			if(leftmax <= rightmax) 				
				sum += leftmax - height[i++];
			else
				sum += rightmax - height[j--];
		}
		return sum;
	}
	
	public int trap5(int[] height) { 				//˼·�Ǽ���ÿ����ʢˮ�Ŀմ�
        if(height.length < 3) return 0;             //����ʹ��ջ
        int sum = 0;
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < height.length; i++) {
			if(st.isEmpty() || height[st.peek()] >= height[i]) {
				st.push(i);
			} else {
				int temp = height[st.pop()];
				if(st.isEmpty()) {
					i--;
					continue;
				}
				sum += (Math.min(height[st.peek()], height[i]) - temp) * (i - st.peek() - 1);
				i--;
			}
		}
        
		return sum;
	}

}
