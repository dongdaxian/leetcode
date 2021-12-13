package below50.problem8;


public class Test {
	
	public static void main(String[] args) {
		String str = "   -42";
		System.out.println(new Test().myAtoi(str));
//		char s = "asd".charAt(0);
//		System.out.println("asd".charAt(1) - 'a');
	}
	
	public int myAtoi(String str) {
		Long result = 0L;
		boolean flag = true;
		int i = 0;
		
		if(str.isEmpty()) return 0;
		
//		for(i = 0; i < str.length() && str.charAt(i) == ' '; i++);
//		str = str.substring(i);
		str.trim();
		
		if(0 == str.length()) return 0;
		if(str.charAt(0) == '-'){
			flag = false;
			str = str.substring(1);
		}else if(str.charAt(0) == '+'){
			str= str.substring(1);
		}
		
		for(i = 0; i < str.length() && str.charAt(i) == '0'; i++);
		str = str.substring(i);
		
		
		for(i = 0; i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0'; i++){
			if(i > 10) break;
			result = result * 10 + str.charAt(i) - '0'; 
		}
		
		if(flag){
			if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			return result.intValue();
		}
		else if(!flag){
			if(-1 * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
			return -1 * result.intValue();
		}
		return 0;
    }

}
