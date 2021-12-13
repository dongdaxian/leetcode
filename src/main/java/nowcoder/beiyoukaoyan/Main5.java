package nowcoder.beiyoukaoyan;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int len = sc.nextInt();
			int n = sc.nextInt();
			int[] sample1 = new int[len * len];
			int[] sample2 = new int[len * len];
			int[] res = new int[len * len];
			for(int i = 0; i < len * len; i++)
				sample1[i] = sample2[i] = sc.nextInt();
			for(int record = 0; record < n - 1; record++) {
				for(int i = 0; i < len * len; i++) {
					res[i] = 0;
					int xlen = i / len;
					int ylen = i % len;
					for(int j = 0; j < len; j++) {
						res[i] += (sample1[xlen * len + j] * sample2[j * len + ylen]);
					}
				}
				int[] temp = res;
				res = sample1;
				sample1 = temp;
			}
			for(int i = 0; i < len * len; i++)
				if((i + 1) % len == 0)
					System.out.println(sample1[i]);
				else
					System.out.print(sample1[i] + " ");
		}

	}

}
