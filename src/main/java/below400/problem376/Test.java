package below400.problem376;

public class Test {
	
	//已优化
	public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int maxLen = 1;
        int before = nums[0];
        boolean flag = false;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == before)
                continue;
            if(maxLen == 1){
                flag = nums[i] - before > 0 ? true : false;
//                before = nums[i];
                maxLen++;
            } else if(flag == true && nums[i] - before < 0){
                maxLen++;
//                before = nums[i];
                flag = false;
            } else if(flag == false && nums[i] - before > 0){
                maxLen++;
//                before = nums[i];
                flag = true;
            } 
//            else {
//                if(flag == true){
//                    before = Math.max(before, nums[i]);
//                }else{
//                    before = Math.min(before, nums[i]);
//                }
//            }
            before = nums[i];
        }
        return maxLen;
    }
	
	//进一步优化:从i=2开始，避开了对maxLen=1的讨论;用变量记录nums[i] - before可以避免运算两次
	public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }
	
	//动态规划
	public int wiggleMaxLength3(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(up + 1, down);
            }
        }
        return Math.max(up, down);
    }
}


