package nowcoder.beiyoukaoyan;

import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] matrix = new int[6][6];
		for(int i = 1; i < 6; i++)
			for(int j = 1; j < 6; j++)
				matrix[i][j] = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		for(int i = 1; i < 6; i++) {
			for(int j = 1; j < 6; j++) {
				if(i >= x && i < x + b && j >= y && j < y + b) {
					if(a == 1) {
						System.out.print(matrix[x + y + b - j - 1][y + i - x]);
					} else {
						System.out.print(matrix[x + j - y][y + x + b - i - 1]);
					}
				}
				else
					System.out.print(matrix[i][j]);
				if(j != 5)
					System.out.print(" ");
			}
			System.out.println();
		}
					

	}

}
