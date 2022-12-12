package nowcoder.renshou;

import java.util.*;

public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        String line = sc.nextLine();
        String[] input = line.split(",");
        for (String tmp: input) {
            len++;
            int key = Integer.parseInt(tmp);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(map.values());
        values.sort((o1, o2) -> o2 - o1);
        int sum = 0;
        int res = 0;
        len = (len + 1) / 2;
        for (int value: values) {
            sum += value;
            res++;
            if (sum >= len) {
                System.out.print(res);
                return;
            }
        }
    }


}
