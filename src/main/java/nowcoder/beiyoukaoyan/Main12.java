package nowcoder.beiyoukaoyan;

import java.util.Scanner;

public class Main12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		for(int k = 0; k < num - 1; k++) {
			int tempx = sc.nextInt();
			int tempy = sc.nextInt();
			if(tempx < x) {
				x = tempx;
				y = tempy;
			} else if(tempx == x) {
				y = Math.min(y, tempy);
			}
		}
		System.out.print(x + " " + y);
	}

}
