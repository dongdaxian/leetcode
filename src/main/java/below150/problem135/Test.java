package below150.problem135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {
	public static void main(String[] args) {
		System.out.println(new Test().candy2(new int[]{1, 2, 2}));
	}
	public int candy(int[] ratings) {
		int bptr = 0, eptr = 0;
		int sum = 1;
		while(eptr < ratings.length - 1) {
			while(eptr < ratings.length - 1 && ratings[eptr + 1] > ratings[eptr])
				eptr++;
			int left = eptr - bptr;
			bptr = eptr;
			while(eptr < ratings.length - 1 && ratings[eptr + 1] < ratings[eptr])
				eptr++;
			int right = eptr - bptr;
			bptr = eptr;
			sum += (1 + left) * left / 2 + (1 + right) * right / 2 + Integer.max(left, right);
			while(eptr < ratings.length - 1 && ratings[eptr + 1] == ratings[eptr]) {
				eptr++;
				sum++;
			}
			bptr = eptr;
		}
		return sum;
    }
	
	public int candy2(int[] ratings) {
		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);
		for(int i = 0; i < ratings.length - 1; i++) {
			if(ratings[i + 1] > ratings[i]) {
				candy[i + 1] = candy[i] + 1;
			}
		}
		for(int i = ratings.length - 1; i > 0; i--) {
			if(ratings[i - 1] > ratings[i] && candy[i - 1] <= candy[i]) {
				candy[i - 1] = candy[i] + 1;
			}
		}
		int candies = 0;
		for(int k: candy)
			candies += k;
		return candies;
	}
	
}
