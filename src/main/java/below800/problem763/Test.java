package below800.problem763;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(new Test().partitionLabels2("ababcbacadefegdehijhklij"));
	}
	
	
	public List<Integer> partitionLabels(String S) {
		Map<Character, int[]> map = new HashMap<>();
		for(int i = 0; i < S.length(); i++) {
			Character temp = S.charAt(i);
			if(map.containsKey(temp)) {
				map.get(temp)[1] = i;
			}else {
				map.put(temp, new int[] {i, i});
			}
		}
		List<int[]> ls = new ArrayList<>(map.values());
		Collections.sort(ls, (int[] ary1, int[] ary2) -> {return ary1[0] - ary2[0];});
		int size = ls.size();
		int[] pre = null;
		for(int i = 0; i < size; i++) {
			int[] temp = ls.get(i);
			if(pre != null && temp[0] <= pre[1]){
				ls.remove(i);
				--i;
				--size;
				pre[1] = Integer.max(pre[1], temp[1]);
			}else {
				pre = temp;
			}
			
		}
		
		List<Integer> res = new ArrayList<>();
		for(int[] temp: ls) {
			res.add(temp[1] - temp[0] + 1);
		}
		return res;
    }
	
	public List<Integer> partitionLabels2(String S) {
		int[] record = new int[26];
		for(int i = 0; i < S.length(); i++) {
			record[S.charAt(i) - 'a'] = i;
		}
		int start = -1;
		int end = 0;
		List<Integer> res = new ArrayList<>(); 
		for(int i = 0; i < S.length(); i++) {
			end = Math.max(end, record[S.charAt(i) - 'a']);
			if(end == i) {
				res.add(end - start);
				start = end;
			}
		}
		
		return res;
	}
}
