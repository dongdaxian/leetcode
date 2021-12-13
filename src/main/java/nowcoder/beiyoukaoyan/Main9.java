package nowcoder.beiyoukaoyan;

import java.util.Scanner;

public class Main9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(sc.nextLine());
		int times = sc.nextInt();
		sc.nextLine();
		for(int k = 0; k < times; k++) {
			String command = sc.nextLine();
			int beg = command.charAt(1) - '0';
			int len = command.charAt(2) - '0';
			if(command.charAt(0) == '0') {
				StringBuilder temp = new StringBuilder(sb.substring(beg, beg + len));
				temp.reverse();
				sb = new StringBuilder(sb.substring(0, beg)).append(temp).append(sb.substring(beg + len, sb.length()));
			} else {
				sb = sb.replace(beg, beg + len, command.substring(3, command.length()));
			}
			System.out.println(sb.toString());
			
		}
				
	}
}
