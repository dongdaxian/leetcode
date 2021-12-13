package below850.problem845;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().longestMountain(new int[] {2, 1, 4, 7, 3, 2, 5}));

	}

	public int longestMountain(int[] A) {
		int len = A.length;
        int i = 0;
        int mountainLen = 0;
        while(i < len) {
            int beg = i;
            ++i;
            for(; i < len && A[i - 1] < A[i]; i++);
            if(i == beg + 1)
                continue;
            int temp = i;
            
            for(; i < len && A[i - 1] > A[i]; i++);
            if(i == temp)
                continue;
            mountainLen = Math.max(mountainLen, i - beg);
        }
        return mountainLen;
    }
	
}
