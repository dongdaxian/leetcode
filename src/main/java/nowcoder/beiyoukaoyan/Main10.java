package nowcoder.beiyoukaoyan;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main10 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		PriorityQueue<Complex> queue = new PriorityQueue<>(new Comparator<Complex>() {
			public int compare(Complex o1, Complex o2) {
				if(o1.z == o2.z)
					return o1.b - o2.b;
				return o2.z - o1.z;
			}
		});
		for(int k = 0; k < num; k++) {
			String temp = sc.nextLine();
			if(temp.charAt(0) == 'P') {
				if(queue.isEmpty())
					System.out.println("empty");
				else {
					System.out.println(queue.poll());
					System.out.println("SIZE = " + queue.size());
				}
			} else {
				int fir = Integer.parseInt(temp.substring(7, temp.indexOf('+')));
				int sec = Integer.parseInt(temp.substring(temp.indexOf('i') + 1, temp.length()));
				Complex cmp = new Complex(fir, sec);
				queue.add(cmp);
				System.out.println("SIZE = " + queue.size());
			}
		}
	}
}
class Complex {
	int a;
	int b;
	int z;
	public Complex(int a, int b) {
		this.a = a;
		this.b = b;
		this.z = a * a + b * b;
	}
	@Override
	public String toString() {
		return this.a + "+i" + this.b;
	}
	
}
