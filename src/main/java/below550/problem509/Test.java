package below550.problem509;

public class Test {
	
	public static void main(String[] args) {
		
	}
	
	public int fib(int n) {
        if(n == 0)
            return 0;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
