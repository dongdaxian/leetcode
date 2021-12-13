package nowcoder.beiyoukaoyan;

import java.util.Scanner;
import java.util.TreeSet;

public class Main7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String mCards = sc.nextLine();
		String uCards = sc.nextLine();
		int len = uCards.length();
		boolean flag = false;
		if(len < 5) {
			char[] ch = mCards.toCharArray();
			for(int i = 0; i + len - 1< ch.length; i++) {
				if(ch[i] > uCards.charAt(0) && ch[i + len - 1] == ch[i])
					flag = true;
			}
		} else {
			TreeSet<Character> set = new TreeSet<>();
			for(char ch: mCards.toCharArray())
				set.add(ch);
			char pre = set.pollLast();
			int slen = 1;
			while(!set.isEmpty()) {
				if(set.last() == pre - 1)
					slen++;
				else
					slen = 1;
				pre = set.pollLast();
				if(slen == 5 && pre >= uCards.charAt(0))
					flag = true;
			}
		}
		if(flag)
			System.out.print("YES");
		else
			System.out.print("NO");

	}

}
