package below50.problem28;

public class Test {

    public static void main(String[] args) {
        String haystack = "", needle = "";
        System.out.println(strStr(haystack, needle));

    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;
        int i = 0, j = 0;
        int[] next = getNext(needle);
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else
                j = next[j];
        }
        if (j == needle.length()) return i - j;
        return -1;
    }

    public static int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = -1;
        for (int i = 1, j = 0; i < s.length(); i++) {
            j = next[i - 1];
            next[i] = 0;
            while (j != -1) {
                if (s.charAt(j) == s.charAt(i - 1)) {
                    next[i] = j + 1;
                    break;
                } else
                    j = next[j];
            }
        }
        return next;
    }

}
