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

    //得到模式串时间复杂度是O(m)，整个算法时间复杂度是O(n + m)
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
                } else {
                    j = next[j];
                }
            }
        }
        return next;
    }

    //与第一种方法本质相同
    //55行增加j，每次加1，最多增加m次；而53行减小j，每次最少减1，且j最小为-1，可得减少次数小于等于m，可得算法时间复杂度是O(m)
    public static int[] getNext2(String s) {
        int[] next = new int[s.length()];
        next[0] = -1;
        for (int i = 1, j = next[0]; i < s.length(); i++) {
            while (j != -1 && s.charAt(j) != s.charAt(i - 1)) {
                j = next[j];
            }
            j = j + 1;
            next[i] = j;
        }
        return next;
    }

}
