package below350.problem338;

public class Test {

    //时间复杂度为O(n^2)
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for (int i = 1; i <= num; i = i * 2) {
            ret[i] = 1;
            for (int j = 1; j < i && i + j <= num; j++) {
                ret[i + j] = ret[i] + ret[j];
            }
        }
        return ret;
    }

    //直接计算1的个数，时间复杂度O(nlogn)
    public int[] countBits2(int num) {
        int[] ret = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int tmp = i;
            while (tmp > 0) {
                tmp = tmp & (tmp - 1);
                ret[i]++;
            }
        }

        return ret;
    }
}
