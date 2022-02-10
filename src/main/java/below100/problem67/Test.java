package below100.problem67;

public class Test {

    public static void main(String[] args) {
        String a = "11";
        String b = "11";
        System.out.println(new Test().addBinary(a, b));

    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int sum = 0;
        boolean flag = true;
        while (i > -1 || j > -1 || flag) {
            flag = false;
            if (i > -1) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j > -1) {
                sum += b.charAt(j) - '0';
                j--;
            }
            if (sum == 3) {
                sum = 1;
                sb.insert(0, '1');
                flag = true;
            } else if (sum == 2) {
                sum = 1;
                sb.insert(0, '0');
                flag = true;
            } else if (sum == 1) {
                sum = 0;
                sb.insert(0, '1');
            } else {
                sb.insert(0, '0');
            }
        }
        return sb.toString();
    }

}
