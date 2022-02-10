package below150.problem122;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int profit = 0;
        for (int temp : prices) {
            if (temp < low) {
                low = temp;
            } else if (temp > low) {
                profit += temp - low;
                low = temp;
            }
        }
        return profit;
    }

}
