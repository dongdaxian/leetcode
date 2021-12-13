package below1150.problem1128;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(int[] tempAry: dominoes) {
            List<Integer> temp = Arrays.stream(tempAry).boxed().collect(Collectors.toList());
            if(!map.containsKey(temp)) {
                Collections.reverse(temp);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }
        int ret = 0;
        for(int temp: map.values()) {
            ret += getMulti(temp);
        }
        return ret;
    }
    public int getMulti(int k) {
        int ret = 0;
        for(int i = 1; i < k; i++) {
            ret += i;
        }
        return ret;
    }

}
