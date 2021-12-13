package below350.problem338;

public class Test {

    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for(int i = 1; i <= num; i = i * 2) {
            ret[i] = 1;
            for(int j = 1; j < i && i + j <= num; j++) {
                ret[i + j] = ret[i] + ret[j];
            }
        }
        return ret;
    }
}
