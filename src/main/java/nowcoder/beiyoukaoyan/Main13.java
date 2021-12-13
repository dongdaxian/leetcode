package nowcoder.beiyoukaoyan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		Set<Integer> set = new HashSet<>();
		for(int k = 0; k < len; k++)
			set.add(sc.nextInt());
		int num = sc.nextInt();
		for(int k = 0; k < num; k++) {
			if(set.contains(sc.nextInt()))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
