package below100.problem53;

public class Test {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int tmp : nums) {
            if (sum < 0) {
                sum = tmp;
            } else {
                sum += tmp;
            }
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
