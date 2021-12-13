package below50.problem10;

public class Test {

	public static void main(String[] args) {
		String s = "abc";
		String p = "c*a*b*c*";
		System.out.print(new Test().isMatch(s, p));
	}
	
	public boolean isMatch(String s, String p) {    //��Ϊs��p��match����s-1��p-1��match��s��p-1��match��s-1��p��match�Ľ���йأ����Կ����ö�̬�滮
		if(s == null || p == null) return false;
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		
		dp[0][0] = true;
		for(int j = 0; j < p.length(); j++) {
			if(p.charAt(j) == '*' && dp[0][j - 1])
				dp[0][j + 1] = true;
		}
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < p.length(); j++) {
				if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
					dp[i + 1][j + 1] = dp[i][j];       							//�������ά��û�ж�����1��Ӧ��dp[i][j]=dp[i-1][j-1]����Ҫ����i=0��j=0�����
				else if(p.charAt(j) == '*') {
					if(p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.')
						dp[i + 1][j + 1] = dp[i + 1][j - 1];                               		  //*��ʾǰԪ����0��
					else {
						dp[i + 1][j + 1] = (dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1]);    //*��ʾǰԪ����0��/ǰԪ����1��/ǰԪ���ټ�1��
					}
				}
			}
		}
		
		return dp[s.length()][p.length()];
		
    }

}
