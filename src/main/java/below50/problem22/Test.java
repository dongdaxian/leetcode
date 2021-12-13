package below50.problem22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> ls = new Test().generateParenthesis3(3);
		for(String temp: ls) {
			System.out.println(temp);
		}

	}
	
	public List<String> generateParenthesis1(int n) {						//回溯法
        List<String> ls = new LinkedList<>();
        String pare = "";
        generatePare(n, n, pare, ls);
		return ls;
    }
	public void generatePare(int left, int rig, String pare, List<String> ls) {
		if(left == 0 && rig == 0)
			ls.add(pare);
		if(left > 0) 
			generatePare(left - 1, rig, pare + "(", ls);
		if(rig > left) 
			generatePare(left, rig - 1, pare + ")", ls);
	}
	
	
	public List<String> generateParenthesis2(int n) {					//分治法
		List<String> result = new ArrayList<String>();
		if (n == 0) {
			result.add("");
		} else {
			for (int i = n - 1; i >= 0; i--) {
				List<String> insertSub = generateParenthesis2(i);
				List<String> tailSub = generateParenthesis2(n - 1 - i);
				for (String insert : insertSub) {
					for (String tail : tailSub) {
						result.add("(" + insert + ")" + tail);
					}
				}

			}
		}
		return result;
	}
	
	
	public List<String> generateParenthesis3(int n) {				//动态规划
		List<List<String>> ls = new ArrayList<>();
		ls.add(new ArrayList<>());
		ls.get(0).add("");
		
		for(int i = 1; i <= n; i++) {
			List<String> temp = new ArrayList<>();
			for(int j = 0; j < i; j++) {
				for(String beg: ls.get(j))
					for(String end: ls.get(i - j - 1))
						temp.add("(" + beg + ")" + end);
			}
			ls.add(temp);
		}
		return ls.get(n);
	}

}
