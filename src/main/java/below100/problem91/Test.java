package below100.problem91;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().numDecodings2("00"));

	}
	
	public int numDecodings(String s) {
		if(s == null || s.isEmpty()) return 0;
		char[] ch = s.toCharArray();
		return numDecodings(ch, 0);
    }
	public int numDecodings(char[] ch, int beg) {
		if(beg == ch.length)
			return 1;
		if(ch[beg] == '0')
			return 0;
		if(beg + 1 < ch.length && (ch[beg] - '0') * 10 + ch[beg + 1] - '0' < 27) {
			return numDecodings(ch, beg + 1) + numDecodings(ch, beg + 2);
		}
		return numDecodings(ch, beg + 1);
	}
	
	//动态规划
	public int numDecodings2(String s) {
		if(s == null || s.isEmpty()) return 0;
		char[] ch = s.toCharArray();
		int[] times = new int[ch.length + 1];
		times[ch.length] = 1;
		for(int i = ch.length - 1; i > -1; i--) {
			if(ch[i] == '0')
				times[i] = 0;
			else if(i + 1 < ch.length && (ch[i] - '0') * 10 + ch[i + 1] - '0' < 27)
				times[i] = times[i + 1] + times[i + 2];
			else
				times[i] = times[i + 1];
		}
		return times[0];
    }

}
