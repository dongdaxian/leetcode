package below100.problem70;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().climbStairs(4));
	}
	public int climbStairs(int n)          //采用动态规划思想，用分治法的话复杂度高
	{
		if(n == 0 || n == 1) return n;
		int n1 = 0, n2 = 1;
		int temp = 0;
		for(int i = 1; i < n; i++)
		{
			temp = n1 + n2;
			n1 = n2;
			n2 = temp;
		}
		return n1 + n2; 
    }

}
