package below100.problem69;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().mySqrt2(2147395599));
    }

    public int mySqrt1(int x) {
        return (int) Math.sqrt(x);
    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;
        int start = 1, end = x;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {  //如果用mid * mid，会溢出，导致本该大于x的反而小于x
                return mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }

}
