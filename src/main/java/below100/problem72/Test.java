package below100.problem72;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().minDistance("", "a"));

	}
	
	public int minDistance(String word1, String word2) { //这道题是具有最优子结构的，只是其划分成子问题时可能有多种划分方式，其实与前面的10、44等题是一样的
		int[][] dis = new int[word1.length() + 1][word2.length() + 1];	
		for(int i = 0; i <= word2.length(); i++) {
			dis[0][i] = i;
		}
		for(int i = 0; i <= word1.length(); i++) {
			dis[i][0] = i;
		}
		for(int i = 1; i <= word1.length(); i++) {
			for(int j = 1; j <= word2.length(); j++) {
				if(word1.charAt(i - 1) == word2.charAt(j - 1))
					dis[i][j] = dis[i - 1][j - 1];
				else
					dis[i][j] = Math.min(dis[i - 1][j - 1], Math.min(dis[i][j - 1], dis[i - 1][j])) + 1;
			}
		}
		return dis[word1.length()][word2.length()];
    }

}
