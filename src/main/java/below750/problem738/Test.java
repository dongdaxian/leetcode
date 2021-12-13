package below750.problem738;

import java.util.Arrays;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
	}
	
	public int monotoneIncreasingDigits(int N) {
        if(N == 0)
            return 0;
        String str = String.valueOf(N);
        int len = str.length();
        int[] res = new int[len]; 
        for(int i = len - 1; i > -1; i--){
        	int temp = str.charAt(i) - '0'; 
            if(i == len - 1){
                res[i] = temp;
            } else {
                if(temp <= res[i + 1])
                    res[i] = temp;
                else{
                	//如果是Stack，只能通过递归函数，或者在while中计数，循环结束时push计数个数的9
                    Arrays.fill(res, 9);
                    res[i] = temp - 1;
                }
            }
        }
        int num = 0;
        for(int tempNum: res)
        	num = num * 10 + tempNum;
        return num;
    }
	
	//从左往右，一旦发生strN[i - 1] <= strN[i]，剩下部分全置9，而方法一是把已经遍历过部分置9
	public int monotoneIncreasingDigits2(int N) {
        char[] strN = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
	
}
