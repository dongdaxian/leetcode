package nowcoder.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class Solution21 {

    public int[] reOrderArray (int[] array) {
        List<Integer> oddLs = new ArrayList<>();
        List<Integer> eventLs = new ArrayList<>();
        for (int k: array) {
            if ((k & 1) == 1) {
                oddLs.add(k);
            } else {
                eventLs.add(k);
            }
        }
        oddLs.addAll(eventLs);
        return oddLs.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] reOrderArray2 (int[] array) {
        int evenIndex = 0;
        for(; evenIndex < array.length && (array[evenIndex] & 1) == 1; evenIndex++);
        int oddIndex = 0;
        while (oddIndex < array.length) {
            if ((array[oddIndex] & 1) == 1 && evenIndex < oddIndex) {
                int tmp = array[oddIndex];
                for (int i = oddIndex; i > evenIndex; i--) {
                    array[i] = array[i - 1];
                }
                array[evenIndex] = tmp;
                evenIndex++;
            }
            oddIndex++;
        }
        return array;
    }
}
