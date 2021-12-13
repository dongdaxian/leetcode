package below150.problem115;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().numDistinct("raabab", "rab"));
	}
	
	public int numDistinct(String s, String t) {
		int[][] res = new int[t.length() + 1][s.length() + 1];
		for(int i = 0; i < s.length() + 1; i++)
			res[0][i] = 1;
			
		for(int i = 1; i < t.length() + 1; i++)
			for(int j = i; j < s.length() + 1; j++)
				if(s.charAt(j - 1) == t.charAt(i - 1))
					res[i][j] = res[i - 1][j - 1] + res[i][j - 1];
				else
					res[i][j] = res[i][j - 1];
			
		return res[t.length()][s.length()];
    }
}
