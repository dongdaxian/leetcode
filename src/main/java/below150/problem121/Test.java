package below150.problem121;

public class Test {
	public static void main(String[] args) {
		System.out.println(new Test().maxProfit(new int[]{2, 1, 2, 0, 1}));
	}
	
	public int maxProfit(int[] prices) {
		int low = Integer.MAX_VALUE;
		int profit = 0;
		for(int i = 0; i < prices.length; i++) {
			low = Math.min(low, prices[i]);
			if(prices[i] > low) {
				profit = Math.max(profit, prices[i] - low);
			}
		}
		return profit;
    }
}
