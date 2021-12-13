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
		//��һ���õ��ǿ��ţ����Ӷ���O(nlogn)
		Arrays.sort(res);
		return res;
    }
	
	public int[] sortedSquares2(int[] A) {
		int[] res = new int[A.length];
		int i = 0, j = A.length - 1;
		int ptr = A.length - 1;
		//����һ��˫ָ���Ǵ������ֽ�㿪ʼ����������Ҫ�����ж�����ָ��ֱ����-1��A.length�����
		while(i <= j) {
			if(A[i] * A[i] < A[j] * A[j])
				res[ptr--] = A[j] * A[j--];
			else
				res[ptr--] = A[i] * A[i++];
		}
		
		return res;
    }
}
