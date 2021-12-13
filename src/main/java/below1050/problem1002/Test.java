package below1050.problem1002;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
	}

	//Ҳ����HashMap��getOrDefault()���洢���ȶ�
	public List<String> commonChars(String[] A) {
		if(A == null || A.length == 0) return null;
		int[] count = new int[26];
		for(int i = 0; i < A[0].length(); i++) {
			count[A[0].charAt(i) - 'a']++;
		}
		for(int i = 1; i < A.length; i++) {
			int[] tempCount = new int[26];
			for(int j = 0; j < A[i].length(); j++) {
				tempCount[A[i].charAt(j) - 'a']++;
			}
			for(int j = 0; j < 26; j++)
				count[j] = Integer.min(count[j], tempCount[j]);
		}
		List<String> res = new ArrayList<>();
		for(int i = 0; i < 26; i++) {
			while(count[i] != 0) {
				res.add(String.valueOf((char)(i + 'a')));
				count[i]--;
			}
		}
			
		return res;
    }
	
}
