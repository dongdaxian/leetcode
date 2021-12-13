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
		//���˼·��ֻ�ñ���һ�Σ������ں�����д�߿飬ÿһ�鴦���Ӧ�������֣�Ȼ����ÿһ��Ĵ������ƣ������뵽��һ��forѭ�����Լ����ظ����룬��ȻҪ�����������
		//����2ֱ�Ӱ��������ȥ���ˡ���˵����һ��Ҫ�������и���˼·��
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
