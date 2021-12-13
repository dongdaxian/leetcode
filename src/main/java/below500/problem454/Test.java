package below500.problem454;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
	
	
	public static void main(String[] args) {
		System.out.println(new Test().fourSumCount3(new int[] {-1, 0, 1}, new int[] {-1, 0, 1}, new int[] {0, 0, 1}, new int[] {-1, 1, 1}));
		
		
	}
	
	//µİ¹é¼ôÖ¦
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        return fourSumCount(A, B, C, D, new int[] {0, 0, 0, 0}, 0);
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D, int[] index, int order){
        int len = A.length;
        if(index[0] >= len || index[1] >= len || index[2] >= len || index[3] >= len)
            return 0;
        int sum = A[index[0]] + B[index[1]] + C[index[2]] + D[index[3]];
        int res = 0;
        if(sum > 0)
            res = 0;
        else{
        	if(sum == 0)
        		res++;
        	while(order < 4) {
        		index[order]++;
        		res += fourSumCount(A, B, C, D, index, order);
        		index[order]--;
        	}
        }
        return res;
    }
    
    //·Çµİ¹é¼ôÖ¦
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
    	Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int n = A.length;
        int res = 0;
        for(int i = 0; i < n; i++)
        	for(int j = 0; j < n; j++)
        		for(int k = 0; k < n; k++)
        			for(int l = 0; l < n; l++) {
        				int sum = A[i] + B[j] + C[k] + D[l];
        				if(sum == 0)
        					res++;
        				else if(sum > 0)
        					break;
        			}
    	
    	return res;
    }
    
    public int fourSumCount3(int[] A, int[] B, int[] C, int[] D) {
    	Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i: A)
            for(int j: B){
                map.put(-i - j, map.getOrDefault(-i - j, 0) + 1);
            }

        for(int i: C)
            for(int j: D){
                res += map.getOrDefault(i + j, 0);
            }
        
        return res;
    }
    
}
