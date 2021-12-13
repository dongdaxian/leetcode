package below100.problem68;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> res = new Test().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
		for(String temp: res)
			System.out.println(temp);

	}
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		int nowWidth = maxWidth;
		List<String> ls = new ArrayList<String>();				//可以用两个指针left和right代替ls的作用
		List<String> res = new ArrayList<String>();
		for(int i = 0; i < words.length;) {
			if(words[i].length() <= nowWidth) {
				nowWidth = nowWidth - words[i].length() - 1;
				ls.add(words[i]);
				i++;
			} else {
				StringBuilder temp = new StringBuilder();		//String改用StringBuilder
				nowWidth++;
				if(ls.size() == 1){								//如果只有一个，左对齐
					temp.append(ls.get(0));
					char[] ch = new char[nowWidth];
					Arrays.fill(ch, ' ');
					temp.append(ch);
					res.add(temp.toString());
				} else {			
					int size = ls.size();
					for(int j = 0; j < size - 1; j++) {
						temp.append(ls.get(j) + " ");
						char[] ch = new char[(nowWidth + size - j - 2) / (size - 1)];
						Arrays.fill(ch, ' ');
						temp.append(ch);
					}
					temp.append(ls.get(size - 1));
					res.add(temp.toString());
				}
				ls.clear();
				nowWidth = maxWidth;
			}
		}
		if(!ls.isEmpty()) {										//对于最后一行，也是左对齐
			StringBuilder temp = new StringBuilder();
			for(int j = 0; j < ls.size(); j++) 
				temp.append(ls.get(j) + " ");
			temp.deleteCharAt(temp.length() - 1);
			char[] ch = new char[nowWidth + 1];
			Arrays.fill(ch, ' ');
			temp.append(ch);
			res.add(temp.toString());
		}
		
		
		return res;
    }

}
