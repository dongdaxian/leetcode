package below50.problem27;

public class Test {

	public static void main(String[] args) {
		int[] nums = new int[]{0,1,2,2,3,0,4,2};
		int len = new Test().removeElement(nums, 2);
		for(int i = 0; i < len; i++)
			System.out.println(nums[i]);

	}
	
	public int removeElement(int[] nums, int val) {
		int lptr = 0, fptr = 0;
		int len = 0;
		while(lptr < nums.length && fptr < nums.length) {
			if(nums[lptr] != val) {
				lptr++;
				len++;
			} else if(fptr <= lptr || nums[fptr] == val) {
				fptr++;
			} else {
				int temp = nums[fptr];
				nums[fptr] = nums[lptr];
				nums[lptr] = temp;
			}
		}
		return len;
    }

}
