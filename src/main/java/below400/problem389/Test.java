package below400.problem389;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	//�����ַ���������ڹ�ϣ������ó���26��int[]
	public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char temp: s.toCharArray()){
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        for(char temp: t.toCharArray()){
            if(!map.containsKey(temp) || map.get(temp) == 0){
                return temp;
            }
            map.put(temp, map.get(temp) - 1);
        }
        return ' ';
    }
	
	public char findTheDifference2(String s, String t) {
		int sums = 0;
		int sumt = 0;
		for(char temp: s.toCharArray())
			sums += temp;
		for(char temp: t.toCharArray())
			sumt += temp;
		return (char)(sumt - sums);
    }
	
	//������˼·
	public char findTheDifference3(String s, String t) {
		int res = 0;
		for(char temp: s.toCharArray())
			res ^= temp;
		for(char temp: t.toCharArray())
			res ^= temp;
		return (char)res;
	}
}
