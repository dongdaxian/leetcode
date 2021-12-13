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
	//��һ��ʵ��
	//������buy����buy��¼����Զ������������۸񣬵����޷���¼���ܵ���߳��ۼ۸����Ի���ҪlastHigh����ʱҪ�ж��Ƿ��Ѿ����������ף��ȿ�����tempProfitҲ������lastHigh
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
	
	//�򻯰档��Ϊһ������feeֻ��һ�Σ����Կ��԰�fee�������۸�
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
	//�������ֶ���̰�ģ������ֶ�̬�滮
	public int maxProfit4(int[] prices, int fee) {
		//[i][0]��ʾ��i+1����������й�Ʊ�������[i][1]��ʾ���й�Ʊ�������
		int n = prices.length;
		int[][] dp = new int[n][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		//��Ϊ��״̬ת�Ʒ����У�����������ǰһ���Ƴ������Կ���ֱ����������������
		for(int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
			dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
		}
		
		return dp[n - 1][0];
	}
	
	
	
}
