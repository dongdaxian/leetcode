package below1400.problem1370;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		int[] arr1 = new int[] {1, 2};
		int[] arr2 = new int[] {1, 2, 3};
		List<int[]> ls = new ArrayList<>();
		ls.add(arr1);
		ls.add(arr2);
		int[][] arr = ls.toArray(new int[2][3]);
		System.out.println(arr[0].length);
		System.out.println(arr[1].length);
			
	}
	
	public String sortString(String s) {
		char[] chArr = s.toCharArray();
        Arrays.sort(chArr);
        List<Character> ls = new LinkedList<>();
        for(char temp: chArr)
            ls.add(temp);
        StringBuilder sb = new StringBuilder();
//        boolean flag = false;
//        while(!ls.isEmpty()){
//            char record = '0';
//            if(!flag){
//                flag = true;
//                for(int i = 0; i < ls.size(); i++){
//                    if(record == '0'){
//                        record = ls.remove(i);
//                        sb.append(record);
//                        i--;
//                    } else if(ls.get(i) != record) {
//                        record = ls.remove(i);
//                        sb.append(record);
//                        i--;
//                    }
//                }
//            } else {
//                flag = false;
//                for(int i = ls.size() - 1; i > -1; i--){
//                    if(record == '0'){
//                        record = ls.remove(i);
//                        sb.append(record);
//                    } else if(ls.get(i) != record) {
//                        record = ls.remove(i);
//                        sb.append(record);
//                    }
//                }
//            }
//        }

        //一次走完整个状态循环可以省去判断步骤
        while(!ls.isEmpty()){
            char record = '0';
            for(int i = 0; i < ls.size(); i++){
                if(record == '0'){
                    record = ls.remove(i);
                    sb.append(record);
                    i--;
                } else if(ls.get(i) != record) {
                    record = ls.remove(i);
                    sb.append(record);
                    i--;
                }
            }
            record = '0';
            for(int i = ls.size() - 1; i > -1; i--){
                if(record == '0'){
                    record = ls.remove(i);
                    sb.append(record);
                } else if(ls.get(i) != record) {
                    record = ls.remove(i);
                    sb.append(record);
                }
            }
        }
        return sb.toString();
	}
	
	public String sortString2(String s) {
		int[] times = new int[26];
		for(char temp: s.toCharArray()) {
			times[temp - 'a']++;
		}
		StringBuilder res = new StringBuilder();
		while(res.length() < s.length()) {
			for(int i = 0; i < 26; i++) {
				if(times[i] > 0) {
					times[i]--;
					res.append((char)(i + 'a'));
				}
			}
			for(int i = 25; i > -1; i--) {
				if(times[i] > 0) {
					times[i]--;
					res.append((char)(i + 'a'));
				}
			}
		}
		return res.toString();
	}
	
}
