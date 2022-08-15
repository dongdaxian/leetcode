package nowcoder.zoom;

import java.util.*;


public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] ifBlue = new boolean[n];
        sc.nextLine();
        String color = sc.nextLine();
        for (int i = 0; i < n; i++) {
            ifBlue[i] = color.charAt(i) == 'B';
        }
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            ls.get(a).add(b);
            ls.get(b).add(a);
        }
        System.out.print(computeTreeValue(ls, ifBlue, n));
    }

    private static long computeTreeValue(List<List<Integer>> ls, boolean[] ifBlue, int n) {
        long res = 0;
        boolean[] visited = new boolean[n];
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, ifBlue[0] ? 1 : 0, ifBlue[0] ? 0 : 1});
        res += 1;
        visited[0] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            List<Integer> node = ls.get(tmp[0]);
            for (int k: node) {
                if (visited[k]) {
                    continue;
                }
                visited[k] = true;
                int[] toadd = new int[] {k, tmp[1] + (ifBlue[k] ? 1 : 0), tmp[2] + (ifBlue[k] ? 0 : 1)};
                res += Math.abs(toadd[1] - toadd[2]);
                queue.offer(toadd);
            }
        }
        return res;
    }

}
