package below50.problem13;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().romanToInt("III"));

    }

    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();                //12题不用HashMap的主要原因是阿拉伯数字和罗马数字构成方式不同
        map.put("M", 1000);                                            //前者可以加在一起，后者拼接在一起
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        String temp = "";
        int rs = 0;
        int i = 0;
        for (i = 0; i < s.length() - 1; i++) {
            temp = s.substring(i, i + 2);
            if (map.containsKey(temp)) {
                rs += map.get(temp);
                i++;
            } else {
                temp = s.substring(i, i + 1);
                rs += map.get(temp);
            }
        }
        if (i < s.length())
            rs += map.get(String.valueOf(s.charAt(s.length() - 1)));
        return rs;
    }

}
