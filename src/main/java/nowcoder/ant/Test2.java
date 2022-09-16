package nowcoder.ant;


import java.util.*;


public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int fir = sc.nextInt(), sec = sc.nextInt();
            int parent = Math.min(fir, sec);
            int child = Math.max(fir, sec);
            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
        }
        System.out.print(travleTree(tree, n));
    }

    public static long travleTree(Map<Integer, List<Integer>> tree, int n) {
        long res = 0L;
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 1});
        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            int times = parent[0] - parent[1];
            res += times;
            if (!tree.containsKey(parent[0])) {
                continue;
            }
            for (int child: tree.get(parent[0])) {
                queue.offer(new int[] {child, times + parent[1]});
            }
        }

        return res;
    }


}
