package below1150.problem1122;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new HashMap<>();
        for(int temp: arr2)
            map.put(temp, 0);
        List<Integer> ls = new ArrayList<>();
        for(int temp: arr1){
            if(map.containsKey(temp))
                map.put(temp, map.get(temp) + 1);
            else{
                ls.add(temp);
            }
        }
        Collections.sort(ls);
        int i = 0;
        for(int temp: arr2){
            int times = map.get(temp);
            for(int j = 0; j < times; j++)
                arr1[i++] = temp;
        }
        for(int j = 0; j < ls.size(); j++){
            arr1[i++] = ls.get(j);
        }
        return arr1;
    }
}
