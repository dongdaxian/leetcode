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
                	//�����Stack��ֻ��ͨ���ݹ麯����������while�м�����ѭ������ʱpush����������9
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
	
	//�������ң�һ������strN[i - 1] <= strN[i]��ʣ�²���ȫ��9��������һ�ǰ��Ѿ�������������9
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
