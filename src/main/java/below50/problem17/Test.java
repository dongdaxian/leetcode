package below50.problem17;

import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String digits = "23";
        List<String> ls = new Test().letterCombinations(digits);
        for (int i = 0; i < ls.size(); i++)
            System.out.println(ls.get(i));

    }

    public List<String> letterCombinations(String digits) {
        List<char[]> ls = new LinkedList<char[]>();
        ls.add(new char[]{' '});                                       //向list中添加数组元素方法
        ls.add(new char[]{});
        ls.add(new char[]{'a', 'b', 'c'});
        ls.add(new char[]{'d', 'e', 'f'});
        ls.add(new char[]{'g', 'h', 'i'});
        ls.add(new char[]{'j', 'k', 'l'});
        ls.add(new char[]{'m', 'n', 'o'});
        ls.add(new char[]{'p', 'q', 'r', 's'});
        ls.add(new char[]{'t', 'u', 'v'});
        ls.add(new char[]{'w', 'x', 'y', 'z'});


        LinkedList<String> res = new LinkedList<>();
        int index = 0;
        String temp = "";
        int size = 0;
        char[] ch;
        while (!digits.isEmpty()) {
            index = digits.charAt(0) - '0';
            digits = digits.substring(1);
            if (index == 1) continue;
            ch = ls.get(index);
            size = res.size();
            if (size == 0)
                for (int j = 0; j < ch.length; j++)
                    res.add(String.valueOf(ch[j]));
            else
                for (int i = 0; i < size; i++) {
                    temp = res.poll();
                    for (int j = 0; j < ch.length; j++) {
                        res.add(temp + ch[j]);
                    }
                }
        }

        return res;
    }

}
