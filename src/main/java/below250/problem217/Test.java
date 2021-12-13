package below250.problem217;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int temp: nums){
            if(set.contains(temp))
                return true;
            set.add(temp);
        }
        return false;
    }
}
