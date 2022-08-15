package nowcoder.meituan2;

import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sample = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sample[i] = sc.nextInt();
            List<Integer> ls = map.getOrDefault(sample[i], new ArrayList<>());
            ls.add(i + 1);
            map.put(sample[i], ls);
        }
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> ls = entry.getValue();
            int size = ls.size();
            for (int i = 0; i < (size + 1) / 2; i++) {
                res1.add(ls.get(i));
            }
            for (int i = (size + 1) / 2; i < size; i++) {
                res2.add(ls.get(i));
            }
        }
        Collections.sort(res1);
        Collections.sort(res2);
        for (int i = 0; i < res1.size(); i++) {
            System.out.print(res1.get(i));
            if (i != res1.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i < res2.size(); i++) {
            System.out.print(res2.get(i));
            if (i != res2.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
