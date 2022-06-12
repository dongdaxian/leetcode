package below450.problem415;

public class Test {
    public static void main(String[] args) {
        System.out.print(new Test().addStrings("456", "8894"));
    }

    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int extra = 0;
        int res = 0;
        for (int len1 = num1.length() - 1, len2 = num2.length() - 1; len1 > -1 || len2 > -1 || extra != 0; len1--, len2--) {
            res = 0;
            res += extra;
            if (len1 > -1) {
                res += num1.charAt(len1) - '0';
            }
            if (len2 > -1) {
                res += num2.charAt(len2) - '0';
            }
            if (res > 9) {
                res -= 10;
                extra = 1;
            } else {
                extra = 0;
            }
            //也可以用append()，最后调用reverse()
            sb.insert(0, (char) (res + '0'));


        }
        return sb.toString();
    }
}
