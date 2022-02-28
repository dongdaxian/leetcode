package nowcoder.jianzhi;

public class Solution16 {

    public double Power(double base, int exponent) {
        double ret = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            ret *= base;
        }
        return exponent < 0 ? 1 / ret : ret;
    }
}
