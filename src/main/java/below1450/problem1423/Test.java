package below1450.problem1423;

import java.util.Arrays;

public class Test {
    public int maxScore(int[] cardPoints, int k) {
        int minSum = 0;
        int tmp = 0;
        int n = cardPoints.length - k;
        for(int i = 0; i < n; i++) {
            tmp += cardPoints[i];
        }
        minSum = tmp;
        for(int i = n; i < cardPoints.length; i++) {
            tmp = tmp - cardPoints[i - n] + cardPoints[i];
            minSum = Math.min(minSum, tmp);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
