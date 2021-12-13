package concurrency.problem1116;

import java.util.function.IntConsumer;

public class Test {
	public static void main(String[] args) throws Exception{
		ZeroEvenOdd zeo = new ZeroEvenOdd(5);
		IntConsumer ic = (int x) -> System.out.println(x);
		new Thread(() -> {
			try {
				zeo.zero(ic);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}}).start();
		new Thread(() -> {
			try {
				zeo.odd(ic);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}}).start();
		new Thread(() -> {
			try {
				zeo.even(ic);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}}).start();
		
	}
}
