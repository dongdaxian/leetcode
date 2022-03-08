package below150.problem125;

public class Test {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//		System.out.println(s.replace(" ", ""));
        System.out.println(new Test().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        String re = "";
        for (int i = 0; i < s.length(); i++)
            if ((s.charAt(i) <= '9' && s.charAt(i) >= '0')
                    || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                    || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
                re = re.concat(String.valueOf(s.charAt(i)));

        int len = re.length();
        char a = 0, b = 0;
        for (int i = 0; i < len / 2; i++) {
            a = re.charAt(i);
            b = re.charAt(len - 1 - i);
            if (a > '9' && b > '9') {
                if (Math.abs(a - b) != 'a' - 'A' && a != b)
                    return false;
            } else if (a != b) {
				return false;
			}
        }
        return true;
    }

}
