package nowcoder.jianzhi;

public class Solution14 {

    public int cutRope(int target) {
        int ret = 1;
        while (target > 0) {
            if (target - 3 > 1 || target - 3 == 0) {
                ret = ret * 3;
                target -= 3;
            } else {
                ret = ret * 2;
                target -= 2;
            }
        }

        return ret;
    }
}
