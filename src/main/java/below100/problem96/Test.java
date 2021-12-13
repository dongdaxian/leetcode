package below100.problem96;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().numTrees(17));
	}
	public int numTrees(int n) {
		long k = 1;
		int i = 1;
		for(i = 1; i <= n; i++) {
			k = k * (n + i) / i;
		}
		return (int)(k/i);
    }

}
