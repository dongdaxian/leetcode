package nowcoder.pinduoudo;

import java.util.*;


public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] ck = new int[n][2];

        int[][] xi = new int[m][2];
        for (int i = 0; i < n; i++) {
            ck[i][0] = sc.nextInt();
            ck[i][1] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            xi[i][0] = sc.nextInt();
            xi[i][1] = sc.nextInt();
        }
        System.out.println(getWarRes(ck, xi, n, m));

    }

    private static int getWarRes(int[][] ck, int[][] xi, int n, int m) {
        if (n < m) {
            return -1;
        }
        Arrays.sort(ck, (o1, o2) -> {if (o1[0] != o2[0]) return o1[0] - o2[0]; else return o1[1] - o2[1];});
        Arrays.sort(xi, (o1, o2) -> {if (o1[1] != o2[1]) return o1[1] - o2[1]; else return o1[0] - o2[0];});
        Map<Integer, List<Integer>> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < m; i++) {
            int[] army = xi[i];
            List<Integer> ls = new ArrayList<>();
            while (index < n && ck[index][0] < army[1]) {
                if (i > 0) {
                    map.get(i - 1).add(index);
                }
                index++;
            }
            if (index == n) {
                return -1;
            }
            ls.add(index);
            index++;
            map.put(i, ls);
        }
        while (index < n) {
            map.get(m - 1).add(index);
            index++;
        }
        int count = 0;
        for (int i = m - 1; i > -1; i--) {
            List<Integer> ls = map.get(i);
            int removeIndex = -1;
            for (int j = 0; j < ls.size(); j++) {
                if (ck[ls.get(j)][1] > xi[i][0]) {
                    if (removeIndex != -1) {
                        removeIndex = ck[ls.get(j)][1] < ck[ls.get(removeIndex)][1] ? j : removeIndex;
                    } else {
                        removeIndex = j;
                    }
                }
            }
            if (removeIndex != -1) {
                ls.remove(removeIndex);
                count++;
            }
            if (i > 0) {
                map.get(i - 1).addAll(ls);
            }
        }

        return count;
    }

}
