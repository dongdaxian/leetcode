package below1000.problem977;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		
	}
	
	public int[] sortedSquares(int[] A) {
		int[] res = new int[A.length];
		for(int i = 0; i < A.length; i++)
			res[i] = A[i] * A[i];
		//这一步用的是快排，复杂度是O(nlogn)
		Arrays.sort(res);
		return res;
    }
	
	public int[] sortedSquares2(int[] A) {
		int[] res = new int[A.length];
		int i = 0, j = A.length - 1;
		int ptr = A.length - 1;
		//还有一种双指针是从正负分界点开始，但这样需要额外判断两个指针分别等于-1和A.length的情况
		while(i <= j) {
			if(A[i] * A[i] < A[j] * A[j])
				res[ptr--] = A[j] * A[j--];
			else
				res[ptr--] = A[i] * A[i++];
		}
		
		return res;
    }
}
