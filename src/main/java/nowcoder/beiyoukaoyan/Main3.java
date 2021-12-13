package nowcoder.beiyoukaoyan;

import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		LinkedList<Integer> ls = new LinkedList<>();
		for(int i = 0; i < len; i++)
			ls.addLast(sc.nextInt());
		int flag = 0;
		while(!ls.isEmpty()) {
			if(ls.poll() % 2 == 0)
				flag++;
			else
				flag--;
		}
		if(flag > 0)
			System.out.println("NO");
		else
			System.out.println("YES");
		
	}
	
}
