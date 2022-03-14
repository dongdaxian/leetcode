package below150.problem128;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        new Test().longestConsecutive3(new int[]{100, 4, 200, 1, 3, 2});
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        List<int[]> ls = new LinkedList<>();
        for (int num : nums) {
            int[] tmp = new int[]{num, num};
            if (!ls.isEmpty() && ls.get(ls.size() - 1)[1] + 1 >= tmp[0]) {
                int[] last = ls.get(ls.size() - 1);
                last[0] = Math.min(tmp[0], last[0]);
                last[1] = Math.max(tmp[1], last[1]);
            } else {
                ls.add(tmp);
            }
        }
        int longest = 0;
        for (int[] ary : ls) {
            longest = Math.max(longest, ary[1] - ary[0] + 1);
        }
        return longest;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int currentNum = num;
            int length = 1;
            while (set.contains(currentNum + 1)) {
                length++;
                currentNum++;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }

    public int longestConsecutive3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        UnionFind uf = new UnionFind(nums);
        for (int num : nums) {
            if (set.contains(num + 1)) {
                uf.union(num, num + 1);
            }
        }
        int longest = 0;
        for (int num : nums) {
            longest = Math.max(longest, uf.find(num) - num + 1);
        }
        return longest;
    }

}
class UnionFind {
    private Map<Integer, Integer> map = new HashMap<>();
    public UnionFind(int[] nums) {
        for (int num : nums) {
            map.put(num, num);
        }
    }
    public int find(int i) {
        if (map.get(i) != i) {
            map.put(i, find(map.get(i)));
        }
        return map.get(i);
    }
    public void union(int i, int j) {
        map.put(find(i), find(j));
    }
}