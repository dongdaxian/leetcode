package nowcoder.renshou;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < n; i++) {
            queue.add(nums[i]);
            queue.poll();
        }
        System.out.print(queue.poll());
    }




}
