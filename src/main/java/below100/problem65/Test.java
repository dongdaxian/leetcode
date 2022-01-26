package below100.problem65;

import java.util.HashSet;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().isNumber2(" .  "));
    }

    public boolean isNumber1(String s) {
        if (s == null) return false;
        s = s.trim();                    //去除首尾空格
        if (s.isEmpty() || "dDfF".contains(s.substring(s.length() - 1)))    //这道题的合法输入，包括'.1','1.'这种,其实都对应Double.parseDouble()的合法输入，
            return false;                                                   //除了数字末尾加上dDfF任一个
        try {
            Double.parseDouble(s);                            //第八题的数字超出最大值并不返回0，而是返回该最大值，所以不能用Integer.parseInteger()
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNumber2(String s) {                    //自动机在leetcode笔记中
        s = s.trim();
        if (s.isEmpty()) return false;
        int i = 0, state = 0;
        for (i = 0, state = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '+':
                case '-':
                    if (state == 0)
                        state = 1;
                    else if (state == 4)
                        state = 6;
                    else
                        return false;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (state == 0 || state == 1 || state == 2)
                        state = 2;
                    else if (state == 7 || state == 8)
                        state = 8;
                    else if (state == 4 || state == 5 || state == 6)
                        state = 5;
                    else if (state == 3)
                        state = 3;
                    else
                        return false;
                    break;
                case '.':
                    if (state == 0 || state == 1)
                        state = 7;
                    else if (state == 2)
                        state = 3;
                    else
                        return false;
                    break;
                case 'e':
                    if (state == 2 || state == 3 || state == 8)
                        state = 4;
                    else
                        return false;
                    break;
                default:
                    return false;

            }

        }
        return state == 2 || state == 3 || state == 5 || state == 8;
    }

    public boolean isNumber3(String s) {                //一般的思路是遍历，不符合时就return false，当遍历到末尾时说明字符串符合格式，其实这就是自动机的一种。
        s = s.trim();                                    //不过这种要求只能有一种结束状态，实现太麻烦。我们可以让结束状态多几种，比如方法2的结束状态有多个
        boolean pointSeen = false;                        //方法3又是方法2的简化
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }


    public boolean isNumber4(String s) {                                  //用正则表达式的方法
        s = s.trim();
        if (s.isEmpty()) return false;
        String regex = "[-+]?((\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?)";        //不能用 \\d*\\.?\\d* ，防止输入为 .
        if (s.matches(regex))
            return true;
        return false;
    }

}
