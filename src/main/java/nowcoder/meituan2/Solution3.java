package nowcoder.meituan2;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fir = new int[n];
        int[] second = new int[n];
        HashMap<Integer, Set<Integer>> front = new HashMap<>();
        HashMap<Integer, Integer> totalCount = new HashMap<>();
        HashMap<Integer, Set<Integer>> total = new HashMap<>();
        for (int i = 0; i < n; i++) {
            fir[i] = sc.nextInt();
            totalCount.put(fir[i], totalCount.getOrDefault(fir[i], 0) + 1);

            Set<Integer> set = front.getOrDefault(fir[i], new HashSet<>());
            set.add(i);
            front.put(fir[i], set);
            set = total.getOrDefault(fir[i], new HashSet<>());
            set.add(i);
            total.put(fir[i], set);
        }
        for (int i = 0; i < n; i++) {
            second[i] = sc.nextInt();
            totalCount.put(second[i], totalCount.getOrDefault(second[i], 0) + (second[i] == fir[i] ? 0 : 1));
            Set<Integer> set = total.getOrDefault(second[i], new HashSet<>());
            set.add(i);
            total.put(second[i], set);
        }


        List<int[]> sortLs = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry: front.entrySet()) {
            sortLs.add(new int[] {entry.getValue().size(), entry.getKey()});
        }
        Collections.sort(sortLs, (o1, o2) -> o2[0] - o1[0]);
        if (sortLs.get(0)[0] >= (n + 1) / 2) {
            System.out.println(0);
        } else {
            boolean flag = false;
            for (int[] tmp: sortLs) {
                if (totalCount.get(tmp[1]) >= (n + 1) / 2) {
                    System.out.println((n + 1) / 2 - tmp[0]);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (Map.Entry<Integer, Integer> en: totalCount.entrySet()) {
                    if (en.getValue() >= (n + 1) / 2) {
                        System.out.println((n + 1) / 2);
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                System.out.println(-1);
            }
        }


    }
}
