package nowcoder.alibishi;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        int[] tmp = IntStream.rangeClosed(0, 5).toArray();
        for (int i: tmp)
            System.out.print(i);
    }
}
