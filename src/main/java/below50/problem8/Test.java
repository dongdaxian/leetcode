package below50.problem8;


import java.util.Objects;
import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        String str = "   -42";
        System.out.println(new Test().myAtoi(str));
//		char s = "asd".charAt(0);
//		System.out.println("asd".charAt(1) - 'a');
    }

    public int myAtoi(String s) {
        long result = 0L;
        boolean flag = true;
        int i = 0;

        if (s.isEmpty()) return 0;
        s = s.trim();
        if (s.isEmpty()) return 0;
        if (s.charAt(0) == '-') {
            flag = false;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }

        for (i = 0; i < s.length() && s.charAt(i) == '0'; i++) ;
        s = s.substring(i);


        for (i = 0; i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0'; i++) {
            if (i > 10) break;
            result = result * 10 + s.charAt(i) - '0';
        }

        if (!flag) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

}
