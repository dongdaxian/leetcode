package below950.problem941;

public class Test {
    public boolean validMountainArray(int[] A) {
        if(A == null || A.length < 3) return false;
        int ptr = 0;
        int temp = ptr;
        ptr++;
        for(; ptr < A.length && A[ptr - 1] < A[ptr]; ptr++);
        if(ptr == temp + 1)
            return false;
        temp = ptr - 1;
        for(; ptr < A.length && A[ptr - 1] > A[ptr]; ptr++);
        if(ptr == temp + 1)
            return false;
        return ptr == A.length;
    }
}
