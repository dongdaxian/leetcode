package below100.problem96;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().numTrees2(3));
    }

    public int numTrees(int n) {
        long k = 1;
        int i = 1;
        for (i = 1; i <= n; i++) {
            k = k * (n + i) / i;
        }
        return (int) (k / i);
    }

	public int numTrees2(int n) {
		int[] ret = new int[n + 1];
		ret[0] = 0;
		ret[1] = 1;
		for (int i = 2; i <= n; i++) {
			ret[i] += ret[i - 1] * 2;
			for (int j = 1; j < i - 1; j++) {
				ret[i] += ret[j] * ret[i - 1 - j];
			}
		}
		return ret[n];
	}


	public int numTrees3(int n) {
		int[] G = new int[n + 1];
		G[0] = 1;
		G[1] = 1;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				G[i] += G[j - 1] * G[i - j];
			}
		}
		return G[n];
	}

}
