package below1200.problem1178;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
//        System.out.print(Integer.toBinaryString(21));
        int k = 21;
        int sub = k;
        do {
            System.out.println(sub | 16);
            sub = (sub - 1) & k;
        } while (sub != k);

    }

//    时间复杂度是O(mnw)，w是words中单词最大长度
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int puzzLen = puzzles.length;
        boolean[][] record = new boolean[puzzLen][26];
        int[] res = new int[puzzLen];
        for (int i = 0; i < puzzLen; i++) {
            for (int j = 0; j < puzzles[i].length(); j++) {
                record[i][puzzles[i].charAt(j) - 'a'] = true;
            }
        }
        for (String tmp: words) {
            for (int i = 0; i < puzzLen; i++) {
                char fir = puzzles[i].charAt(0);
                boolean flag = false;
                for (char ch: tmp.toCharArray()) {
                    if (!record[i][ch - 'a']) {
                        flag = false;
                        break;
                    }
                    if (ch == fir) {
                        flag = true;
                    }
                }
                if (flag) {
                    res[i]++;
                }
            }
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

//    因为题目中限定了谜底单词长度为7，否则这种方法时间复杂度比第一种高
    public List<Integer> findNumOfValidWords2(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String tmp: words) {
            int mask = 0;
            for (char ch: tmp.toCharArray()) {
                mask |= (1 << (ch - 'a'));
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (String tmp: puzzles) {
            int count = 0;
            int mask = 0;
            for (int i = 1; i < 7; i++) {
                mask |= (1 << (tmp.charAt(i) - 'a'));
            }
            int subset = mask;
//            用subset!=mask而不是subset!=0，因为想把0也算作子集
            do {
                int s = subset | (1 << (tmp.charAt(0) - 'a'));
                count += map.getOrDefault(s, 0);
                subset = (subset - 1) & mask;
            } while (subset != mask);
            res.add(count);
        }
        return res;
    }
}
