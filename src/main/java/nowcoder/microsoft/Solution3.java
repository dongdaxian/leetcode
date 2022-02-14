package nowcoder.microsoft;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public static void main(String[] args) {

    }

    public int solution(int[] A, int R) {
        // write your code in Java SE 8
        if (R > A.length) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int k: A) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        for (int i = 0; i < R; i++) {
            map.put(A[i], map.get(A[i]) - 1);
            if (map.get(A[i]) == 0) {
                map.remove(A[i]);
            }
        }
        int res = map.size();
        for (int i = 0; i + R < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(A[i + R], map.get(A[i + R]) - 1);
            if (map.get(A[i + R]) == 0) {
                map.remove(A[i + R]);
            }
            res = Math.max(res, map.size());
        }
        return res;
    }
}
