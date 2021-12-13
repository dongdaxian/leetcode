package nowcoder.beiyoukaoyan;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		Queue<Integer> queue = new PriorityQueue<>(); 
		for(int i = 0; i < len; i++) {
			queue.offer(sc.nextInt());
		}
		int sum = 0;
		while(!queue.isEmpty()) {
			int addSum = 0;
			addSum += queue.poll();
			if(!queue.isEmpty()) {
				addSum += queue.poll();
				queue.add(addSum);
				sum += addSum;
			}
			
		}
		System.out.println(sum);
	}
}
