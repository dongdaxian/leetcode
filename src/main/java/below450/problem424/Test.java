package below450.problem424;

import java.util.Arrays;

public class Test {

    public int characterReplacement(String s, int k) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int res = 0;
        int[] count = new int[26];
        int sptr = 0, fptr = 0;
        int max = 0;
        while (fptr < n) {
            while (fptr < n) {
                max = Math.max(max, ++count[ch[fptr] - 'A']);
                fptr++;
                if (fptr - sptr - max > k) {
                    res = Math.max(res, fptr - sptr - 1);
                    break;
                }
            }
            while (fptr - sptr - max > k) {
                count[ch[sptr] - 'A']--;
                max = Arrays.stream(count).max().getAsInt();
                sptr++;
            }
        }
        res = Math.max(res, fptr - sptr);
        return res;
    }

    public int characterReplacement2(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
