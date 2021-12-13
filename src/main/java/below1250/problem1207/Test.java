package below1250.problem1207;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		

	}

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
        for(int temp: arr){
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        List<Integer> ls = new ArrayList<>(map.values());
        Collections.sort(ls);
        for(int i = 0; i + 1 < ls.size(); i++){
            if(ls.get(i) == ls.get(i + 1))
                return false;
        }
        return true;
    }
}
