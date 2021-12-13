package below1000.problem989;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        new Test().addToArrayForm(new int[]{1,2,0,0}, 34).forEach(System.out::println);
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int i = A.length - 1;
        int pre = 0;
        List<Integer> res = new LinkedList<>();
        while(K != 0 || i > -1) {
            int temp = pre;
            if(K > 0) {
                temp += K % 10;
                K = K / 10;
            }
            if(i > -1) {
                temp += A[i];
                i--;
            }
            if(temp > 9) {
                pre = 1;
                temp -= 10;
            } else {
                pre = 0;
            }
            res.add(0, temp);
        }
        if(pre == 1)
            res.add(0, 1);
        return res;
    }

    public List<Integer> addToArrayForm2(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
            if (i >= 0) {
                K += A[i];
            }
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }


}

