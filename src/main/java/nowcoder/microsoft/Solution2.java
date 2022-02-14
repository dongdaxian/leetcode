package nowcoder.microsoft;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(new Solution2().solution("12:15", "15:30"));
    }

    public int solution(String A, String B) {
        // write your code in Java SE 8
        int timeA = format2minute(A);
        int timeB = format2minute(B);
        int res = 0;
        if (timeB < timeA) {
            res += timeB / 15;
            res += (24 * 60 - timeA) / 15;
        } else {
            timeA = (timeA + 14) / 15 * 15;
            timeB = timeB / 15 * 15;
            if (timeB > timeA) {
                res += (timeB - timeA) / 15;
            }
        }
        return res;
    }

    public int format2minute(String time) {
        String[] res = time.split(":");
        return Integer.parseInt(res[0]) * 60 + Integer.parseInt(res[1]);
    }
}
