package below250.problem204;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		System.out.println((int)Math.sqrt(8));
	}
	
	public int countPrimes(int n) {
        int res = 0;
        for(int i = 2; i < n; i++){
            if(isPrime(i))
                res++;
        }
        return res;
    }
    public boolean isPrime(int num){
//        for(int i = 2; i <= (int)Math.sqrt(num); i++){
    	
    	//�������ܹ�
    	int len = (int)Math.sqrt(num);
        for(int i = 2; i <= len; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
    
    
    //��ʽɸ   ����һ����һ�������ı���
    public int countPrimes2(int n) {
    	int[] isPrime = new int[n];
    	//1����������
    	Arrays.fill(isPrime, 1);
    	int res = 0;
    	for(int i = 2; i < n; i++) {
    		if(isPrime[i] == 1) {
    			res++;
    			//�ж�ʱתlong��ֹ��������治��Ҫ
    			if((long)i * i < n) {
    				//��i * i��ʼ��ע����Ϊ2i��3i��(i - 1)*i֮ǰ�Ѿ�����ע����
    				for(int j = i * i; j < n; j += i) {
    					isPrime[j] = 0;
    				}
    			}
    		}
    	}
    	return res;
    }
	
}
