package below1250.problem1208;

public class Test {

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for(int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0, right = 0;
        int sum = 0;
        for(; right < n; right++) {
            sum += diff[right];
            if(sum > maxCost) {
                sum -= diff[left];
                left++;
            }
        }
        return right - left;
    }
}
