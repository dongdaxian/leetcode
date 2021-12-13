package below350.problem349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		
	}
	
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
        for(int temp: nums1)
            set.add(temp);
        Set<Integer> res = new HashSet<>();
        for(int temp: nums2){
            if(set.contains(temp))
                res.add(temp);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
