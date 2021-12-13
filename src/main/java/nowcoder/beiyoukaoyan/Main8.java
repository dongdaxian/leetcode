package nowcoder.beiyoukaoyan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		List<List<Integer>> ls = new ArrayList<>();
		int level = 1;
		int i = 0;
		while(i < len) {
			List<Integer> temp = new ArrayList<>();
			ls.add(temp);
			for(int record = 0; record < Math.pow(2, level - 1) && i < len; record++, i++) {
				temp.add(sc.nextInt());
			}
			level++;
		}
		int m = sc.nextInt() - 1;
		if(m < ls.size()) {
			List<Integer> temp = ls.get(m);
			for(int j = 0; j < temp.size(); j++) {
				System.out.print(temp.get(j));
				if(j != temp.size() - 1)
					System.out.print(" ");
			}
		}
		else
			System.out.print("EMPTY");
		
	}

}
