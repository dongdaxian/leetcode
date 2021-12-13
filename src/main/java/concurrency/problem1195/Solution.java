package concurrency.problem1195;

import java.util.function.IntConsumer;

public class Solution {

	public static void main(String[] args) {
		FizzBuzz2 fb = new FizzBuzz2(15);
		new Thread(() -> {
			try {
				fb.buzz(() -> {System.out.println("buzz");});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				fb.fizz(() -> {System.out.println("fizz");});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				fb.fizzbuzz(() -> {System.out.println("fizzbuzz");});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
			fb.number(new IntConsumer() {
				@Override
				public void accept(int value) {
					System.out.println(value);
				}
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}).start();
		
		

	}

}
