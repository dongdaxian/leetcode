package nowcoder.ali2022;

import java.util.*;
import java.util.stream.Collectors;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> bucket1 = new ArrayList<>();
        List<Integer> bucket2 = new ArrayList<>();
        int num = sc.nextInt();
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            double k = (double) A / B;
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        int sum1 = 0;
        int sum2 = 0;
        List<Integer> ls = map.entrySet().stream().map(a -> a.getValue()).collect(Collectors.toList());
        ls.sort((a, b) -> b - a);
        for (int i = 0; i < ls.size(); i++) {
            if (sum1 <= sum2) {
                sum1 += ls.get(i);
                bucket1.add(ls.get(i));
            } else {
                sum2 += ls.get(i);
                bucket2.add(ls.get(i));
            }
        }
        System.out.println(sum1 * sum2);

        StringBuilder sb = new StringBuilder();
    }

}
