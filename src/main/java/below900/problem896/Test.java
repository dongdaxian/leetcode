package below900.problem896;

public class Test {
    public boolean isIncrease(int[] A) {
        int pre = Integer.MIN_VALUE;
        for(int tmp: A) {
            if(tmp < pre) {
                return false;
            }
            pre = tmp;
        }
        return true;
    }
    public boolean isDecrease(int[] A) {
        int pre = Integer.MAX_VALUE;
        for(int tmp: A) {
            if(tmp > pre) {
                return false;
            }
            pre = tmp;
        }
        return true;
    }
    public boolean isMonotonic(int[] A) {
        return isIncrease(A) || isDecrease(A);
    }

}
