package below1000.problem992;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        int left = 0, right = 0, maxLeft = 0;
        int ret = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        while(right < n) {
            map1.put(A[right], map1.getOrDefault(A[right], 0) + 1);
            map2.put(A[right], map2.getOrDefault(A[right], 0) + 1);
            right++;
            while(map1.size() > K) {
                int tmp = A[left];
                map1.put(tmp, map1.get(tmp) - 1);
                if(map1.get(tmp) == 0)
                    map1.remove(tmp);
                left++;
            }
            while(map2.size() > K) {
                int tmp = A[maxLeft];
                map2.put(tmp, map2.get(tmp) - 1);
                if(map2.get(tmp) == 0)
                    map2.remove(tmp);
                maxLeft++;
            }
            while(map2.size() == K) {
                int tmp = A[maxLeft];
                if(map2.get(tmp) > 1) {
                    map2.put(tmp, map2.get(tmp) - 1);
                } else {
                    break;
                }
                maxLeft++;
            }
            if(map1.size() == K)
                ret += maxLeft - left + 1;
        }
        return ret;
    }
}
