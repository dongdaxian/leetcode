package below750.problem714;

public class Test {
	
	public int maxProfit(int[] prices, int fee) {
		int profit = 0;
		int tempProfit = 0;
		int buy = prices[0];
		
		for(int i = 1; i < prices.length; i++) {
            int temp = prices[i];
			if((tempProfit > 0 && temp + fee < buy) || (tempProfit == 0 && temp < buy)) {
				profit += tempProfit > 0 ? tempProfit - fee : 0;
				buy = temp;
                tempProfit = 0;
			} else if((tempProfit > 0 && temp > buy) || (tempProfit == 0 && temp > buy + fee)) {
				tempProfit += temp - buy;
				buy = temp;
			}
		}
        profit += tempProfit > 0 ? tempProfit - fee : 0;
		return profit;
	}
	//另一种实现
	//不更新buy，则buy记录的永远是真正的买入价格，但就无法记录可能的最高出售价格，所以还需要lastHigh。此时要判断是否已经发生过交易，既可以用tempProfit也可以用lastHigh
	public int maxProfit2(int[] prices, int fee) {
        int profit = 0;
        int tempProfit = 0;
        int lastHigh = 0;
        int buyPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            int temp = prices[i];
            if(temp < buyPrice || lastHigh - fee > temp){
                profit += tempProfit;
                tempProfit = 0;
                buyPrice = temp;
                lastHigh = 0;
            }else{
                if(temp - buyPrice - fee > tempProfit){
                    tempProfit = temp - buyPrice - fee;
                    lastHigh = temp;
                }
            }
        }
        profit += tempProfit;
        return profit;
    }
	
	//简化版。因为一次买卖fee只交一次，所以可以把fee算进买入价格
	public int maxProfit3(int[] prices, int fee) {
		int profit = 0;
		int buy = prices[0] + fee;
		for(int i = 1; i < prices.length; i++) {
            int temp = prices[i];
			if(temp + fee < buy) {
				buy = temp + fee;
			} else if(temp > buy) {
				profit += temp - buy;
				buy = temp;
			}
		}
		return profit;
	}
	//上面三种都是贪心，第四种动态规划
	public int maxProfit4(int[] prices, int fee) {
		//[i][0]表示第i+1天结束不持有股票最大利润，[i][1]表示持有股票最大利润
		int n = prices.length;
		int[][] dp = new int[n][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		//因为此状态转移方程中，当天总是由前一天推出，所以可以直接用两个变量代替
		for(int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
			dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
		}
		
		return dp[n - 1][0];
	}
	
	
	
}
