package nowcoder.beiyoukaoyan;

import java.util.Scanner;
import java.util.TreeSet;

public class Main4 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		for(int i = 0; i < len; i++)
			set.add(sc.nextInt());
		int k = sc.nextInt();
		for(int i = 0; i < k - 1; i++)
			set.pollFirst();
		System.out.println(set.pollFirst());
	}
}
