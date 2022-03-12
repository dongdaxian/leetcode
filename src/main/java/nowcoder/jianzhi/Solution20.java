package nowcoder.jianzhi;

public class Solution20 {

    public static void main(String[] args) {

        System.out.println(new Solution20().isNumeric("123.45e+6"));
    }


    public boolean isNumeric (String str) {
        String regax = " *[+-]?([0-9]+|([0-9]+\\.[0-9]*|\\.[0-9]+)) *([eE] *[+-]?[0-9]+ *)? *";
        if (str.matches(regax)) {
            return true;
        }
        return false;
    }
}
