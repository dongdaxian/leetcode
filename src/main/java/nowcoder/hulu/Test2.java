package nowcoder.hulu;


import java.util.*;


public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String, List<String>> tree = new HashMap<>();
        Deque<String> stack = new LinkedList<>();
        char[] ch = input.toCharArray();
        int i = 1;
        StringBuilder sb = new StringBuilder();
        while (ch[i] != '>') {
            sb.append(ch[i]);
            i++;
        }
        String root = sb.toString();
        stack.push(sb.toString());
        tree.put(sb.toString(), new ArrayList<>());
        i++;

        while (i < ch.length) {
            if (ch[i] == '<') {
                i++;
                if (ch[i] != '/') {
                    StringBuilder tmp = new StringBuilder();
                    while (i < ch.length && ch[i] != '>' && ch[i] != '/') {
                        tmp.append(ch[i]);
                        i++;
                    }
                    if (ch[i] == '/') {
                        i++;
                        tree.put(tmp.toString(), new ArrayList<>());
                        tree.get(stack.peek()).add(tmp.toString());
                    } else {
                        tree.put(tmp.toString(), new ArrayList<>());
                        tree.get(stack.peek()).add(tmp.toString());
                        stack.push(tmp.toString());
                    }

                } else {
                    i++;
                    StringBuilder tmp = new StringBuilder();
                    while (i < ch.length && ch[i] != '>') {
                        tmp.append(ch[i]);
                        i++;
                    }
                    stack.pop();
                }
                i++;
            }
        }
        List<String> res = new ArrayList<>();
        Deque<String> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            String aa = queue.poll();
            res.add(aa);
            for (String child: tree.get(aa)) {
                queue.offer(child);
            }
        }
        for (int j = 0; j < res.size(); j++) {
            if (j != res.size() - 1) {
                System.out.print(res.get(j) + " ");
            } else {
                System.out.print(res.get(j));
            }

        }
    }



}
