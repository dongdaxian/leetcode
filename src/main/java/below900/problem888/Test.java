package below900.problem888;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        Set<Integer> set = Arrays.stream(B).boxed().collect(Collectors.toSet());
        int tar = (sumA - sumB) / 2;
        int[] ret = new int[2];
        for(int temp: A) {
            if(set.contains(temp - tar)) {
                ret[0] = temp;
                ret[1] = temp - tar;
                break;
            }
        }
        return ret;
    }
}
