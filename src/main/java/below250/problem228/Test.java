package below250.problem228;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		

	}
	
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < nums.length;) {
            s.append(nums[i]);
            int j = i + 1;
            for(; j < nums.length && nums[j] == nums[j - 1] + 1; j++);
            if(j != i + 1) {
                s.append("->" + nums[j - 1]);
            }
            res.add(s.toString());
            s = new StringBuilder();
            i = j;
        }
        
        return res;
    }
	
}
