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
    	
    	//这样才能过
    	int len = (int)Math.sqrt(num);
        for(int i = 2; i <= len; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
    
    
    //埃式筛   合数一定是一个质数的倍数
    public int countPrimes2(int n) {
    	int[] isPrime = new int[n];
    	//1代表是质数
    	Arrays.fill(isPrime, 1);
    	int res = 0;
    	for(int i = 2; i < n; i++) {
    		if(isPrime[i] == 1) {
    			res++;
    			//判断时转long防止溢出，后面不需要
    			if((long)i * i < n) {
    				//从i * i开始标注，因为2i、3i、(i - 1)*i之前已经被标注过了
    				for(int j = i * i; j < n; j += i) {
    					isPrime[j] = 0;
    				}
    			}
    		}
    	}
    	return res;
    }
	
}
