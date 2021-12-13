package below500.problem485;

public class Test {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int tmpLen = 0;
        for(int tmp: nums) {
            if(tmp == 1) {
                tmpLen++;
            } else {
                maxLen = Integer.max(maxLen, tmpLen);
                tmpLen = 0;
            }
        }
        maxLen = Integer.max(maxLen, tmpLen);
        return maxLen;
    }

}
