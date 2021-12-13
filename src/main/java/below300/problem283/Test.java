package below300.problem283;

public class Test {
	public void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            int j = i;
            for(; j - 1 > -1 && nums[j - 1] == 0; j--);
            nums[i] = 0;
            nums[j] = temp;
        }
    }
	
	public void moveZeroes2(int[] nums) {
		int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
