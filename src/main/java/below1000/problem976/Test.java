package below1000.problem976;

import java.util.Arrays;

public class Test {
	public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int ptr = A.length - 1;
        int sidea = A[ptr--];
        int sideb = A[ptr--];
        int sidec = A[ptr--];
        while(ptr > -1 && sideb + sidec <= sidea){
            sidea = sideb;
            sideb = sidec;
            sidec = A[ptr--];
        }
        if(sideb + sidec > sidea)
            return sidea + sideb + sidec;
        return 0;
    }
}
