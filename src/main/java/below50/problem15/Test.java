package below50.problem15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		int[] nums = {0, -1, -1, 0, 2};
        List<List<Integer>> ls = new Test().threeSum2(nums);        
        for(List<Integer> l:ls){
        	for(Integer x:l){
        		System.out.print(x);
        		System.out.print(" ");
        	}
        	System.out.println();
        }
	}
	
	public List<List<Integer>> threeSum1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ls = new LinkedList<List<Integer>>();
		int target;
	    int beg, end;
	    for(int i = 0; i < nums.length; i++)
	    {
//	        while(i > 0 && i < nums.length && nums[i] == nums[i - 1]) i++;  
	    	if(i > 0 && nums[i] == nums[i - 1]) continue;					//��Ϊ�˸�������O(n)������һ���в�Ƕ��for/while������
	        beg = i + 1;
	        end = nums.length - 1;
	        while(beg < end)
	        {
	        	target = 0 - nums[i];
	            if(nums[beg] + nums[end] < target){
	                beg++;
	            } 
	            else if(nums[beg] + nums[end] > target)
	            {
	                end--;
	            } 
	            else
	            {
//	                ls.add(Arrays.asList(nums[i], nums[beg], nums[end]));
//	                beg++;
//	                end--;
//	                while(nums[beg] == nums[beg-1] && beg < end) beg++;        
//	                while(nums[end] == nums[end+1] && beg < end) end--;
	                
	                if(beg > i + 1 && nums[beg] == nums[beg-1]) {              //ͬ��
	                	beg++;
	                	continue;
	                }
	                if(end < nums.length - 1 && nums[end] == nums[end+1]) {
	                	end--;
	                	continue;
	                }
	                ls.add(Arrays.asList(nums[i], nums[beg], nums[end]));
	                beg++;
	                end--;
	            }
	        }

	    }
		return ls;
	}
	
	
	public List<List<Integer>> threeSum2(int[] nums) {	  //ʹ��HashSet���������൱������n��2Sum����
		Arrays.sort(nums);
		List<List<Integer>> ls = new LinkedList<List<Integer>>();
		HashSet<Integer> set = new HashSet<Integer>();
		int target = 0;
		for(int i = 0; i < nums.length; i++){
			if(i > 0  && nums[i] == nums[i - 1]) continue;
			target = 0 - nums[i];
			for(int j = i + 1; j < nums.length; j++)
			{
				if(set.contains(nums[j])) 
				{
					ls.add(Arrays.asList(nums[i], target - nums[j], nums[j]));
					while(j < nums.length - 1 && nums[j] == nums[j + 1]) j++;      // i Ҳ�����������ŵ�����������
				} 
				else 
					set.add(target - nums[j]);
					
			}
			set.clear();
		}
		return ls;
	}
	
	
}
