package below850.problem830;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int record = i;
            i++;
            while(i < s.length() && s.charAt(record) == s.charAt(i)) {
                i++;
            }
            if(i - record >= 3) {
                List<Integer> temp = new ArrayList<>();
                temp.add(record);
                temp.add(i - 1);
                res.add(temp);
            }
        }
        return res;
    }
}
