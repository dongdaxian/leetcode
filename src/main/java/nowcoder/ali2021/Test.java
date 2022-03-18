package nowcoder.ali2021;

import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {

        int[] tmp = IntStream.rangeClosed(0, 5).toArray();
        for (int i: tmp)
            System.out.print(i);
    }
}
