package below50.problem12;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().intToRoman2(44));
	}
	
	public String intToRoman1(int num) {									
		char[] charsym = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		int[] intsym = new int[]{1000, 500, 100, 50, 10, 5, 1};
		String rs = "";
		for(int i = 0, times = 0; i < 7; i++, times = 0) {
			times = num/intsym[i];
			num = num%intsym[i];
			if(times == 4 && (i == 2 || i == 4 || i == 6)){
				if(rs.length() > 0 && rs.charAt(rs.length() - 1) == charsym[i -1])
					rs = rs.substring(0, rs.length() - 1) + charsym[i] + charsym[i - 2];
				else
					rs = rs + charsym[i] + charsym[i - 1];
			} else {
				for(int j = 0; j < times; j++)
					rs += charsym[i];
			}
		}
		
		return rs;
    }
	
	public String intToRoman2(int num) {			
		//最初思路是只用遍历一次，所以在函数里写七块，每一块处理对应罗马数字，然后发现每一块的处理都类似，所以想到用一个for循环可以减少重复代码，当然要处理特殊情况
		//方法2直接把特殊情况去掉了。这说明不一定要按照题中给的思路走
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i=0;i<values.length;i++) {
	        while(num >= values[i]) {
	            num -= values[i];
	            sb.append(strs[i]);
	        }
	    }
	    return sb.toString();
		
	}

}
