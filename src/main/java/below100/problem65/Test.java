package below100.problem65;

import java.util.HashSet;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().isNumber2(" .  "));
	}
	
	public boolean isNumber1(String s) {
		if(s == null) return false;
		s = s.trim();					//ȥ����β�ո�
		if(s.isEmpty() || "dDfF".contains(s.substring(s.length() - 1)))    //�����ĺϷ����룬����'.1','1.'����,��ʵ����ӦDouble.parseDouble()�ĺϷ����룬 
			return false;												   //��������ĩβ����dDfF��һ��
		try{
			Double.parseDouble(s);							//�ڰ�������ֳ������ֵ��������0�����Ƿ��ظ����ֵ�����Բ�����Integer.parseInteger()
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean isNumber2(String s) {                    //�Զ�����leetcode�ʼ���
		s = s.trim();
		if(s.isEmpty()) return false;
		int i = 0, state = 0;
		for(i = 0, state = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
			case '+':
			case '-':
				if(state == 0)
					state = 1;
				else if(state == 4)
					state = 6;
				else
					return false;
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				if(state == 0 || state == 1 || state == 2)
					state = 2;
				else if(state == 7 || state == 8)
					state = 8;
				else if(state == 4 || state == 5 || state == 6)
					state = 5;
				else if(state == 3)
					state = 3;
				else
					return false;
				break;
			case '.':
				if(state == 0 || state == 1)
					state = 7;
				else if(state == 2)
					state = 3;
				else
					return false;
				break;
			case 'e':
				if(state == 2 || state == 3 || state == 8)
					state = 4;
				else
					return false;
				break;
			default:
				return false;
					
			}
			
		}
		return state == 2 || state == 3 || state == 5 || state == 8;
	}
	
	public boolean isNumber3(String s) {				//һ���˼·�Ǳ�����������ʱ��return false����������ĩβʱ˵���ַ������ϸ�ʽ����ʵ������Զ�����һ�֡�
		s = s.trim();									//��������Ҫ��ֻ����һ�ֽ���״̬��ʵ��̫�鷳�����ǿ����ý���״̬�༸�֣����緽��2�Ľ���״̬�ж��		
	    boolean pointSeen = false;						//����3���Ƿ���2�ļ�
	    boolean eSeen = false;							
	    boolean numberSeen = false;
	    boolean numberAfterE = true;
	    for(int i = 0; i < s.length(); i++) {
	        if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
	            numberSeen = true;
	            numberAfterE = true;
	        } else if(s.charAt(i) == '.') {
	            if(eSeen || pointSeen) {
	                return false;
	            }
	            pointSeen = true;
	        } else if(s.charAt(i) == 'e') {
	            if(eSeen || !numberSeen) {
	                return false;
	            }
	            numberAfterE = false;
	            eSeen = true;
	        } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
	            if(i != 0 && s.charAt(i-1) != 'e') {
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }
	    
	    return numberSeen && numberAfterE;
	}
	
	
	
	public boolean isNumber4(String s) {								  //��������ʽ�ķ���
		s = s.trim();
		if(s.isEmpty()) return false;
		String regex = "[-+]?((\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?)";		//������ \\d*\\.?\\d* ����ֹ����Ϊ . 
		if(s.matches(regex))
			return true;
		return false;
	}

}
