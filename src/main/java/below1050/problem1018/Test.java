package below1050.problem1018;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum = (sum << 1) + A[i];
            sum = sum % 5;
            if(sum == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
